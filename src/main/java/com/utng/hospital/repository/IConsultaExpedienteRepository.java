package com.utng.hospital.repository;

import com.utng.hospital.model.Expediente;
import com.utng.hospital.model.ExpedienteFiltroRequest;
import com.utng.hospital.model.Response;

public interface IConsultaExpedienteRepository {

	Response<Expediente> busquedaExpediente(ExpedienteFiltroRequest filtro);

}
