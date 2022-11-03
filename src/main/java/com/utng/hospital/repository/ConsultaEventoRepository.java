package com.utng.hospital.repository;

import java.sql.Date;
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

import com.utng.hospital.model.Evento;
import com.utng.hospital.model.EventoFiltroRequest;
import com.utng.hospital.model.Response;

@Repository
public class ConsultaEventoRepository implements IConsultaEventoRepository{

	@PersistenceContext
	@Autowired
	private EntityManager em;
	
	@Override
	public Response<Evento> busquedaEvento(EventoFiltroRequest filtro) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Evento> cq = cb.createQuery(Evento.class);
	
		Root<Evento> root = cq.from(Evento.class);
		
		List<Predicate> predicados = new ArrayList<Predicate>();
		
		if(filtro.getFechaIngreso() != null && !filtro.getFechaIngreso().isEmpty()) {
			
			String fecha1 = filtro.getFechaIngreso() + "-01-01";
			String fecha2 = filtro.getFechaIngreso() + "-12-31";
			Date date1 = Date.valueOf(fecha1);
			Date date2 = Date.valueOf(fecha2);

			// Se hace una comparacion entre las 2 fechas
			predicados.add(cb.between(root.get("fechaIngreso"), date1, date2));
		}
		if (!predicados.isEmpty()) {
			Predicate[] pr= new Predicate[predicados.size()];
			predicados.toArray(pr);
			cq.where(pr);
		}
		cq.orderBy(cb.asc(root.get("idExpediente")));
		
		CriteriaQuery<Evento> select= cq.select(root);
		
		TypedQuery<Evento> typedQuery= em.createQuery(select);
		
		List<Evento> lista= typedQuery.getResultList();
		
		Response<Evento> response= new Response<Evento>();
		
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
