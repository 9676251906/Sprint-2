package com.cg.pecunia.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Customer 
{
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
	@SequenceGenerator( name = "cust_seq",sequenceName = "cust_seq", allocationSize = 1)
	Long customerId;
	@Column(name="name")
	String name;
	@Column(name="pan")
	String pan;
	@OneToOne
	@JoinColumn(name="address_id")
	Address address;
	@Column(name="phone")
	Long phone;
	@Column(name="email_id")
	String emailId;
	@Column(name="aadhar_no")
	Long aadharNo;
	public Customer() {  }
	public Customer(Long customerId, String name,  String pan, Address address,Long phone,String emailId, Long aadharNo) 
	{
		this.customerId = customerId;
		this.name = name;
		this.pan = pan;
		this.address = address;
		this.phone=phone;
		this.emailId=emailId;
		this.aadharNo = aadharNo;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
