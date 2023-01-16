package com.example.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	//@Column(name="fcustomerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fcustomerid;
	//@Column(name="firstname")
	@NotBlank(message = "Customer name is mandatory")
	private String firstname;
	//@Column(name="lastname")
	@NotBlank(message = "Customer name is mandatory")
	private String lastname;
	//@Column(name="address")
	private String address;
	//@Column(name="phone")
	private String phone;
	//@Column(name="emailid")
	private String emailid;
	
//	public Customer() {
//		super();
//	}
//	public Customer(int fcustomerid, String firstname, String lastname, String address, String phone,String emailid) {
//		super();
//		this.fcustomerid = fcustomerid;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.address = address;
//		this.phone=phone;
//		this.emailid=emailid;
//	}
	public int getFcustomerid() {
		return fcustomerid;
	}
	public void setFcustomerid(int fcustomerid) {
		this.fcustomerid = fcustomerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


}