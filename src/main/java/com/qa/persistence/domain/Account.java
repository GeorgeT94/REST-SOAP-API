package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.qa.validation.ContactNumberConstraint;

@Entity
public class Account {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Pattern(regexp="^[a-zA-Z]{4,10}$",  message="MUST BE BETWEEN 4 AND 10 CHARACTERS NO NUMBERS OR SYMBOLS")
	private String firstName;
	
	@Pattern(regexp="^[a-zA-Z]{4,10}$", message="MUST BE BETWEEN 4 AND 10 CHARACTERS NO NUMBERS OR SYMBOLS")
	private String secondName;
	
	//@Pattern(regexp="[\\d]{6}", message="MUST BE SIX NUMBERS!!!")
	@ContactNumberConstraint
	private String accountNumber;
	
	@JoinColumn(name = "account_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Transaction> transaction;

	public Account() {

	}

	public Account(String firstName, String secondName, String accountNumber, List<Transaction> transaction) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.accountNumber = accountNumber;
		this.transaction = transaction;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

}

