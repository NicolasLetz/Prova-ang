package br.com.cast.aluguel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.entity.Fabricante;

@Repository
public class FabricanteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Fabricante.class.getName()).append(" f ");
		
		Query query = entityManager.createQuery(jpql.toString());
		
		return query.getResultList();
	}
	public Fabricante buscarPorId(Integer id) {
		return entityManager.find(Fabricante.class, id);
	}
}