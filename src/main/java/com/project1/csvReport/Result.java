package com.project1.csvReport;

public class Result {
	
	public Result(String nonProfit, Double totalAmount, Double totalFee, int numberOfDonations) {
		super();
		this.nonProfit = nonProfit;
		this.totalAmount = totalAmount;
		this.totalFee = totalFee;
		this.numberOfDonations = numberOfDonations;
	}
	private String nonProfit;
	private Double totalAmount;
	private Double totalFee;
	private int numberOfDonations;
	
	
	
	
	public String getNonProfit() {
		return nonProfit;
	}
	public void setNonProfit(String nonProfit) {
		this.nonProfit = nonProfit;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	public int getNumberOfDonations() {
		return numberOfDonations;
	}
	public void setNumberOfDonations(int numberOfDonations) {
		this.numberOfDonations = numberOfDonations;
	}

}
