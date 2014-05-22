package com.mobile.model;

public class BusinessCharge implements ModelInterface {
	private int businessID;
	private int ChargeID;
	public BusinessCharge(int businessID, int chargeID) {
		super();
		this.businessID = businessID;
		this.ChargeID = chargeID;
	}
	public BusinessCharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBusinessID() {
		return businessID;
	}
	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}
	public int getChargeID() {
		return ChargeID;
	}
	public void setChargeID(int chargeID) {
		ChargeID = chargeID;
	}
	@Override
	public String toString() {
		return "BusinessCharge [businessID=" + businessID + ", ChargeID="
				+ ChargeID + "]";
	}
	

}
