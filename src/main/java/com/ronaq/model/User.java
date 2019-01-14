package com.ronaq.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String pan;
	private String aadhar;
	private String email;
	private String address;
	private String dob;
	private String branch;
	private String state;
	private String acctype;
	private String password;
	private byte[] photo;
	
	
	public User() {
		super();
	}
	public User(int id, String name, String pan, String aadhar, String email, String address, String dob, String branch,
			String state, String acctype, String password, byte[] photo) {
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
		this.photo = photo;
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pan=" + pan + ", aadhar=" + aadhar + ", email=" + email
				+ ", address=" + address + ", dob=" + dob + ", branch=" + branch + ", state=" + state + ", acctype="
				+ acctype + ", password=" + password + ", photo=" + photo + "]";
	}
	
	
	
	
}
