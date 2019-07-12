package com.hcl.LoanOffersOnMortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="property_rates")
public class PropertyRates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long property_rates_Id;
	private int pincode;
	private double squre_feet_value;
	
	
	public long getProperty_rates_Id() {
		return property_rates_Id;
	}
	public void setProperty_rates_Id(long property_rates_Id) {
		this.property_rates_Id = property_rates_Id;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public double getSqure_feet_value() {
		return squre_feet_value;
	}
	public void setSqure_feet_value(double squre_feet_value) {
		this.squre_feet_value = squre_feet_value;
	}
	
	
}
