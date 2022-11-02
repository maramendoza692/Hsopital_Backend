package com.utng.hospital.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "HOSPITAL")
public class Hospital implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4699050915446857113L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idHospital")
	private Integer idHospital;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dirección")
	private String direccion;
	
}
