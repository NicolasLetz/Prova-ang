package br.com.cast.aluguel.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.aluguel.dtos.FabricanteDTO;
import br.com.cast.aluguel.entity.Fabricante;
import br.com.cast.aluguel.repository.FabricanteRepository;

@Component
public class FabricanteBusiness {
	
	@Autowired
	FabricanteRepository fabricanteRepository;
	
	public List<FabricanteDTO> buscarTodos() {
		List<FabricanteDTO> resultado = new ArrayList<>();
		List<Fabricante> fabricantes = fabricanteRepository.buscarTodos();
		for (Fabricante fabricante : fabricantes) {
			FabricanteDTO dto = new FabricanteDTO();
			dto.setId(fabricante.getId());
			dto.setNome(fabricante.getNome());
			resultado.add(dto);
		}
		return resultado;
	}

	public List<FabricanteDTO> buscarPorId(Integer id) {
		List<FabricanteDTO> resultado = new ArrayList<>();
		Fabricante fabricante = fabricanteRepository.buscarPorId(id);
		FabricanteDTO dto = new FabricanteDTO();
		dto.setId(fabricante.getId());
		dto.setNome(fabricante.getNome());
		resultado.add(dto);
		return resultado;
	}
}