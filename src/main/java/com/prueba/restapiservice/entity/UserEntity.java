package com.prueba.restapiservice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Class UserEntity.
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3335453560500443088L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** The name. */
    @Column(name = "username")
    private String name;
    
    /** The last name. */
    @Column(name = "lastname")
    private String lastName;
    
    /** The contacts. */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<ContactEntity> contacts;
    
    /** The phone. */
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="phone_id")
    private PhoneEntity phone;
    
    
    /**
     * Instantiates a new user entity.
     *
     * @param id the id
     * @param name the name
     * @param lastName the last name
     * @param contacts the contacts
     * @param phone the phone
     */
    @Builder
	public UserEntity(Long id, String name, String lastName, List<ContactEntity> contacts, PhoneEntity phone) {
		super();
		this.id = id;
		new UserEntity(this.name, this.lastName, this.contacts, this.phone);
	}
    
    /**
     * Instantiates a new user entity.
     *
     * @param name the name
     * @param lastName the last name
     * @param contacts the contacts
     * @param phone the phone
     */
    @Builder
    public UserEntity(String name, String lastName, List<ContactEntity> contacts, PhoneEntity phone) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.contacts = contacts;
		this.phone = phone;
	}
	
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
//	 * Gets the contacts.
//	 *
//	 * @return the contacts
//	 */
//	public List<ContactEntity> getContacts() {
//		return contacts;
//	}
//	
//	/**
//	 * Sets the contacts.
//	 *
//	 * @param contacts the new contacts
//	 */
//	public void setContacts(List<ContactEntity> contacts) {
//		this.contacts = contacts;
//	}
//	
//	/**
//	 * Gets the phone.
//	 *
//	 * @return the phone
//	 */
//	public PhoneEntity getPhone() {
//		return phone;
//	}
//	
//	/**
//	 * Sets the phone.
//	 *
//	 * @param phone the new phone
//	 */
//	public void setPhone(PhoneEntity phone) {
//		this.phone = phone;
//	}
//	
//	/**
//	 * Gets the serialversionuid.
//	 *
//	 * @return the serialversionuid
//	 */
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
    
    


    
    
}
