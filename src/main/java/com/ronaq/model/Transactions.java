package com.ronaq.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TRANSACTION_DETAILS")
public class Transactions {
	
	@Id
	@Column(name="transactionId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    private User userdetails;
	
	//@NotEmpty(message="Amount is required.")
	//@Pattern(regexp="[0-9]",message="Enter valid amount")
	private double amount;
	
	private String extranote;	

	private Date transactiondate;
	
	
	private String benname;

	
	
	public Transactions() {
		super();
	}

	public Transactions(int transactionId, User userdetails, double amount, String extranote, Date date) {
		super();
		this.transactionId = transactionId;
		this.userdetails = userdetails;
		this.amount = amount;
		this.extranote = extranote;
		this.transactiondate = date;
	}


	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public User getUserdetails() {
		return userdetails;
	}



	public void setUserdetails(User userdetails) {
		this.userdetails = userdetails;
	}



	public String getExtranote() {
		return extranote;
	}



	public void setExtranote(String extranote) {
		this.extranote = extranote;
	}



	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

	public String getBenname() {
		return benname;
	}

	public void setBenname(String benname) {
		this.benname = benname;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", amount=" + amount + ", extranote=" + extranote
				+ ", transactiondate=" + transactiondate + ", benname=" + benname + "]";
	}
}
