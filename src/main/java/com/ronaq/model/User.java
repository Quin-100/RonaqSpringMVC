package com.ronaq.model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER_DETAILS")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message="User name is required")
	private String name;
	
	@NotEmpty(message="PAN no is required")
	@Size(min=10,max=10,message="Enter valid PAN no.")
	private String pan;
	
	@NotEmpty(message="AADHAR no is required")
	@Size(min=12,max=12,message="Enter valid AADHAR no.")
	private String aadhar;
	
	@NotEmpty(message="Email is required")
	@Email(message="Enter valid Email")
	private String email;
	
	@NotEmpty(message="Email is required")
	private String address;
	
	@NotEmpty(message="DOB is required")
	//@Temporal(TemporalType.DATE)
	private String dob;
	
	@NotEmpty(message="Branch is required")
	private String branch;
	
	@NotEmpty(message="State is required")
	private String state;
	
	@NotEmpty(message="Account type is required")
	private String acctype;
	
	@NotEmpty(message="password is required")
	@Size(min=6,message="Enter min 6 characters")
	private String password;
	
	//@NotEmpty(message="Re password is required")
	//@Size(min=6,message="Enter min 6 characters")	
	@Transient
	private String repassword;
	
	//private byte[] photo;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="userdetails")	
	private List<Account> lstAccount ;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)	
	@JoinTable
		(
		    name="USER_BENEFICIARY",
			joinColumns= {@JoinColumn(name="UserId",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="BeneficiaryId",referencedColumnName="id")}
	    )
	private List<Benificiary> benList ;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="userdetails")	
	private List<Transactions> lstTransaction ;
	
    //private Set<Items> items;	
	
	
	

	public User() {
		super();
	}

	public User(int id, String name, String pan, String aadhar, String email, String address, String dob, String branch,
			String state, String acctype, String password, String repassword, List<Account> lstAccount
			) {
		super();
		this.id = id;
		this.name = name;
		this.pan = pan;
		this.aadhar = aadhar;
		this.email = email;
		this.address = address;
		this.dob = dob;
		this.branch = branch;
		this.state = state;
		this.acctype = acctype;
		this.password = password;
		this.repassword = repassword;
		this.lstAccount = lstAccount;		
	}

	public Integer getId() {
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public List<Account> getLstAccount() {
		return lstAccount;
	}
	public void setLstAccount(List<Account> lstAccount) {
		this.lstAccount = lstAccount;
	}	
	
	public List<Benificiary> getBenList() {
		return benList;
	}

	public void setBenList(List<Benificiary> benList) {
		this.benList = benList;
	}

	
	
	public List<Transactions> getLstTransaction() {
		return lstTransaction;
	}

	public void setLstTransaction(List<Transactions> lstTransaction) {
		this.lstTransaction = lstTransaction;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pan=" + pan + ", aadhar=" + aadhar + ", email=" + email
				+ ", address=" + address + ", dob=" + dob + ", branch=" + branch + ", state=" + state + ", acctype="
				+ acctype + ", password=" + password + ", repassword=" + repassword + ", lstAccount=" + lstAccount
				+ ", benList=" + benList + ", lstTransaction=" + lstTransaction + "]";
	}

	
	
	/*public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}*/
	

	

	
	
	
}
