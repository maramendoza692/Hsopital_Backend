package com.utng.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utng.hospital.model.Evento;
import com.utng.hospital.model.Expediente;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
	

}
