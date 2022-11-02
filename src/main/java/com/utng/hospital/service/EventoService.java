package com.utng.hospital.service;

import com.utng.hospital.model.Evento;
import com.utng.hospital.model.EventoRequest;
import com.utng.hospital.model.Expediente;
import com.utng.hospital.model.Medico;
import com.utng.hospital.model.Response;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.hospital.repository.EventoRepository;
import com.utng.hospital.repository.ExpedienteRepository;
import com.utng.hospital.repository.MedicoRepository;

@Service
public class EventoService implements IEventoService{
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ExpedienteRepository expedienteRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public Response<Evento> consultarTodos() {
		
		Response<Evento> response = new Response<Evento>();
		List<Evento> lista = eventoRepository.findAll();
		
		if(lista.isEmpty()) {
			response.setMessage("No hay resultados");
			
		}else {
			response.setMessage("Consulta correcta");
		}
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());
		
		return response;
	}
	@Override
	public Response<Evento> guardarEvento(EventoRequest evento) {
		Response<Evento> response = new Response<Evento>();
		
		Optional <Expediente> optionalExpediente = expedienteRepository.findById(evento.getIdExpediente());
		Expediente expediente = null;
		
		Evento evento1 = null;
		Evento evento2 = null;
		
		Optional<Medico> optionalMedico = medicoRepository.findById(evento.getIdMedico());
		Medico medico = null;
		if (optionalExpediente.isPresent()) {
			expediente = optionalExpediente.get();
			evento1 = new Evento();
			
			evento1.setIdMedico(medico);
			evento1.setIdExpediente(expediente);
			evento1.setCausaIngreso(evento.getCausaIngreso());
			evento1.setDiagnostico(evento.getDiagnostico());
			evento1.setSintomas(evento.getSintomas());
			evento1.setTratamiento(evento.getTratamiento());
			evento1.setFecha(evento.getFecha());
		
			
			
			
			evento2 = eventoRepository.save(evento1);
			
			response.setStatus("OK");
			response.setMessage("Guardado correctamente");
			response.setData(evento2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("El expediente no existe");
			response.setData(null);
		}
		if (optionalMedico.isPresent()) {
			medico = optionalMedico.get();
			evento1.setCausaIngreso(evento.getCausaIngreso());
			evento1.setIdExpediente(expediente);
			evento1.setDiagnostico(evento.getDiagnostico());
			evento1.setSintomas(evento.getSintomas());
			evento1.setTratamiento(evento.getTratamiento());
			evento1.setFecha(evento.getFecha());
			evento1.setIdMedico(medico);
			
			
			evento2 = eventoRepository.save(evento1);
			
			response.setStatus("OK");
			response.setMessage("Guardado correctamente");
			response.setData(evento2);
		}else {
			response.setStatus("ERROR");
			response.setMessage("El medico no existe");
			response.setData(null);
		}
		
		return response;
	}
	
	


}
