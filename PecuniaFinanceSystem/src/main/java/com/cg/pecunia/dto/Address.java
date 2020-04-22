package com.cg.pecunia.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Address 
{
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_seq")
	@SequenceGenerator( name = "add_seq",sequenceName = "add_seq", allocationSize = 1)
	int addressId;
	@Column(name="h_no")
	String hNo;
	@Column(name="street")
	String street;
	@Column(name="city")
	String city;
	@Column(name="state")
	String state;
	@Column(name="country")
	String country;
	@Column(name="zip_code")
	int zipCode;
	public Address() {	}
	public Address(int addressId,String hNo, String street, String city, String state, String country, int zipCode) 
	{
		this.addressId = addressId;
		this.hNo=hNo;
		this.street=street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String gethNo() {
		return hNo;
	}
	public void sethNo(String hNo) {
		this.hNo = hNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
