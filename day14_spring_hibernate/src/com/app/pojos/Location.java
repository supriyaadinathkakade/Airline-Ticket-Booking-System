package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name="locations")
public class Location extends BaseEntity {
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String country;
	//owning (one to one)
	@OneToOne
	@JoinColumn(name="v_id")
	private Vendor vendor;
	public Location() {
		// TODO Auto-generated constructor stub
	}
	public Location(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
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
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	@Override
	public String toString() {
		return "Location [city=" + city + ", state=" + state + ", country=" + country + ", getId()=" + getId() + "]";
	}
	

}
