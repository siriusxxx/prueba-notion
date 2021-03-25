package com.prueba.restapiservice.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Gets the phone.
 *
 * @return the phone
 */
@Getter /**
  * Sets the phone.
  *
  * @param phone the new phone
  */
 @Setter /**
  * Instantiates a new contact.
  *
  * @param contactName the contact name
  * @param phone the phone
  */
 @AllArgsConstructor /**
  * Instantiates a new contact.
  */
 @NoArgsConstructor
public class Contact {

	/** The contact name. */
	@Size(min = 3, max = 50)
	@NotNull
	private String contactName;
	
	/** The phone. */
	@Max(15)
	private String phone;
}
