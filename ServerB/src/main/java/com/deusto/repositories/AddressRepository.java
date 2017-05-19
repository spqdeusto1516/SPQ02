package com.deusto.repositories;

import com.deusto.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*!
 * AddressRepository class saves the created Address objects in a mongo repository.
 * It exposes basic CRUD operations.
 */

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

}
