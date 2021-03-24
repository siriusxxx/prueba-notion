package com.prueba.restapiservice.converter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Component
public class Converter {

	@Autowired
	ContactRepository contactRepository;
	
	public ContactEntity convertContact(final Contact contact, Long userId) {
		PhoneEntity phoneEntity = PhoneEntity.builder().number(contact.getPhone()).build();
		ContactEntity contactEntity = ContactEntity.builder().userId(userId).contactName(contact.getContactName()).phone(phoneEntity).build();
		return contactEntity;
		
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															
	}
	
	public Contact convertContact(final ContactEntity contactEntity) {
		String completeNumber = (contactEntity.getPhone().getCountryCode() != null?contactEntity.getPhone().getCountryCode():"") + contactEntity.getPhone().getNumber();  
		return new Contact(contactEntity.getContactName(),completeNumber);
		
	}
	
	public List<ContactEntity> checkContacts(List<ContactEntity> contactsEntities) {
		contactsEntities.forEach(contact -> {
		    Optional<ContactEntity> contactFound = contactRepository.findByPhoneNumber(contact.getPhone().getNumber());
		    if(contactFound.isPresent() && contact.getId() == null) {
		    	contact.setId(contactFound.get().getId());
		    	contact.setPhone(contactFound.get().getPhone());
		    }
		});
		return contactsEntities;
		
	}
	public UserEntity convertUser(final User user, Phone phone) {
		PhoneEntity phoneEntity = new PhoneEntity(phone.getNumber(), phone.getCountryCode(), phone.getIp());
		List<ContactEntity> contactsEntity = user.getContacts().stream().map(contact -> this.convertContact(contact,user.getId())).collect(Collectors.toList());
		UserEntity userEntity = UserEntity.builder().name(user.getName()).lastName(user.getLastName()).contacts(contactsEntity).phone(phoneEntity).build();
		return userEntity;
		
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
