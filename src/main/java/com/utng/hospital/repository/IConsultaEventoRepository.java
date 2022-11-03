package com.utng.hospital.repository;

import com.utng.hospital.model.Evento;
import com.utng.hospital.model.EventoFiltroRequest;
import com.utng.hospital.model.Response;

public interface IConsultaEventoRepository {

	Response<Evento> busquedaEvento(EventoFiltroRequest filtro);

}
