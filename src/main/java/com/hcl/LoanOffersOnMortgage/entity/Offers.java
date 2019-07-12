package com.hcl.LoanOffersOnMortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offers")
public class Offers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long offerId;
	 private double loanAmount;
	 private int tenure;
	 private float rateOfInterest;
	 
	 
	public long getOfferId() {
		return offerId;
	}
	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}
	public double getLoan_amount() {
		return loanAmount;
	}
	public void setLoan_amount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRate_of_interest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	 
	 

}
