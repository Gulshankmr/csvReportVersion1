package com.project1.csvReport;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class NormalizeAmount {

	public static List<DonationDetailNormalized> getConvertedList(Connection conn, String cur) throws Exception {

		ResultSetToObject rsto = new ResultSetToObject();
		List<DonationDetails> inputData = rsto.getObject(conn, cur);

		List<DonationDetailNormalized> convertedData = new ArrayList();

		DonationDetailNormalized currentOutRecord;

		MyCurrencyConverter CurrCon = new MyCurrencyConverter();
		double currentValue;

		for (DonationDetails details : inputData) {

			currentValue = CurrCon.convert(details.getDonation_Currency(), cur);

			currentOutRecord = new DonationDetailNormalized(details.getNon_profit(),
					details.getDonation_Amount() * currentValue, details.getFee() * currentValue);

			convertedData.add(currentOutRecord);
		}

		return convertedData;
	}
}
