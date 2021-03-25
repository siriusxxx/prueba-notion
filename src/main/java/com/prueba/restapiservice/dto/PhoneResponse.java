package com.prueba.restapiservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class PhoneResponse.
 */
@Getter @Setter
@NoArgsConstructor
public class PhoneResponse {

	/** The valid. */
	private Boolean valid;
	
	/** The type. */
	private String type;
	
	/** The international calling code. */
	private Integer internationalCallingCode;
	
	/** The international number. */
	private String internationalNumber;
	
	/** The local number. */
	private String localNumber;
	
	/** The location. */
	private String location;
	
	/** The country. */
	private String country;
	
	/** The country code. */
	private String countryCode;
	
	/** The country code 3. */
	private String countryCode3;
	
	/** The currency code. */
	private String currencyCode;
	
	/** The is mobile. */
	private Boolean isMobile;
	
	/** The network. */
	private String network;
	
//	/**
//	 * Gets the valid.
//	 *
//	 * @return the valid
//	 */
//	public Boolean getValid() {
//		return valid;
//	}
//	
//	/**
//	 * Sets the valid.
//	 *
//	 * @param valid the new valid
//	 */
//	public void setValid(Boolean valid) {
//		this.valid = valid;
//	}
//	
//	/**
//	 * Gets the type.
//	 *
//	 * @return the type
//	 */
//	public String getType() {
//		return type;
//	}
//	
//	/**
//	 * Sets the type.
//	 *
//	 * @param type the new type
//	 */
//	public void setType(String type) {
//		this.type = type;
//	}
//	
//	/**
//	 * Gets the international calling code.
//	 *
//	 * @return the international calling code
//	 */
//	public Integer getInternationalCallingCode() {
//		return internationalCallingCode;
//	}
//	
//	/**
//	 * Sets the international calling code.
//	 *
//	 * @param internationalCallingCode the new international calling code
//	 */
//	public void setInternationalCallingCode(Integer internationalCallingCode) {
//		this.internationalCallingCode = internationalCallingCode;
//	}
//	
//	/**
//	 * Gets the international number.
//	 *
//	 * @return the international number
//	 */
//	public String getInternationalNumber() {
//		return internationalNumber;
//	}
//	
//	/**
//	 * Sets the international number.
//	 *
//	 * @param internationalNumber the new international number
//	 */
//	public void setInternationalNumber(String internationalNumber) {
//		this.internationalNumber = internationalNumber;
//	}
//	
//	/**
//	 * Gets the local number.
//	 *
//	 * @return the local number
//	 */
//	public String getLocalNumber() {
//		return localNumber;
//	}
//	
//	/**
//	 * Sets the local number.
//	 *
//	 * @param localNumber the new local number
//	 */
//	public void setLocalNumber(String localNumber) {
//		this.localNumber = localNumber;
//	}
//	
//	/**
//	 * Gets the location.
//	 *
//	 * @return the location
//	 */
//	public String getLocation() {
//		return location;
//	}
//	
//	/**
//	 * Sets the location.
//	 *
//	 * @param location the new location
//	 */
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	
//	/**
//	 * Gets the country.
//	 *
//	 * @return the country
//	 */
//	public String getCountry() {
//		return country;
//	}
//	
//	/**
//	 * Sets the country.
//	 *
//	 * @param country the new country
//	 */
//	public void setCountry(String country) {
//		this.country = country;
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
//	 * Gets the country code 3.
//	 *
//	 * @return the country code 3
//	 */
//	public String getCountryCode3() {
//		return countryCode3;
//	}
//	
//	/**
//	 * Sets the country code 3.
//	 *
//	 * @param countryCode3 the new country code 3
//	 */
//	public void setCountryCode3(String countryCode3) {
//		this.countryCode3 = countryCode3;
//	}
//	
//	/**
//	 * Gets the currency code.
//	 *
//	 * @return the currency code
//	 */
//	public String getCurrencyCode() {
//		return currencyCode;
//	}
//	
//	/**
//	 * Sets the currency code.
//	 *
//	 * @param currencyCode the new currency code
//	 */
//	public void setCurrencyCode(String currencyCode) {
//		this.currencyCode = currencyCode;
//	}
//	
//	/**
//	 * Gets the checks if is mobile.
//	 *
//	 * @return the checks if is mobile
//	 */
//	public Boolean getIsMobile() {
//		return isMobile;
//	}
//	
//	/**
//	 * Sets the checks if is mobile.
//	 *
//	 * @param isMobile the new checks if is mobile
//	 */
//	public void setIsMobile(Boolean isMobile) {
//		this.isMobile = isMobile;
//	}
//	
//	/**
//	 * Gets the network.
//	 *
//	 * @return the network
//	 */
//	public String getNetwork() {
//		return network;
//	}
//	
//	/**
//	 * Sets the network.
//	 *
//	 * @param network the new network
//	 */
//	public void setNetwork(String network) {
//		this.network = network;
//	}
	
	
	/**
	 * Instantiates a new phone response.
	 *
	 * @param valid the valid
	 * @param type the type
	 * @param internationalCallingCode the international calling code
	 * @param internationalNumber the international number
	 * @param localNumber the local number
	 * @param location the location
	 * @param country the country
	 * @param countryCode the country code
	 * @param countryCode3 the country code 3
	 * @param currencyCode the currency code
	 * @param isMobile the is mobile
	 * @param network the network
	 */
	@Builder
	public PhoneResponse(Boolean valid, String type, Integer internationalCallingCode, String internationalNumber,
			String localNumber, String location, String country, String countryCode, String countryCode3,
			String currencyCode, Boolean isMobile, String network) {
		super();
		this.valid = valid;
		this.type = type;
		this.internationalCallingCode = internationalCallingCode;
		this.internationalNumber = internationalNumber;
		this.localNumber = localNumber;
		this.location = location;
		this.country = country;
		this.countryCode = countryCode;
		this.countryCode3 = countryCode3;
		this.currencyCode = currencyCode;
		this.isMobile = isMobile;
		this.network = network;
	}
	
	
	
		
	
}
