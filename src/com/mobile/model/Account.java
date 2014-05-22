package com.mobile.model;

public class Account implements ModelInterface {
	
	private int accountId;
	private String accountName;
	private String accountAddress;
	private double accountBalance;
	public Account(int accountId, String accountName, String accountAddress,
			double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountAddress = accountAddress;
		this.accountBalance = accountBalance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountAddress() {
		return accountAddress;
	}
	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName="
				+ accountName + ", accountAddress=" + accountAddress
				+ ", accountBalance=" + accountBalance + "]";
	}
	
	

}
