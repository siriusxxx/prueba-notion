package com.prueba.restapiservice.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter 
@NoArgsConstructor
public class User {

	/** The id. */
	private Long id;
	
	/** The name. */
	@Size(min = 3, max = 50)
	@NotNull
	private String name;
	
	/** The last name. */
	@Size(min = 3, max = 50)
	@NotNull
	private String lastName;
	
	/** The phone. */
	@NotNull
	private Phone phone;
	
	/** The contacts. */
	private Set<Contact> contacts;
	
//	/**
//	 * Gets the id.
//	 *
//	 * @return the id
//	 */
//	public Long getId() {
//		return id;
//	}
//	
//	/**
//	 * Sets the id.
//	 *
//	 * @param id the new id
//	 */
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	/**
//	 * Gets the name.
//	 *
//	 * @return the name
//	 */
//	public String getName() {
//		return name;
//	}
//	
//	/**
//	 * Sets the name.
//	 *
//	 * @param name the new name
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	/**
//	 * Gets the last name.
//	 *
//	 * @return the last name
//	 */
//	public String getLastName() {
//		return lastName;
//	}
//	
//	/**
//	 * Sets the last name.
//	 *
//	 * @param lastName the new last name
//	 */
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	
//	/**
//	 * Gets the phone.
//	 *
//	 * @return the phone
//	 */
//	public Phone getPhone() {
//		return phone;
//	}
//	
//	/**
//	 * Sets the phone.
//	 *
//	 * @param phone the new phone
//	 */
//	public void setPhone(Phone phone) {
//		this.phone = phone;
//	}
//	
//	/**
//	 * Gets the contacts.
//	 *
//	 * @return the contacts
//	 */
//	public Set<Contact> getContacts() {
//		return contacts;
//	}
//	
//	/**
//	 * Sets the contacts.
//	 *
//	 * @param contacts the new contacts
//	 */
//	public void setContacts(Set<Contact> contacts) {
//		this.contacts = contacts;
//	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param name the name
	 * @param lastName the last name
	 * @param phone the phone
	 * @param contacts the contacts
	 */
	@Builder
	public User(Long id, @Size(min = 3, max = 50) @NotNull String name,
			@Size(min = 3, max = 50) @NotNull String lastName, @NotNull Phone phone, Set<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.contacts = contacts;
	}
	
	
	

}
