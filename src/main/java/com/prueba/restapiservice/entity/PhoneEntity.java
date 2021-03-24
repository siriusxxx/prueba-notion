package com.prueba.restapiservice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "phone")
@NoArgsConstructor
@Getter
@Setter
public class PhoneEntity {

    private static final long serialVersionUID = -3335453560500443088L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "phone_number")
    private String number;
    
    @Column(name = "countrycode")
    private String countryCode;
    
    @Column(name = "ip")
    private String ip;
    
//    @JoinColumn(name = "student_id")
//    @OneToOne(fetch = FetchType.LAZY)
//    private UserEntity user;
//    
//    @JoinColumn(name = "contact_id")
//    @OneToOne(fetch = FetchType.LAZY)
//    private ContactEntity contact;
    @Builder
	public PhoneEntity(Long id, String number, String countryCode, String ip) {
		super();
		this.number = number;
		this.countryCode = countryCode;
		this.ip = ip;
	}
    @Builder
    public PhoneEntity(String number, String countryCode, String ip) {
		super();
		this.number = number;
		this.countryCode = countryCode;
		this.ip = ip;
	}


    
    
}
