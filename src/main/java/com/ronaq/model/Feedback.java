package com.ronaq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="FEEDABACK_DETAILS")
public class Feedback {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message="Name is required")
	private String name;
	
	@NotEmpty(message="Email is required")
	@Email(message="Enter valid Email")
	private String email;
	
	@NotEmpty(message="Phone no is required")
	@Pattern(regexp="[1-9]{1}[0-9]{9}",message="Enter valid 10 digit phone no.")
	private String phone;
	
	@NotEmpty(message="Feedback is required")
	private String message;	
	
	public Feedback() {
		super();
	}
	
	
	public Feedback(int id, String name, String email, String phone, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", message="
				+ message + "]";
	}

	

}
