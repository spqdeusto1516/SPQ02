package com.deusto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*!
* This class is a model of the database document, used to store a registering users.
* The objects of this type will used in the second step of the registration
*/
@Document(collection = "registrs")
public class Registr {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Boolean isActiv;

    /**
     * Gets the id of the registering user
     * @return id String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the registering user
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

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

    /**
     * Gets the isActiv boolean var of the registering user
     * It will be true after the user will check the email
     * @return isActiv Boolean
     */
    public Boolean isActiv() {
        return isActiv;
    }

    /**
     * Sets the isActiv paramerter of the registering user
     * @param activ Boolean
     */
    public void setActiv(Boolean activ) {
        isActiv = activ;
    }
}
