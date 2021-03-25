package com.prueba.restapiservice.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.prueba.restapiservice.dto.Contact;
import com.prueba.restapiservice.dto.Phone;
import com.prueba.restapiservice.dto.PhoneResponse;
import com.prueba.restapiservice.dto.User;
import com.prueba.restapiservice.entity.ContactEntity;
import com.prueba.restapiservice.entity.PhoneEntity;
import com.prueba.restapiservice.entity.UserEntity;
import com.prueba.restapiservice.repository.ContactRepository;
import org.json.JSONObject;

/**
 * The Class Converter.
 */
@Component
public class Converter {

	/** The contact repository. */
	@Autowired
	ContactRepository contactRepository;
	
	/**
	 * Convert contact.
	 *
	 * @param contact the contact
	 * @param userId the user id
	 * @return the contact entity
	 */
	public ContactEntity convertContact(final Contact contact, Long userId) {
		PhoneEntity phoneEntity = PhoneEntity.builder().number(contact.getPhone()).build();
		ContactEntity contactEntity = ContactEntity.builder().userId(userId).contactName(contact.getContactName()).phone(phoneEntity).build();
		return contactEntity;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															
	}
	
	/**
	 * Convert contact.
	 *
	 * @param contactEntity the contact entity
	 * @return the contact
	 */
	public Contact convertContact(final ContactEntity contactEntity) {
		String completeNumber = (contactEntity.getPhone().getCountryCode() != null?contactEntity.getPhone().getCountryCode():"") + contactEntity.getPhone().getNumber();  
		return new Contact(contactEntity.getContactName(),completeNumber);
		
	}
	
	/**
	 * Check contacts.
	 *
	 * @param contactsEntities the contacts entities
	 * @return the list
	 */
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
	
	/**
	 * Convert user.
	 *
	 * @param user the user
	 * @param phone the phone
	 * @return the user entity
	 */
	public UserEntity convertUser(final User user, Phone phone) {
		PhoneEntity phoneEntity = new PhoneEntity(phone.getNumber(), phone.getCountryCode(), phone.getIp());
		List<ContactEntity> contactsEntity = user.getContacts().stream().map(contact -> this.convertContact(contact,user.getId())).collect(Collectors.toList());
		UserEntity userEntity = UserEntity.builder().name(user.getName()).lastName(user.getLastName()).contacts(contactsEntity).phone(phoneEntity).build();
		return userEntity;
		
	}
	
	/**
	 * Convert phone response.
	 *
	 * @param json the json
	 * @return the phone response
	 */
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
