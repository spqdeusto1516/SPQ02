package com.deusto.builders;

import com.deusto.dtos.RegistrDTO;
import com.deusto.models.Registr;

/*!
 * Registr class is used for building a Registr object
 */


public class RegistrBuilder {

    /**
     * Gets a Registr object from a DTO object
     * @param registrDTO RegistrDTO
     * @return an registr object
     */
    public static Registr get(RegistrDTO registrDTO) {
        Registr registr = new Registr();
        registr.setEmail(registrDTO.getEmail());
        registr.setFirstname(registrDTO.getFirstname());
        registr.setLastname(registrDTO.getLastname());
        registr.setActiv(false);
        return registr;
    }
}
