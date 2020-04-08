package com.project1.csvReport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleValidator {

	public boolean validate(String[] nextRecord) {
		// TODO Auto-generated method stub

		String alphaNumRegex = "^[A-Za-z0-9]+$";
		String strWithSpace = "^[A-Za-z_ ]+$";
		String currRegex = "^[A-Z]{3}";

		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		sdfrmt.setLenient(false);

		try {
			Date donationDate = sdfrmt.parse(nextRecord[0]);
		} catch (ParseException e) {
			System.out.println(nextRecord[0] + " is Invalid Date format");
			return false;
		}

		if (!(nextRecord[1].matches(alphaNumRegex))) {
			System.out.println(nextRecord[1] + " is Invalid OrderId");
			return false;
		}

		if (!(nextRecord[2].matches(strWithSpace))) {
			System.out.println(nextRecord[2] + " is Invalid NonProfit");
			return false;
		}

		if (!(nextRecord[3].matches(currRegex))) {
			System.out.println(nextRecord[3] + " is Invalid Currency");
			return false;
		}

		try {
			double d = Double.parseDouble(nextRecord[4]);
		} catch (NumberFormatException nfe) {
			System.out.println(nextRecord[4] + " is Invalid Amount");
			return false;
		}
		try {
			double fee = Double.parseDouble(nextRecord[5]);
		} catch (NumberFormatException nfe) {
			System.out.println(nextRecord[5] + " is Invalid Fee");
			return false;
		}
		return true;
	}

}
