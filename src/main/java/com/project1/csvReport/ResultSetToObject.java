package com.project1.csvReport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultSetToObject {

	public static List<DonationDetails> getObject(Connection conn, String cur) throws SQLException {

		List<DonationDetails> convertedList = new ArrayList();
		Statement myStmt;
		myStmt = conn.createStatement();
		ResultSet myRs = myStmt
				.executeQuery("select  Non_profit, Donation_Curr, " + " Donation_Amount, Fee from Donations");

		DonationDetails currentDonation;
		while (myRs.next()) {

			currentDonation = new DonationDetails(myRs.getString("Non_profit"), myRs.getString("Donation_Curr"),
					myRs.getDouble("Donation_Amount"), myRs.getDouble("Fee"));

			convertedList.add(currentDonation);

		}

		return convertedList;

	}
}
