package com.utng.hospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utng.hospital.model.Expediente;
import com.utng.hospital.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{
	@Query("Select a from Medico a where a.idMedico = ?1")
	Optional<Medico> consultarMedico(Integer idMedico);

}
