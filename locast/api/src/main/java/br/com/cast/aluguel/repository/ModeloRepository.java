package br.com.cast.aluguel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.entity.Modelo;

@Repository
public class ModeloRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Modelo buscarPorId(Integer id) {
		return entityManager.find(Modelo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Modelo> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Modelo.class.getName()).append(" m ")
			.append("join fetch m.fabricante");
		
		Query query = entityManager.createQuery(jpql.toString());
		
		return query.getResultList();
	}
}