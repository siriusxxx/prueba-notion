package com.prueba.restapiservice.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Contact {

	@Size(min = 3, max = 50)
	@NotNull
	private String contactName;
	@Max(15)
	private String phone;
}
