package com.prueba.restapiservice.dto;

import javax.validation.constraints.Max;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PhoneResponse {

	private Boolean valid;
	private String type;
	private Integer internationalCallingCode;
	private String internationalNumber;
	private String localNumber;
	private String location;
	private String country;
	private String countryCode;
	private String countryCode3;
	private String currencyCode;
	private Boolean isMobile;
	private String network;
	
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getInternationalCallingCode() {
		return internationalCallingCode;
	}
	public void setInternationalCallingCode(Integer internationalCallingCode) {
		this.internationalCallingCode = internationalCallingCode;
	}
	public String getInternationalNumber() {
		return internationalNumber;
	}
	public void setInternationalNumber(String internationalNumber) {
		this.internationalNumber = internationalNumber;
	}
	public String getLocalNumber() {
		return localNumber;
	}
	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryCode3() {
		return countryCode3;
	}
	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Boolean getIsMobile() {
		return isMobile;
	}
	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	
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
