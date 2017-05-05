package com.deusto.repositories;

import com.deusto.models.Registr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrRepository extends MongoRepository<Registr, String> {
    Registr findAllById(String id);

    Registr findByEmail(String email);
}
