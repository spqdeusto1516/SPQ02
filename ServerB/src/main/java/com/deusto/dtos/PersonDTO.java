package com.deusto.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
/*!
 * PersonDTO class is used for creating Usr Objects.
 * It is intended to provide it's data in the last step of registation
 */


public class PersonDTO {
    @Email
    @NotEmpty
    private String email;
    private Long birthDate;
    @NotEmpty
    private String countryCode;
    private Integer phone;
    @NotEmpty
    private String password;
    private AddressDTO address;

    /**
     * Gets the email of the person
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the person
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the birth date of the person
     * @return birthDate Long
     */
    public Long getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the person
     * @param birthDate Long
     */
    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the country code of the person
     * @return countryCode String
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code of the person
     * @param countryCode String
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the phone number of the person
     * @return phone Integer
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * Sets the phone of the person
     * @param phone Integer
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * Gets the password of the person
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the person
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the Address of the person
     * @return address Address
     */
    public AddressDTO getAddress() {
        return address;
    }
    /**
     * Sets the address of the person
     * @param address Address
     */
    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
