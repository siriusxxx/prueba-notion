package com.prueba.restapiservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.restapiservice.entity.ContactEntity;
import com.prueba.restapiservice.entity.UserEntity;

import java.util.Optional;


public interface ContactRepository extends CrudRepository<ContactEntity, Long> {

	Optional<ContactEntity> findById(Long id);
	Optional<ContactEntity> findByPhoneId(Long id);
	Optional<ContactEntity> findByPhoneNumber(String number);
	
	
	
}
