package com.prueba.restapiservice.api;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prueba.restapiservice.dto.Contact;
import com.prueba.restapiservice.dto.User;

import feign.Param;
import feign.RequestLine;
/**
 * The Interface UserApi.
 */
@FeignClient(name="userClient", url="https://localhost:8080/user")
public interface UserApi {
   
	/**
	 * Creates the.
	 *
	 * @param user the user
	 * @return the user
	 */
	@RequestLine("POST /create")
    User create(User user);
    
    /**
     * Update contacts.
     *
     * @param contacts the contacts
     * @param userId the user id
     */
    @RequestLine("POST /updateContacts/{id}")
    void updateContacts(Set<Contact> contacts, @Param("id") Long userId);
    
    /**
     * Gets the contacts.
     *
     * @param userId the user id
     * @return the contacts
     */
    @RequestLine("GET /{userId}")
    Set<Contact> getContacts(@Param("userId") Long userId);
    
    /**
     * Gets the common contacts.
     *
     * @param userId the user id
     * @param userId2 the user id 2
     * @return the common contacts
     */
    @RequestLine("GET /{userId}/{userId2}")
    Set<Contact> getCommonContacts(@Param("userId") Long userId, @Param("userId2") Long userId2);
}
