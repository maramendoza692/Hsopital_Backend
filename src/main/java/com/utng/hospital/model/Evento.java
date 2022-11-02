package com.utng.hospital.model;

import java.io.Serializable;
import java.sql.Date;

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
@Entity(name = "EVENTO")
public class Evento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6516696052207874003L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idEvento")
	private Integer idEvento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMedico")
	private Medico idMedico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idExpediente")
	private Expediente idExpediente;
	
	@Column(name = "causaIngreso")
	private String causaIngreso;
	
	@Column(name = "diagnostico")
	private String diagnostico;
	
	@Column(name = "sintomas")
	private String sintomas;
	
	@Column(name = "tratamiento")
	private String tratamiento;
	
	@Column(name = "fecha")
	private Date fecha;
	
	
	
}
