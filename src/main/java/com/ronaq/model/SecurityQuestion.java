package com.ronaq.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SECURITY_QUESTION")
public class SecurityQuestion {
	
	@Id
	@Column(name="questionId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;
	
	private String question;
	
	/*@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="securityQuestion")	
	private List<User> users ;
	
	 */
	public SecurityQuestion() {
		super();
	}

	public SecurityQuestion(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/*public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/

	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}
	
	

	@Override
	public String toString() {
		return "SecurityQuestion [loanId=" + questionId + ", question=" + question + "]";
	}
	
	
}
