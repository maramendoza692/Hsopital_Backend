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
@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8442086246321759899L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idMedicamento")
	private Integer idMedicamento;
	
	@Column(name = "descripcion")
	private String descripcion;
	
}
