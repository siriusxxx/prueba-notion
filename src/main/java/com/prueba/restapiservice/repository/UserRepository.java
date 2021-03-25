package com.prueba.restapiservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.prueba.restapiservice.entity.UserEntity;

import java.util.Optional;


// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<UserEntity> findById(Long id);
	
	/**
	 * Find by phone id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<UserEntity> findByPhoneId(Long id);
	
	/**
	 * Find by phone number.
	 *
	 * @param number the number
	 * @return the optional
	 */
	Optional<UserEntity> findByPhoneNumber(String number);
}
