package com.utng.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utng.hospital.model.Expediente;
import com.utng.hospital.model.ExpedienteFiltroRequest;
import com.utng.hospital.model.Response;
import com.utng.hospital.service.IExpedienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/expediente")
public class ExpedienteController {
	
	@Autowired
	private IExpedienteService expedienteService;
	
	@PostMapping(path = "/buscarExpediente",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Expediente>> buscarExpediente (
			@RequestBody ExpedienteFiltroRequest filtro){
				
				Response<Expediente> response = expedienteService.buscarExpediente(filtro);
				
				return new ResponseEntity<Response<Expediente>>(response,HttpStatus.OK);
			
	} 
	
	@GetMapping(path = "/consultarExpedientePorID/{idExpediente}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Expediente>> consultarExpedientePorID (@PathVariable("idExpediente") Integer idExpediente){ // pathVariable = solo se mandara una variable el cual sera el id de solo un objeto
		
		
		Response<Expediente> response = expedienteService.buscarExpedienteId(idExpediente);
		
		return new ResponseEntity<Response<Expediente>> (response,HttpStatus.OK);
		
	}
}
