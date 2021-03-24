package com.prueba.restapiservice.controller;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.prueba.restapiservice.dto.Contact;
import com.prueba.restapiservice.dto.User;
import com.prueba.restapiservice.entity.PhoneEntity;
import com.prueba.restapiservice.entity.UserEntity;
import com.prueba.restapiservice.exceptions.BadRequestException;
import com.prueba.restapiservice.exceptions.ContactException;
import com.prueba.restapiservice.exceptions.CreateUserException;
import com.prueba.restapiservice.exceptions.PhoneFoundException;
import com.prueba.restapiservice.exceptions.PhoneValidateException;
import com.prueba.restapiservice.exceptions.UserNotFoundException;
import com.prueba.restapiservice.repository.PhoneRepository;
import com.prueba.restapiservice.repository.UserRepository;
import com.prueba.restapiservice.service.UserService;
import com.prueba.restapiservice.utils.ModelConstants;

@RestController
@RequestMapping(value = ModelConstants.REST_API_URI_USER)
public class UserController {

	@Autowired
	UserService userService;

//	@GetMapping("/greeting")
//	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//		userRepository.findById(0L);
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
//	}
	
	@PostMapping("/create")
	public User create(@Valid @RequestBody final User user) throws PhoneFoundException, CreateUserException, PhoneValidateException{
		return userService.create(user);
    }
	
	@PostMapping("/updateContacts/{userId}")
	public void updateContacts(@Valid @RequestBody Set<Contact> contacts , @PathVariable final Long userId) throws PhoneFoundException, CreateUserException, UserNotFoundException, ContactException{
		userService.updateContacts(contacts,userId);
    }
	
	@GetMapping("/getContacts/{userId}")
	public List<Contact> getContacts(@PathVariable final Long userId) throws PhoneFoundException, CreateUserException, UserNotFoundException, BadRequestException{
		return userService.getContacts(userId);
    }
	
	@GetMapping("/getCommonContacts/{userId}/{userId2}")
	public List<Contact> getCommonContacts(@PathVariable final Long userId,@PathVariable final Long userId2) throws PhoneFoundException, CreateUserException, UserNotFoundException, BadRequestException{
		return userService.getCommonContacts(userId,userId2);
    }

	
	
}
