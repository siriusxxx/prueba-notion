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
@FeignClient(name="userClient", url="https://localhost:8080/user")
public interface UserApi {
   
	@RequestLine("POST /create")
    User create(User user);
    
    @RequestLine("POST /updateContacts/{id}")
    void updateContacts(Set<Contact> contacts, @Param("id") Long userId);
    
    @RequestLine("GET /{userId}")
    Set<Contact> getContacts(@Param("userId") Long userId);
    
    @RequestLine("GET /{userId}/{userId2}")
    Set<Contact> getCommonContacts(@Param("userId") Long userId, @Param("userId2") Long userId2);
}
