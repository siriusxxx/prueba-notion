package com.prueba.restapiservice.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.restapiservice.converter.Converter;
import com.prueba.restapiservice.dto.Contact;
import com.prueba.restapiservice.dto.Phone;
import com.prueba.restapiservice.dto.PhoneResponse;
import com.prueba.restapiservice.dto.User;
import com.prueba.restapiservice.entity.ContactEntity;
import com.prueba.restapiservice.entity.PhoneEntity;
import com.prueba.restapiservice.entity.UserEntity;
import com.prueba.restapiservice.exceptions.BadRequestException;
import com.prueba.restapiservice.exceptions.ContactException;
import com.prueba.restapiservice.exceptions.CreateUserException;
import com.prueba.restapiservice.exceptions.PhoneFoundException;
import com.prueba.restapiservice.exceptions.PhoneValidateException;
import com.prueba.restapiservice.exceptions.UserNotFoundException;
import com.prueba.restapiservice.repository.ContactRepository;
import com.prueba.restapiservice.repository.PhoneRepository;
import com.prueba.restapiservice.repository.UserRepository;
import com.prueba.restapiservice.utils.ModelConstants;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

@RestController
@RequestMapping(value = ModelConstants.REST_API_URI_USER)
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	Converter converter;
	
	public User create(final User user) throws PhoneFoundException, CreateUserException, PhoneValidateException {
		PhoneEntity phoneEntity = null;
//		if(!this.validPhone(user.getPhone())){
//			throw new PhoneValidateException("El número de teléfono no es válido, revise el código de país");
//		}
		if( user.getPhone().getNumber()!= null) {
			Optional<UserEntity> phone = userRepository.findByPhoneNumber(user.getPhone().getNumber());
			if(phone.isPresent()) {
				throw new PhoneFoundException(phone.get().getPhone().getNumber());
			}else {
				phoneEntity = new PhoneEntity(user.getPhone().getNumber(), user.getPhone().getCountryCode(), user.getPhone().getIp());
				phoneRepository.save(phoneEntity);
			}
		}
		try {
			UserEntity userEntity = new UserEntity(user.getName(), user.getLastName(),null, phoneEntity);
			userEntity = this.userRepository.save(userEntity);
			user.setId(userEntity.getId());
			return user;
			}
			catch(Exception e) {
				phoneRepository.delete(phoneEntity);
				e.printStackTrace();
				throw new CreateUserException(user.getName() + " " + user.getLastName());
			}
		
    }
	
	
	public void updateContacts(final Set<Contact> contacts, Long userId) throws PhoneFoundException, CreateUserException, UserNotFoundException, ContactException {
		Optional<UserEntity> userEntity = Optional.empty();
		List<ContactEntity> contactsEntities = new ArrayList<ContactEntity>();
		if( userId != null) {
			userEntity = userRepository.findById(userId);
			if(!userEntity.isPresent()) {
				throw new UserNotFoundException(userId.toString());
			}else {
				contactsEntities = contacts.stream().map(contact -> this.converter.convertContact(contact, userId)).collect(Collectors.toList());
				contactsEntities = checkContacts(contactsEntities);
			}
		}
		try {
			this.contactRepository.saveAll(contactsEntities);
//			contactsEntities.forEach((final ContactEntity contact)-> this.contactRepository.saveAll(contact));
		}
		catch(Exception e) {
			e.printStackTrace();
				throw new ContactException(e.getCause().toString());
		}
		
    }
	
	
	
	public List<Contact> getContacts(Long userId) throws UserNotFoundException, BadRequestException {
		UserEntity userEntity = null;
		List<Contact> contacts = Collections.emptyList();
		if( userId != null) {
			userEntity = existUser(userId);
			contacts = userEntity.getContacts().stream().map(contact -> this.converter.convertContact(contact)).collect(Collectors.toList());
		}else {
			throw new BadRequestException("Id de usuario");
		}
		return contacts;
	}
	
	public List<Contact> getCommonContacts(Long userId, Long userId2) throws UserNotFoundException, BadRequestException {
		UserEntity userEntity = null;
		UserEntity userEntity2 = null;
		List<Contact> commons = new ArrayList<Contact>();
		if( userId != null && userId2 != null) {
			userEntity = existUser(userId);
			List<Contact> contacts = userEntity.getContacts().stream().map(contact -> this.converter.convertContact(contact)).collect(Collectors.toList());
		    userEntity2 = existUser(userId2);
		    List<Contact> contacts2 = userEntity2.getContacts().stream().map(contact -> converter.convertContact(contact)).collect(Collectors.toList());
		   
		    for (Contact contact : contacts) {
		    	 Contact commonContact = contacts2.stream()
		    	  .filter(item -> item.getPhone().equals(contact.getPhone()))
		    	  .findAny()
		    	  .orElse(null);
		    	if(commonContact != null) {
		    		commons.add(commonContact);
		    	}
		    	  
		    }
			
		}else {
			throw new BadRequestException("Revise los ids de usuario");
		}
		return commons;
	}

	
//	public ContactEntity convertContact(final Contact contact, Long userId) {
////		PhoneEntity phoneEntity = new PhoneEntity(contact.getPhone(),null,null);
//		PhoneEntity phoneEntity = PhoneEntity.builder().number(contact.getPhone()).build();
//		ContactEntity contactEntity = ContactEntity.builder().userId(userId).contactName(contact.getContactName()).phone(phoneEntity).build();
//		return contactEntity;
//		
//																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															
//	}
//	
//	public Contact convertContact(final ContactEntity contactEntity) {
////		PhoneEntity phoneEntity = new PhoneEntity(contactEntity.getPhone().getNumber(), contactEntity.getPhone().getCountryCode(), contactEntity.getPhone().getIp());
//		String completeNumber = (contactEntity.getPhone().getCountryCode() != null?contactEntity.getPhone().getCountryCode():"") + contactEntity.getPhone().getNumber();  
//		return new Contact(contactEntity.getContactName(),completeNumber);
//		
//	}
	
	public List<ContactEntity> checkContacts(List<ContactEntity> contactsEntities) {
		contactsEntities.forEach(contact -> {
//		    Optional<PhoneEntity> phoneFound = phoneRepository.findByNumber(contact.getPhone().getNumber());
		    Optional<ContactEntity> contactFound = contactRepository.findByPhoneNumber(contact.getPhone().getNumber());
		    if(contactFound.isPresent() && contact.getId() == null) {
//		    	contact.setId(contactFound.get().getId());
		    	contact.setPhone(contactFound.get().getPhone());
		    }
		});
		return contactsEntities;
		
	}
//	public UserEntity convertUser(final User user, Phone phone) {
//		PhoneEntity phoneEntity = new PhoneEntity(phone.getNumber(), phone.getCountryCode(), phone.getIp());
//		
//		List<ContactEntity> contactsEntity = user.getContacts().stream().map(contact -> this.convertContact(contact,user.getId())).collect(Collectors.toList());
//		
//		UserEntity userEntity = UserEntity.builder().name(user.getName()).lastName(user.getLastName()).contacts(contactsEntity).phone(phoneEntity).build();
//		return userEntity;
//		
//	}
	
	public UserEntity existUser(Long userId) throws UserNotFoundException {
		Optional<UserEntity> userEntity = userRepository.findById(userId);
		if(!userEntity.isPresent()) {
			throw new UserNotFoundException(userId.toString());
		}
		return userEntity.get();
	}
	
	public Boolean validPhone(Phone phone) throws PhoneValidateException {
		PhoneResponse phoneResponse = new PhoneResponse() ;
		 try
	        {
	            HttpPost httpPost = new HttpPost("https://neutrinoapi.net/phone-validate");
	 
	            List<NameValuePair> postData = new ArrayList<>();
	            postData.add(new BasicNameValuePair("user-id", "mserra"));
	            postData.add(new BasicNameValuePair("api-key", "ad4B4e0Yog0zATtsZfvqqy4Uzkymq09fOpGFlnJQbJCGfq5N"));
	            postData.add(new BasicNameValuePair("number", phone.getNumber()));
//	            postData.add(new BasicNameValuePair("country-code", phone.getCountryCode()));
	            httpPost.setEntity(new UrlEncodedFormEntity(postData, "UTF-8"));
	 
	            HttpResponse response = HttpClients.createDefault().execute(httpPost);
	            String jsonStr = EntityUtils.toString(response.getEntity());
	 
	            if(jsonStr.contains("api-error")) {
	            	throw new PhoneValidateException("Error en la configuración");
	            }
	            
	            JSONObject json = new JSONObject(jsonStr);
	        
	            phoneResponse = this.convertPhoneResponse(json);
//	            phoneResponse = objectMapper.readValue(json.toString(), PhoneResponse.class); 
	            

	        }
	        catch (IOException | ParseException | JSONException ex)
	        {
	        	throw new PhoneValidateException("Erro al obtener los datos al validar el número" + phone.getCountryCode());
	        }		
		
		return phoneResponse.getValid();
		
	}
	public PhoneResponse convertPhoneResponse(JSONObject json ) {
		return PhoneResponse.builder()
				.country(json.getString("country"))
				.countryCode(json.getString("country-code"))
				.countryCode3(json.getString("country-code3"))
				.currencyCode(json.getString("currency-code"))
				.internationalCallingCode(json.getInt("international-calling-code"))
				.internationalNumber(json.getString("international-number"))
				.isMobile(json.getBoolean("is-mobile"))
				.localNumber(json.getString("local-number"))
				.location(json.getString("location"))
				.network(json.getString("prefix-network"))
				.type(json.getString("type"))
				.valid(json.getBoolean("valid"))
				.build();
	}
	
}
