package com.deusto.dtos;

/*!
 * AddressDTO class is used for creating Adress Objects.
 * It is intended to provide it's data to build an Address object.
 */
public class AddressDTO {

    private String country;
    private String city;
    private String street;
    private String postalCode;
    private Integer houseNumber;
    private Integer apartamentNumber;

    /**
     * Gets the house number
     * @return houseNumber Integer
     */
    public Integer getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the house number in address
     * @param houseNumber Integer
     */
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets the apartment number
     * @return apartmentNumber Integer
     */
    public Integer getApartamentNumber() {
        return apartamentNumber;
    }

    /**
     * Sets the apartment number in address
     * @param apartamentNumber Integer
     */
    public void setApartamentNumber(Integer apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    /**
     * Gets the country from address
     * @return @country value
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country in address
     * @param country String
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the city in address
     * @return city String
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city in address
     * @param city String
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the street in address
     * @return String street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street in address
     * @param street String
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the postal code in address
     * @return postalCode String
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code in address
     * @param postalCode String
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}