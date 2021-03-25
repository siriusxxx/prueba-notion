package com.prueba.restapiservice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.prueba.restapiservice.dto.User;
/**
 * The Class ContactEntity.
 */
@Entity
@Table(name = "contact")
@NoArgsConstructor
@Getter
@Setter
public class ContactEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3335453560500443088L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /** The contact name. */
    @Column(name = "contactname")
    private String contactName;
    
    /** The phone. */
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="phone_id")
    private PhoneEntity phone;
    
    /** The user id. */
    @Column(name="user_id", nullable=false)
    private Long userId;

    /**
     * Instantiates a new contact entity.
     *
     * @param id the id
     * @param contactName the contact name
     * @param phone the phone
     * @param userId the user id
     */
    @Builder
	public ContactEntity(Long id, String contactName, PhoneEntity phone, Long userId) {
		super();
		this.contactName = contactName;
		this.phone = phone;
		this.userId = userId;
	}
    
 

    
	


    
    
}
