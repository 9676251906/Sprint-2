package com.cg.pecunia.dto;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Account 
{
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acc_seq")
	@SequenceGenerator(name = "acc_seq",sequenceName = "acc_seq", allocationSize = 1)
	Long accountId;
	@OneToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	@Column(name="opening_date")
	LocalDate openingDate;
	@Column(name="status")
	String status;
	@Column(name="type")
	String type;
	@Column(name="balance")
	double balance;
	public Account() {	}
	public Account(Long accountId, Customer customer, LocalDate openingDate, String status, String type,
			double balance) 
	{
		this.accountId = accountId;
		this.customer = customer;
		this.openingDate = openingDate;
		this.status = status;
		this.type = type;
		this.balance = balance;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
