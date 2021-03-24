package com.prueba.restapiservice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    private static final long serialVersionUID = -3335453560500443088L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String name;
    
    @Column(name = "lastname")
    private String lastName;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<ContactEntity> contacts;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="phone_id")
    private PhoneEntity phone;
    
    @Builder
	public UserEntity(Long id, String name, String lastName, List<ContactEntity> contacts, PhoneEntity phone) {
		super();
		this.id = id;
		new UserEntity(this.name, this.lastName, this.contacts, this.phone);
	}
    @Builder
    public UserEntity(String name, String lastName, List<ContactEntity> contacts, PhoneEntity phone) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.contacts = contacts;
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<ContactEntity> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactEntity> contacts) {
		this.contacts = contacts;
	}
	public PhoneEntity getPhone() {
		return phone;
	}
	public void setPhone(PhoneEntity phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    


    
    
}
