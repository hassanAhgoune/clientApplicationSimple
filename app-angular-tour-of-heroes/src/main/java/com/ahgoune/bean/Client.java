package com.ahgoune.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Client implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private   Long  id  ;
@NotEmpty
@Size(min  =  4 ,  max=12)
@Column(nullable =false)
private  String name ;
@NotEmpty
@Size(min  =  4 ,  max=12)
@Column(nullable =false)
private  String prenom ;
@Column(nullable =false ,  unique = true)
private String  email;
@Column(name = "create_at")
@Temporal(TemporalType.DATE)
private  Date  createAt;
public Client(Long id, String name, String email, Date createAt) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.createAt = createAt;
}
public Client() {
	super();
}
@PrePersist
public   void   prePresist() {
	createAt=  new  Date();
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getCreateAt() {
	return createAt;
}
public void setCreateAt(Date createAt) {
	this.createAt = createAt;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}


}
