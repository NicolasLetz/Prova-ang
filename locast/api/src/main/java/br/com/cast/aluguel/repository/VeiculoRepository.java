package br.com.cast.aluguel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.aluguel.entity.Veiculo;

@Repository
public class VeiculoRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public void inserir(Veiculo veiculo) {
		entityManager.persist(veiculo);
	}

	public Veiculo buscarPorPlaca(String placa) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Veiculo.class.getName()).append(" WHERE lower(placa)= :placa");
		Query query = entityManager.createQuery(jpql.toString());
		query.setParameter("placa", placa.toLowerCase());
		
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculos = query.getResultList();
		
		return veiculos.size()>0? veiculos.get(0) : null;
	}

	public List<Veiculo> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM ").append(Veiculo.class.getName()).append(" v ")
							.append("join fetch v.modelo m ")
							.append("join fetch m.fabricante ");
		Query query = entityManager.createQuery(jpql.toString());
		
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculos = query.getResultList();
		
		return veiculos;
	}
	
}
