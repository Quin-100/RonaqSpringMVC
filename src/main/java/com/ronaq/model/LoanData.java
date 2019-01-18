package com.ronaq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOAN_TYPES")
public class LoanData {
	
	@Id
	@Column(name="loanId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loanId;
	
	private String loantype;
	
	private float loanrate;
	
	private long amountlimit;
	
	private int repaylimit;

	public LoanData() {
		super();
	}

	public LoanData(int loanId, String loantype, float loanrate, long amountlimit, int repaylimit) {
		super();
		this.loanId = loanId;
		this.loantype = loantype;
		this.loanrate = loanrate;
		this.amountlimit = amountlimit;
		this.repaylimit = repaylimit;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

	public float getLoanrate() {
		return loanrate;
	}

	public void setLoanrate(float loanrate) {
		this.loanrate = loanrate;
	}

	public long getAmountlimit() {
		return amountlimit;
	}

	public void setAmountlimit(long amountlimit) {
		this.amountlimit = amountlimit;
	}

	public int getRepaylimit() {
		return repaylimit;
	}

	public void setRepaylimit(int repaylimit) {
		this.repaylimit = repaylimit;
	}

	@Override
	public String toString() {
		return "LoanData [loanId=" + loanId + ", loantype=" + loantype + ", loanrate=" + loanrate + ", amountlimit="
				+ amountlimit + ", repaylimit=" + repaylimit + "]";
	}
	
	

}
