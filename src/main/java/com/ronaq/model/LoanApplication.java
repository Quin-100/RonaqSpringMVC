package com.ronaq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOAN_APPLICATION")
public class LoanApplication {
	
	@Id
	@Column(name="applicationId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int applicationId;
	
	private String loantype;
	
	private int repaylimit;
	
	private double amount;
	
	private float loanrate;
	
	private double returnamount;

	public LoanApplication() {
		super();
	}

	public LoanApplication(int applicationId, String loantype, int repaylimit, double amount, float loanrate,
			double returnamount) {
		super();
		this.applicationId = applicationId;
		this.loantype = loantype;
		this.repaylimit = repaylimit;
		this.amount = amount;
		this.loanrate = loanrate;
		this.returnamount = returnamount;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public int getRepaylimit() {
		return repaylimit;
	}

	public void setRepaylimit(int repaylimit) {
		this.repaylimit = repaylimit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public float getLoanrate() {
		return loanrate;
	}

	public void setLoanrate(float loanrate) {
		this.loanrate = loanrate;
	}

	public double getReturnamount() {
		return returnamount;
	}

	public void setReturnamount(double returnamount) {
		this.returnamount = returnamount;
	}

	@Override
	public String toString() {
		return "LoanForm [applicationId=" + applicationId + ", loantype=" + loantype + ", repaylimit=" + repaylimit
				+ ", amount=" + amount + ", loanrate=" + loanrate + ", returnamount=" + returnamount + "]";
	}	

}
