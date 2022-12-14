package com.utng.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utng.hospital.model.Expediente;

public interface ExpedienteRepository extends JpaRepository<Expediente, Integer>{
	@Query("Select a from Expediente a where a.curp = ?1")
	Optional<Expediente> consultarPorCurp(String curp);

}
