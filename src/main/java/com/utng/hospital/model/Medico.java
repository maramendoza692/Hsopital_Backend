package com.utng.hospital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
@Table(name = "MEDICO")
public class Medico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6817630978878641116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idMedico")
	private Integer idMedico;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apePat")
	private String apePat;
	
	@Column(name = "apeMat")
	private String apeMat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idHospital")
	private Hospital idHospital;
	
}
