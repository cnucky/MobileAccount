package com.mobile.model;

public class Charge implements ModelInterface {
	private String chargeId;
	private String chargeName;
	private String charge;
	public Charge(String chargeID, String chargeName, String charge) {
		super();
		this.chargeId = chargeID;
		this.chargeName = chargeName;
		this.charge = charge;
	}
	public Charge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getChargeID() {
		return chargeId;
	}
	public void setChargeId(String chargeID) {
		this.chargeId = chargeID;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	@Override
	public String toString() {
		return "Charge [chargeId=" + chargeId + ", ChargeName=" + chargeName
				+ ", Charge=" + charge + "]";
	}

}
