package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//name,email,password,regAmount,regDate(LocalDate)
@Entity
@Table(name = "vendors")
public class Vendor extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 20,unique =true)
	private String email;
	@Column(length = 20,nullable = false)
	private String password;
	@Column(name="reg_amt")
	private double regAmount;
	@Column(name="reg_date")
	private LocalDate regDate;
	//add a role
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role role;
	@OneToMany(mappedBy = "acctOwner",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BankAccount> accounts=new ArrayList<>();
	//one to one (bi dir) : inverse 
	@OneToOne(mappedBy = "vendor",cascade = CascadeType.ALL)
	private Location vendorLocation;
	//uni dir association between entity n value type(embeddable)
	@Embedded //optional : added only for understanding
	private PaymentMode mode;
	
	public Vendor() {
		System.out.println("in vendor ctor");
	}
	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	public Location getVendorLocation() {
		return vendorLocation;
	}
	public void setVendorLocation(Location vendorLocation) {
		this.vendorLocation = vendorLocation;
	}
	
	public PaymentMode getMode() {
		return mode;
	}
	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Vendor [name=" + name + ", email=" + email + ", regAmount=" + regAmount + ", regDate=" + regDate
				+ ", getId()=" + getId() +"  "+ role;
	}	
	//helper methods to add n remove acct
	public void addAccount(BankAccount a)
	{
		accounts.add(a);
		a.setAcctOwner(this);
	}
	public void removeAccount(BankAccount a)
	{
		accounts.remove(a);
		a.setAcctOwner(null);
	}
	//helper methods to add n remove location
	public void addLocation(Location loc)
	{
		vendorLocation=loc;
		loc.setVendor(this);
	}
	public void removeLocation(Location loc)
	{
		vendorLocation=null;
		loc.setVendor(null);
	}

}
