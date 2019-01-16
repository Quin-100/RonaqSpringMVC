package com.ronaq.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_INFO")
public class Account {

	@Id
	@Column(name="customerId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	private String accountNo;
	
	private double balance;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    private User userdetails;

	
	public Account() {
		super();
	}

	public Account(int customerId, String accountNo, double balance) {
		super();
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(User userdetails) {
		this.userdetails = userdetails;
	}	
	
	
	@Override
	public String toString() {
		return "Account [customerId=" + customerId + ", accountNo=" + accountNo + ", balance=" + balance
				+ "]";
	}

	public String generateAccountNo() {
		
		Random rand = new Random();
	    String acc_no = "00";
	    for (int i = 0; i < 10; i++)
	    {
	        int n = rand.nextInt(10) + 0;
	        acc_no += Integer.toString(n);
	    }
		return acc_no;
	}
	
}
