package com.mobile.model;

public class Mobiles implements ModelInterface {
	private String mobileNum;
	private String mobileType;
	private String cardNum;
	private String isAvail;
	public Mobiles(String mobileNum, String mobileType, String cardNum,
			String isAvail) {
		super();
		this.mobileNum = mobileNum;
		this.mobileType = mobileType;
		this.cardNum = cardNum;
		this.isAvail = isAvail;
	}
	public Mobiles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getIsAvail() {
		return isAvail;
	}
	public void setIsAvail(String isAvail) {
		this.isAvail = isAvail;
	}
	@Override
	public String toString() {
		return "Mobile [mobileNum=" + mobileNum + ", mobileType=" + mobileType
				+ ", cardNum=" + cardNum + ", isAvail=" + isAvail + "]";
	}
	
	
}
