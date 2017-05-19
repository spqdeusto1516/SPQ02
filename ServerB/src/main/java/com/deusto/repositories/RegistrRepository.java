package com.deusto.repositories;

import com.deusto.models.Registr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*!
 * RegistrRepository class saves the created Registr objects in a mongo repository.
 * The objects saved in this repository are used forthe first step in registration process.
 * It exposes basic CRUD operations.
 */

@Repository
public interface RegistrRepository extends MongoRepository<Registr, String> {

    Registr findRegistrById(String id);
    Registr findByEmail(String email);
}
