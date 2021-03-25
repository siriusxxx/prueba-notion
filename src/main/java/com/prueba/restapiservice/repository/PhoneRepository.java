package com.prueba.restapiservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.restapiservice.entity.PhoneEntity;
import com.prueba.restapiservice.entity.UserEntity;

import java.util.Optional;


// TODO: Auto-generated Javadoc
/**
 * The Interface PhoneRepository.
 */
public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	Optional<PhoneEntity> findById(Long id);
	
	/**
	 * Find by number.
	 *
	 * @param number the number
	 * @return the optional
	 */
	Optional<PhoneEntity> findByNumber(String number);
	
	
}
