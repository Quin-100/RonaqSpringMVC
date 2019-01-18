package com.ronaq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	private float returnamount;
	
	private String status;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    private User userdetails;
	
	public LoanApplication() {
		super();
	}

	public LoanApplication(int applicationId, String loantype, int repaylimit, double amount, float loanrate,
			float returnamount, String status, User userdetails) {
		super();
		this.applicationId = applicationId;
		this.loantype = loantype;
		this.repaylimit = repaylimit;
		this.amount = amount;
		this.loanrate = loanrate;
		this.returnamount = returnamount;
		this.status = status;
		this.userdetails = userdetails;
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

	
	
	public float getReturnamount() {
		return returnamount;
	}



	public void setReturnamount(float returnamount) {
		this.returnamount = returnamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(User userdetails) {
		this.userdetails = userdetails;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", loantype=" + loantype + ", repaylimit="
				+ repaylimit + ", amount=" + amount + ", loanrate=" + loanrate + ", returnamount=" + returnamount
				+ ", Status=" + status + "]";
	}


}
