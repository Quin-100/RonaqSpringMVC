package com.ronaq.model;

public class BeneficiaryData {

	
	private int id;
	
	
	private String name;

	
	private String acctype;
	
	
	private String accountno;
	
	
	private String branch;
	
	


	public BeneficiaryData() {
		super();
	}

	

	public BeneficiaryData(int id, String name, String acctype, String accountno, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.acctype = acctype;
		this.accountno = accountno;
		this.branch = branch;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAcctype() {
		return acctype;
	}


	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}


	public String getAccountno() {
		return accountno;
	}


	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	@Override
	public String toString() {
		return "BeneficiaryData [id=" + id + ", name=" + name + ", acctype=" + acctype + ", accountno=" + accountno
				+ ", branch=" + branch + "]";
	}
	
	
}
