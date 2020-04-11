package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author
{
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String eMail;
	public Author() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param eMail
	 */
	public Author(Long id, String firstName, String lastName, String eMail) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}
	
	
	
	
}
