package com.prueba.restapiservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.restapiservice.entity.PhoneEntity;
import com.prueba.restapiservice.entity.UserEntity;

import java.util.Optional;


public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {

	Optional<PhoneEntity> findById(Long id);
	Optional<PhoneEntity> findByNumber(String number);
	
	
}
