package com.project1.csvReport;

public class DonationDetailNormalized {
	
	public DonationDetailNormalized(String non_profit, Double normalized_Amount, Double normalized_Fee) {
		super();
		Non_profit = non_profit;
		Normalized_Amount = normalized_Amount;
		Normalized_Fee = normalized_Fee;
	}
	private String Non_profit;
	private Double Normalized_Amount;
	private Double Normalized_Fee;
	public String getNon_profit() {
		return Non_profit;
	}
	public void setNon_profit(String non_profit) {
		Non_profit = non_profit;
	}
	public Double getNormalized_Amount() {
		return Normalized_Amount;
	}
	public void setNormalized_Amount(Double normalized_Amount) {
		Normalized_Amount = normalized_Amount;
	}
	public Double getNormalized_Fee() {
		return Normalized_Fee;
	}
	public void setNormalized_Fee(Double normalized_Fee) {
		Normalized_Fee = normalized_Fee;
	}

}
