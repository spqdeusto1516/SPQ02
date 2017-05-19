package com.deusto.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/*!
 * LoginDTO class is used for loging functionality
 * It is used in the request in LoginController as a RequestBody
 */

public class LoginDTO {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String encryptedPassword;

    /**
     * Gets the email of the user
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the loginDTO
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the encrypted password of the user
     * @return encrypted password String
     */
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    /**
     * Sets the encrypted password of the user
     * @param encryptedPassword String
     */
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
