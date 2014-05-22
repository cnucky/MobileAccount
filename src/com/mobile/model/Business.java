package com.mobile.model;

public class Business implements ModelInterface {
	private String businessId;
	private String businessName;
	private String instruction;
	public Business(String businessId, String businessName,
			String instruction) {
		super();
		this.businessId = businessId;
		this.businessName = businessName;
		this.instruction = instruction;
	}
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", businessName="
				+ businessName + ", instruction=" + instruction + "]";
	}
	
}
