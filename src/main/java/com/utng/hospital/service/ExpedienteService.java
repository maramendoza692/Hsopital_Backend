package com.utng.hospital.service;

import com.utng.hospital.model.Expediente;
import com.utng.hospital.model.ExpedienteFiltroRequest;
import com.utng.hospital.model.Response;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utng.hospital.repository.ConsultaExpedienteRepository;
import com.utng.hospital.repository.ExpedienteRepository;

@Service
public class ExpedienteService implements IExpedienteService{
	
	@Autowired
	private ConsultaExpedienteRepository consultaExpedienteRepository;
	
	@Autowired
	private ExpedienteRepository expedienteRepository;
	
	
	@Override
	public Response<Expediente> buscarExpediente(ExpedienteFiltroRequest curp) {
		Response<Expediente> response = new Response<Expediente>();
		
		response = consultaExpedienteRepository.busquedaExpediente(curp);
		
		return response;
	}
	
	@Override
	public Response<Expediente> buscarExpedienteId(Integer idExpediente) {
		Response<Expediente> response = new Response<Expediente>();

		Expediente expediente = null;

		Optional<Expediente> optional = expedienteRepository.findById(idExpediente); // optional es una capsula para saber si regresó o no un registro
																	
		if (optional.isPresent()) {

			expediente = optional.get();
			expediente = optional.get();
			response.setStatus("OK");
			response.setMessage("Busqueda correcta");
			response.setData(expediente);

		} else {

			response.setMessage("Sin resultados");
			response.setData(null);

		}

		return response;
	}



}
