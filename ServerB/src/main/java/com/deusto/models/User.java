package com.deusto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/*!
* This class is a model of the database document, used to store a user.
* It is involved in the last step of installation
*/
@Document(collection = "bookit_users")
public class User {
	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private Long birthDate;
	private String countryCode;
	private Integer phone;
	private String password;

	@DBRef(lazy = true)
	private Address address;

	/**
	 * Gets the id of the user
	 * @return id String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the user
	 * @param id String
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the firstName of the user
	 * @return firstName String
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the first name of the user
	 * @param firstname String
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the last name of the user
	 * @return lastName String
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastName of the user
	 * @param lastname String
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the email of the user
	 * @return email String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the user
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the birth date of the user
	 * @return birthDate Long
	 */
	public Long getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date of the user
	 * @param birthDate Long
	 */
	public void setBirthDate(Long birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the country code of the user
	 * @return countryCode String
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the country code of the user
	 * @param countryCode String
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Gets the phone number of the user
	 * @return phone Integer
	 */
	public Integer getPhone() {
		return phone;
	}

	/**
	 * Sets the phone of the user
	 * @param phone Integer
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	/**
	 * Gets the Address of the user
	 * @return address Address
	 */
	public Address getAddress() {
		return address;
	}

    /**
     * Sets the address of the user
     * @param address Address
     */
	public void setAddress(Address address) {
		this.address = address;
	}

    /**
     * Sets the password of the user
     * @param password String
     */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the password of the user
	 * @return password String
	 */
	public String getPassword() {
		return password;
	}
}
