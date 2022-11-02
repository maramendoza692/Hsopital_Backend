package com.utng.hospital.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utng.hospital.model.Expediente;
import com.utng.hospital.model.ExpedienteFiltroRequest;
import com.utng.hospital.model.Response;

@Repository
public class ConsultaExpedienteRepository implements IConsultaExpedienteRepository{

	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	@Override
	public Response<Expediente> busquedaExpediente(ExpedienteFiltroRequest filtro) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Expediente> cq = cb.createQuery(Expediente.class);
	
		Root<Expediente> root = cq.from(Expediente.class);
		
		List<Predicate> predicados = new ArrayList<Predicate>();
		
		if(filtro.getCurp() != null && !filtro.getCurp().isEmpty()) {
									
			predicados.add(cb.like(root.get("curp"), "%"+ filtro.getCurp() + "%"));
		}
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		cq.orderBy(cb.asc(root.get("idExpediente")));
		
		CriteriaQuery<Expediente> select= cq.select(root);
		
		TypedQuery<Expediente> typedQuery= em.createQuery(select);
		
		List<Expediente> lista= typedQuery.getResultList();
		
		Response<Expediente> response= new Response<Expediente>();
		
		if (!lista.isEmpty()) {
			response.setList(lista);
			response.setStatus("OK");
			response.setMessage("Consulta exitosa");
			response.setCount(lista.size());
		}else {
			response.setMessage("Sin resultados");
			response.setStatus("OK");
		}
				
		return response;
	}
}
