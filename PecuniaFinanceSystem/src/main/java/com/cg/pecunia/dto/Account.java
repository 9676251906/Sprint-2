package com.cg.pecunia.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Account 
{
	@Id
	@Column(name="account_id")
	Long accountId;
	@OneToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	@Column(name="branch_code")
	int branchId;
	@Column(name="status")
	String status;
	@Column(name="type")
	String type;
	@Column(name="balance")
	double balance;
	@Column(name="no_of_trans")
	int noOfTrans;
	@Column(name="minimum_balance")
	double minimumBalance;
	public Account() { }
	public Account(Long accountId, Customer customer, int branchId, String status, String type, double balance,int noOfTrans,double minimumBalance) 
	{
		this.accountId = accountId;
		this.customer = customer;
		this.branchId = branchId;
		this.status = status;
		this.type = type;
		this.balance = balance;
		this.noOfTrans=noOfTrans;
		this.minimumBalance=minimumBalance;
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
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
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
	public int getNoOfTrans() {
		return noOfTrans;
	}
	public void setNoOfTrans(int noOfTrans) {
		this.noOfTrans = noOfTrans;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
}
