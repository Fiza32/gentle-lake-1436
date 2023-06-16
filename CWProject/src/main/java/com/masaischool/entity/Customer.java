package com.masaischool.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Order;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cus_id;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "Email", nullable = false)
	private String email;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate DateOfBirth;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orderSet;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String email, LocalDate dateOfBirth, String username, String password,
			Set<Order> orderSet) {
		super();
		this.name = name;
		this.email = email;
		DateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
		this.orderSet = orderSet;
	}

	public int getCus_id() {
		return cus_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", name=" + name + ", email=" + email + ", DateOfBirth=" + DateOfBirth
				+ ", username=" + username + ", password=" + password + ", isDeleted=" + isDeleted + ", orderSet="
				+ orderSet + "]";
	}
	
	
	
}
