package com.project1.csvReport;

public class DonationDetails {

	public DonationDetails(String non_profit, String donation_Currency, Double donation_Amount, Double fee) {
		super();
		Non_profit = non_profit;
		Donation_Currency = donation_Currency;
		Donation_Amount = donation_Amount;
		Fee = fee;
	}

	private String Non_profit;
	private String Donation_Currency;
	private Double Donation_Amount;
	private Double Fee;

	public String getNon_profit() {
		return Non_profit;
	}

	public void setNon_profit(String non_profit) {
		Non_profit = non_profit;
	}

	public String getDonation_Currency() {
		return Donation_Currency;
	}

	public void setDonation_Currency(String donation_Currency) {
		Donation_Currency = donation_Currency;
	}

	public Double getDonation_Amount() {
		return Donation_Amount;
	}

	public void setDonation_Amount(Double donation_Amount) {
		Donation_Amount = donation_Amount;
	}

	public Double getFee() {
		return Fee;
	}

	public void setFee(Double fee) {
		Fee = fee;
	}

}
