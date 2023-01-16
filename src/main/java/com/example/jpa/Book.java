package com.example.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="Book")
public class Book {
	@Id
	//@Column(name="bookid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookid;
	//@Column(name="title")
	@NotBlank(message = "Book Title is mandatory")
	private String title;
	//@Column(name="authorlastname")
	@NotBlank(message = "Author Name is mandatory")
	private String authorlastname;
	//@Column(name="authorfirstname")
	@NotBlank(message = "Author Name is mandatory")
	private String authorfirstname;
	//@Column(name="rating")
	private String rating;
	
//	public Book() {
//		super();
//	}
//	public Book(int bookid, String title, String authorlastname, String authorfirstname, String rating) {
//		super();
//		this.bookid = bookid;
//		this.title = title;
//		this.authorlastname = authorlastname;
//		this.authorfirstname = authorfirstname;
//		this.rating=rating;
//	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorlastname() {
		return authorlastname;
	}
	public void setAuthorlastname(String authorlastname) {
		this.authorlastname = authorlastname;
	}
	public String getAuthorfirstname() {
		return authorfirstname;
	}
	public void setAuthorfirstname(String authorfirstname) {
		this.authorfirstname = authorfirstname;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	

}