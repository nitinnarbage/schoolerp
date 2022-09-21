package com.cloverproject;

import java.io.Serializable;

import java.util.Objects;

public class Employee implements Serializable 
{
    private static final long serialVersionUID = -1280037900360314186L;

    private Integer id;
    private String name;
    private String birthdate;
    private String gender;
    private String hobbies;
    private String address;
    private String pan;
   
    
    
    @Override
	public int hashCode() {
		return Objects.hash(address, birthdate, gender, hobbies, id, name, pan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthdate, other.birthdate)
				&& Objects.equals(gender, other.gender) && Objects.equals(hobbies, other.hobbies)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(pan, other.pan);
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer id, String name, String birthdate, String gender, String hobbies, String address,
			String pan) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.hobbies = hobbies;
		this.address = address;
		this.pan = pan;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", gender=" + gender
				+ ", hobbies=" + hobbies + ", address=" + address + ", pan=" + pan + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}