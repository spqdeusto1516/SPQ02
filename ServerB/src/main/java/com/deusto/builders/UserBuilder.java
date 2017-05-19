package com.deusto.builders;

import com.deusto.dtos.LoginDTO;
import com.deusto.dtos.PersonDTO;
import com.deusto.models.Registr;
import com.deusto.models.User;

/*!
 * UserBuilder class is used for building an User object
 */

public class UserBuilder {

    /*! Create a new user */
    private User user = new User();

    /**
     * Empty constructor
     */
    private UserBuilder() {
    }

    /**
     * Builds the first name in user
     * @param firstName String
     * @return itself
     */
    public UserBuilder firstname(String firstName) {
        this.user.setFirstname(firstName);
        return this;
    }

    /**
     * Builds the last name in user
     * @param lastName String
     * @return itself
     */
    public UserBuilder lastname(String lastName) {
        this.user.setLastname(lastName);
        return this;
    }

    /**
     * Builds the email in user
     * @param email String
     * @return itself
     */
    public UserBuilder email(String email) {
        this.user.setEmail(email);
        return this;
    }

    /**
     * Builds the birth date in user
     * @param birthdate Long
     * @return itself
     */
    public UserBuilder birthDate(Long birthdate) {
        this.user.setBirthDate(birthdate);
        return this;
    }

    /**
     * Builds the country code in user
     * @param countryCode String
     * @return itself
     */
    public UserBuilder countryCode(String countryCode) {
        this.user.setCountryCode(countryCode);
        return this;
    }

    /**
     * Builds the phone number in user
     * @param phone Integer
     * @return itself
     */
    public UserBuilder phone(Integer phone) {
        this.user.setPhone(phone);
        return this;
    }

    /**
     * Builds the password in user
     * @param password String
     * @return itself
     */
    public UserBuilder password(String password) {
        this.user.setPassword(password);
        return this;
    }

    /**
     * Creates a builder object
     * @return new builder object
     */
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    /**
     * Returns the built user
     * @return an user object
     */
    public User build() {
        return this.user;
    }

    /**
     * Gets an User object from a DTO object
     * @param registr Registr
     * @param person Person
     * @return an user object
     */
    public static User get(Registr registr, PersonDTO person) {
        User user = new User();
        user.setFirstname(registr.getFirstname());
        user.setLastname(registr.getLastname());
        user.setEmail(registr.getEmail());

        user.setPassword(person.getPassword());
        user.setPhone(person.getPhone());
        user.setCountryCode(person.getCountryCode());
        user.setBirthDate(person.getBirthDate());
        user.setAddress(AddressBuilder.get(person.getAddress()));
        return user;
    }

    /**
     * Gets an Login data from a User object
     * @param user User
     * @return a loginDTO object
     */
    public static LoginDTO get(User user) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(user.getEmail());
        loginDTO.setEncryptedPassword(user.getPassword());
        return loginDTO;
    }
}
