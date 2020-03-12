package com.project1.csvReport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NormalizeAmount {
	private double NormAmt;
	private double NormFee;
	public void normalize(Connection conn) {
		// TODO Auto-generated method stub
		Statement myStmt;
		try {
			myStmt = conn.createStatement();
			
			System.out.println("Enter the Currency in which you want the report");
			Scanner sc=new Scanner(System.in);
			String cur = sc.next();
			
			String updateQuery = ("update donations set Norm_Amount = ?, Norm_Fee = ?"
					+ " where Order_id = ?");
			
			ResultSet myRs = myStmt.executeQuery("select Order_id, Donation_Curr, "
					+ " Donation_Amount, Fee from Donations");
			
			 MyCurrencyConverter CurrCon = new MyCurrencyConverter();
			
			String fromCurrency;
			String toCurrency;
			while(myRs.next()) {
				fromCurrency = myRs.getString(2);
			}
			
			
			
			
		//	 CurrCon.convert(FROM, cur);
			
			
			while(myRs.next()) {
				System.out.println(myRs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
