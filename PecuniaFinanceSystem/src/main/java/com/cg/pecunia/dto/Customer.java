package com.cg.pecunia.dto;
import java.util.Date;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
	@Column(name="customer_id")
	Long customerId;
	@Column(name="name")
	String name;
	@OneToOne
	@JoinColumn(name="address_id")
	Address address;
	@Column(name="aadhar_no")
	Long aadharNo;
	@Column(name="pan")
	String pan;
	@Column(name="contact_no")
	Long contactNo;
	@Column(name="dob")
	Date dob;
	@Column(name="gender")
	String gender;
	public Customer() {  }
	public Customer(Long customerId, String name, Address address, Long aadharNo, String pan, Long contactNo, Date dob,
			String gender) 
	{
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.aadharNo = aadharNo;
		this.pan = pan;
		this.contactNo = contactNo;
		this.dob = dob;
		this.gender = gender;
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
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
