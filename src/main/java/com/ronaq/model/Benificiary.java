package com.ronaq.model;

import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="BENEFICIARY_DETAILS")
public class Benificiary implements Comparator<Benificiary>{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message="Name is required")
	private String name;

	@NotEmpty(message="Account type is required")
	private String acctype;
	
	@NotEmpty(message="Account No. is required")
	@Size(min=12,max=12,message="Enter proper 12 digit ACCOUNT No")
	private String accountno;
	
	@NotEmpty(message="Branch is required")
	private String branch;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="benList")	
	private List<User> userList;

	public Benificiary() {
		super();
	}
	
	public Benificiary(int id, String name, String acctype, String accountno, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.acctype = acctype;
		this.accountno = accountno;
		this.branch = branch;
		//this.userList = userList;
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


	public List<User> getUserList() {
		return userList;
	}



	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Benificiary [id=" + id + ", name=" + name + ", acctype=" + acctype + ", accountno=" + accountno
				+ ", branch=" + branch + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub	
		
		return super.equals(obj);
	}

	public int compare(Benificiary o1, Benificiary o2) {
		// TODO Auto-generated method stub		
		return (o1.getAccountno().compareTo(o2.getAccountno()));
	}
	
	

}
