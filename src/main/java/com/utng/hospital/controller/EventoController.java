package com.utng.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.utng.hospital.model.Evento;
import com.utng.hospital.model.EventoRequest;
import com.utng.hospital.model.Response;
import com.utng.hospital.service.IEventoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private IEventoService eventoService;
	
	
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Evento>> consultartodos(){
		
		Response<Evento> lista = eventoService.consultarTodos();
		
		return new ResponseEntity<Response<Evento>> (lista, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarEvento",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <Evento>> guardarEvento (@RequestBody EventoRequest evento){
	
		Response<Evento> response = eventoService.guardarEvento(evento);
		return new ResponseEntity<Response<Evento>> (response, HttpStatus.OK);
	}
	
	
}
