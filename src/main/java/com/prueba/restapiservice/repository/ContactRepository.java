package com.prueba.restapiservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.restapiservice.entity.ContactEntity;
import com.prueba.restapiservice.entity.UserEntity;

import java.util.Optional;


// TODO: Auto-generated Javadoc
/**
 * The Interface ContactRepository.
 */
public interface ContactRepository extends CrudRepository<ContactEntity, Long> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<ContactEntity> findById(Long id);
	
	/**
	 * Find by phone id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<ContactEntity> findByPhoneId(Long id);
	
	/**
	 * Find by phone number.
	 *
	 * @param number the number
	 * @return the optional
	 */
	Optional<ContactEntity> findByPhoneNumber(String number);
	
	
	
}
