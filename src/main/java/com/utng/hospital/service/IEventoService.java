package com.utng.hospital.service;

import com.utng.hospital.model.Evento;
import com.utng.hospital.model.EventoRequest;
import com.utng.hospital.model.Response;

public interface IEventoService {

	Response<Evento> consultarTodos();

	Response<Evento> guardarEvento(EventoRequest evento);

}
