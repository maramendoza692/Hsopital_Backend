package com.utng.hospital.service;

import com.utng.hospital.model.Expediente;
import com.utng.hospital.model.ExpedienteFiltroRequest;
import com.utng.hospital.model.Response;

public interface IExpedienteService {

	Response<Expediente> buscarExpediente(ExpedienteFiltroRequest curp);

	Response<Expediente> buscarExpedienteId(Integer idExpediente);

}
