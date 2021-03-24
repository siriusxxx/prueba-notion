package com.prueba.restapiservice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.prueba.restapiservice.dto.User;


@Entity
@Table(name = "contact")
@NoArgsConstructor
@Getter
@Setter
public class ContactEntity {

    private static final long serialVersionUID = -3335453560500443088L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "contactname")
    private String contactName;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="phone_id")
    private PhoneEntity phone;
    
    @Column(name="user_id", nullable=false)
    private Long userId;

    @Builder
	public ContactEntity(Long id, String contactName, PhoneEntity phone, Long userId) {
		super();
		this.contactName = contactName;
		this.phone = phone;
		this.userId = userId;
	}
    
 

    
	


    
    
}
