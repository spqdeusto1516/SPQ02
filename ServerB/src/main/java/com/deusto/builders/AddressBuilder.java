package com.deusto.builders;

import com.deusto.dtos.AddressDTO;
import com.deusto.models.Address;

/*!
 * AddressBuilder class is used for building an Address object
 */
public class AddressBuilder {

    /*! Create a new address object */
    private Address address = new Address();

    /**
     * Empty constructor
     */
    private AddressBuilder() {
    }

    /**
     * Builds the country in address
     * @param country String
     * @return itself
     */
    public AddressBuilder country(String country) {
        this.address.setCountry(country);
        return this;
    }

    /**
     * Builds the city in address
     * @param city String
     * @return itself
     */
    public AddressBuilder city(String city) {
        this.address.setCity(city);
        return this;
    }

    /**
     * Builds the street in address
     * @param street String
     * @return itself
     */
    public AddressBuilder street(String street) {
        this.address.setStreet(street);
        return this;
    }

    /**
     * Builds the postal code in address
     * @param postalCode String
     * @return itself
     */
    public AddressBuilder postalCode(String postalCode) {
        this.address.setPostalCode(postalCode);
        return this;
    }

    /**
     * Builds the house number in address
     * @param houseNumeber String
     * @return itself
     */
    public AddressBuilder houseNumber(Integer houseNumeber) {
        this.address.setHouseNumber(houseNumeber);
        return this;
    }

    /**
     * Builds the apartment number in address
     * @param apartmentNumber String
     * @return itself
     */
    public AddressBuilder apartamentNumber(Integer apartmentNumber) {
        this.address.setApartamentNumber(apartmentNumber);
        return this;
    }

    /**
     * Creates a builder object
     * @return new builder object
     */
    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    /**
     * Returns the build address
     * @return an address object
     */
    public Address build() {
        return this.address;
    }

    /**
     * Gets an Address object from a DTO object
     * @param addressDTO AddressDTO
     * @return an address object
     */
    public static Address get(AddressDTO addressDTO) {
        Address address = new Address();
        address.setApartamentNumber(addressDTO.getApartamentNumber());
        address.setHouseNumber(addressDTO.getHouseNumber());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        return address;
    }
}
