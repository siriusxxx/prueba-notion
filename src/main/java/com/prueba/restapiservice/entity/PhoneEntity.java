package com.prueba.restapiservice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

/**
 * The Class PhoneEntity.
 */
@Entity
@Table(name = "phone")
@NoArgsConstructor
@Getter
@Setter
public class PhoneEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3335453560500443088L;
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /** The number. */
    @Column(name = "phone_number")
    private String number;
    
    /** The country code. */
    @Column(name = "countrycode")
    private String countryCode;
    
    /** The ip. */
    @Column(name = "ip")
    private String ip;
    
    /**
     * To string.
     *
     * @return the java.lang. string
     */
    @Builder
	public PhoneEntity(Long id, String number, String countryCode, String ip) {
		super();
		this.number = number;
		this.countryCode = countryCode;
		this.ip = ip;
	}
    
    /**
     * Instantiates a new phone entity.
     *
     * @param number the number
     * @param countryCode the country code
     * @param ip the ip
     */
    @Builder
    public PhoneEntity(String number, String countryCode, String ip) {
		super();
		this.number = number;
		this.countryCode = countryCode;
		this.ip = ip;
	}


    
    
}
