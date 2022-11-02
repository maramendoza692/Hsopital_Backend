package com.utng.hospital.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "EXPEDIENTE")
public class Expediente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6516696052207874003L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idExpediente")
	private Integer idExpediente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apePat")
	private String apePat;
	
	@Column(name = "apeMat")
	private String apeMat;
	
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "curp")
	private String curp;
	
	@Column(name = "lugarNacimiento")
	private String lugarNacimiento;
	
	@Column(name = "tipoSangre")
	private String tipoSangre;
	
	@Column(name = "noSeguroMedico")
	private Integer noSeguroMedico;
	
	@Column(name = "alergias")
	private String alergias;
	
	@Column(name = "enfermedadesCronicas")
	private String enfermedadesCronicas;
	
}
