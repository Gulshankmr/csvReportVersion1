package com.project1.csvReport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
			
	//		String updateQuery = ("update donations set Norm_Amount = ?, Norm_Fee = ?"
	//				+ " where Order_id = ?");
			
			ResultSet myRs = myStmt.executeQuery("select Order_id, Donation_Curr, "
					+ " Donation_Amount, Fee from Donations");
			
			HashMap<String, List<Double>> map  = new HashMap<>();
			 MyCurrencyConverter CurrCon = new MyCurrencyConverter();
			
			String fromCurrency;
			String toCurrency;
			
			ArrayList<Double> values;
			double currentValue;
			while(myRs.next()) {
				fromCurrency = myRs.getString(2);
				values = new ArrayList<Double>();
		    	 try {
					currentValue = CurrCon.convert(fromCurrency, cur);
					
					values.add(currentValue*myRs.getDouble(3));
					values.add(currentValue*myRs.getDouble(4));
					map.put(myRs.getString(1), values);
				//	values.clear();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
