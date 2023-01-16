package com.example.jpa;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	//@Column(name="transactionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	//@Column(name="customerid")
	//@NotBlank(message = "Customer id is mandatory")
	private int customerid;
	//@Column(name="bookid")
	//@NotBlank(message = "Bookid is mandatory")
	private int bookid;
	//@Column(name="trxndate")
	//@NotBlank(message = "Please provide a date time in format AAAA-MM-DD")
	private Date trxndate;
	//@Column(name="trxntype")
	//@NotBlank(message = "Must select Check-in or Check out")
	private String trxntype;
	
//	public Transaction() {
//		super();
//	}
//	public Transaction(int transactionid, int customerid, int bookid, Date trxndate, String trxntype) {
//		super();
//		this.transactionid = transactionid;
//		this.customerid = customerid;
//		this.bookid = bookid;
//		this.trxndate = trxndate;
//		this.trxntype=trxntype;
//	}
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public Date getTrxndate() {
		return trxndate;
	}
	public void setTrxndate(Date trxndate) {
		this.trxndate = trxndate;
	}
	public String getTrxntype() {
		return trxntype;
	}
	public void setTrxntype(String trxntype) {
		this.trxntype = trxntype;
	}
	
	

}