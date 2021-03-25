package com.prueba.restapiservice.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Phone.
 */
@Getter @Setter 
 /**
  * Instantiates a new phone.
  *
  * @param id the id
  * @param number the number
  * @param countryCode the country code
  * @param ip the ip
  */
 @AllArgsConstructor 
 /**
  * Instantiates a new phone.
  */
 @NoArgsConstructor
public class Phone {

	/** The id. */
	private Long id;
	
	/** The number. */
	@NotNull
	private String number;
	
	/** The country code. */
	@Max(3)
	private String countryCode;
	
	/** The ip. */
	private String ip;
	
//	/**
//	 * Gets the number.
//	 *
//	 * @return the number
//	 */
//	public String getNumber() {
//		return number;
//	}
//	
//	/**
//	 * Sets the number.
//	 *
//	 * @param number the new number
//	 */
//	public void setNumber(String number) {
//		this.number = number;
//	}
//	
//	/**
//	 * Gets the country code.
//	 *
//	 * @return the country code
//	 */
//	public String getCountryCode() {
//		return countryCode;
//	}
//	
//	/**
//	 * Sets the country code.
//	 *
//	 * @param countryCode the new country code
//	 */
//	public void setCountryCode(String countryCode) {
//		this.countryCode = countryCode;
//	}
//	
//	/**
//	 * Gets the ip.
//	 *
//	 * @return the ip
//	 */
//	public String getIp() {
//		return ip;
//	}
//	
//	/**
//	 * Sets the ip.
//	 *
//	 * @param ip the new ip
//	 */
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//	
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
	/**
	 * Instantiates a new phone.
	 *
	 * @param number the number
	 * @param countryCode the country code
	 * @param ip the ip
	 */
	public Phone(@NotNull String number, @Max(3) String countryCode, String ip) {
		super();
		this.number = number;
		this.countryCode = countryCode;
		this.ip = ip;
	}
	
	
}
