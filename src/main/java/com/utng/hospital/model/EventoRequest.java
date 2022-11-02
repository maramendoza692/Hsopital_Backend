package com.utng.hospital.model;

import java.sql.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventoRequest {
	
	private Integer idEvento;
	
	private Integer idMedico;
	
	private Integer idExpediente;
	
	private String causaIngreso;
	
	private String diagnostico;
	
	private String sintomas;
	
	private String tratamiento;
	
	private Date fecha;
	
		
}
