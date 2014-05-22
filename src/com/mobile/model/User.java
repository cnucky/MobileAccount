package com.mobile.model;

public class User implements ModelInterface {

	private int userId;
	private int customerId;
	private String mobileNumber;
	private int accountId;
	private String roamingStatus;
	private String comLevel;
	
	public User(int userId, int customerId, String mobileNumber,
			int accountId, String roamingStatus, String comLevel) {
		super();
		this.userId = userId;
		this.customerId = customerId;
		this.mobileNumber = mobileNumber;
		this.accountId = accountId;
		this.roamingStatus = roamingStatus;
		this.comLevel = comLevel;
	}
	
	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getRoamingStatus() {
		return roamingStatus;
	}

	public void setRoamingStatus(String roamingStatus) {
		this.roamingStatus = roamingStatus;
	}

	public String getComLevel() {
		return comLevel;
	}

	public void setComLevel(String comLevel) {
		this.comLevel = comLevel;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", customerId=" + customerId
				+ ", mobileNumber=" + mobileNumber + ", accountId="
				+ accountId + ", roamingStatus=" + roamingStatus
				+ ", comLevel=" + comLevel + "]";
	}
	
}
