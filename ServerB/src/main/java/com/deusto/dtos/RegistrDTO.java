package com.deusto.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/*!
 * RegistrDTO class is used for creating Registr objects.
 * It is intended to provide it's data to build an Registr object.
 */

public class RegistrDTO {
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    @Email
    private String email;

    /**
     * Gets the firstName of the registering user
     * @return firstName String
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstName of the registering user
     * @param firstname String
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the lastName of the registering user
     * @return lastName String
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastName of the registering user
     * @param lastname String
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the email of the registering user
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the registering user
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
