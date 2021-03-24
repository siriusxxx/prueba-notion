package com.prueba.restapiservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.prueba.restapiservice.entity.UserEntity;

import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findById(Long id);
	Optional<UserEntity> findByPhoneId(Long id);
	Optional<UserEntity> findByPhoneNumber(String number);
}
