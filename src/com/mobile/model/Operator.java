package com.mobile.model;

public class Operator implements ModelInterface {
	
	private String operatorId;
	private String operatorName;
	private String operatorPwd;
	private String isAdmin;
	
	public Operator(String operatorId, String operatorName, String operatorPwd,
			String isAdmin) {
		super();
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.operatorPwd = operatorPwd;
		this.isAdmin = isAdmin;
	}

	public Operator() {
		super();
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorPwd() {
		return operatorPwd;
	}

	public void setOperatorPwd(String operatorPwd) {
		this.operatorPwd = operatorPwd;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Operator [operatorId=" + operatorId + ", operatorName="
				+ operatorName + ", operatorPwd=" + operatorPwd + ", isAdmin="
				+ isAdmin + "]";
	}
	
	
	
}
