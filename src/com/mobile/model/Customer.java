package com.mobile.model;

public class Customer implements ModelInterface {

	private String customerId;
	private String idType;
	private String idNumber;
	private String customerName;
	private String customerBirthday;
	private String customerSex;
	private String customerAddress;
	
	public Customer(String customerId, String idType, String idNumber,
			String customerName, String customerBirthday,
			String customerSex, String customerAddress) {
		super();
		this.customerId = customerId;
		this.idType = idType;
		this.idNumber = idNumber;
		this.customerName = customerName;
		this.customerBirthday = customerBirthday;
		this.customerSex = customerSex;
		this.customerAddress = customerAddress;
	}
	
	public Customer() {
		super();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerBirthday() {
		return customerBirthday;
	}
	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", idType=" + idType
				+ ", idNumber=" + idNumber + ", customerName="
				+ customerName + ", customerBirthday=" + customerBirthday
				+ ", customerSex=" + customerSex + ", customerAddress="
				+ customerAddress + "]";
	}
	
}
