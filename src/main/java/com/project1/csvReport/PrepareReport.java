package com.project1.csvReport;

import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrepareReport {
	public void getReport(Connection conn) {

		System.out.println("Enter the Currency in which you want the report");
		Scanner sc = new Scanner(System.in);
		String cur = sc.next();
		List<DonationDetailNormalized> convertedList = Collections.emptyList();

		Map<String, Result> result = new HashMap<>();

		double amount;
		double fee;
		int count;
		try {
			convertedList = NormalizeAmount.getConvertedList(conn, cur);

			for (DonationDetailNormalized donationDetailNormalized : convertedList) {

				amount = donationDetailNormalized.getNormalized_Amount();
				fee = donationDetailNormalized.getNormalized_Fee();
				count = 1;

				if (result.containsKey(donationDetailNormalized.getNon_profit())) {

					Result existingDetails = result.get(donationDetailNormalized.getNon_profit());

					amount += existingDetails.getTotalAmount();
					fee += existingDetails.getTotalFee();
					count += existingDetails.getNumberOfDonations();

					Result updatedDetail = new Result(donationDetailNormalized.getNon_profit(), amount, fee, count);
					result.replace(donationDetailNormalized.getNon_profit(), updatedDetail);
				} else {

					result.put(donationDetailNormalized.getNon_profit(),
							new Result(donationDetailNormalized.getNon_profit(), amount, fee, count));
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Printing converted list....");

		result.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue().getTotalAmount() + " "
					+ entry.getValue().getTotalFee() + " " + entry.getValue().getNumberOfDonations());
		});

		sc.close();

	}

}
