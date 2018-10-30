package br.com.cast.aluguel.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.aluguel.dtos.FabricanteDTO;
import br.com.cast.aluguel.dtos.ModeloDTO;
import br.com.cast.aluguel.entity.Modelo;
import br.com.cast.aluguel.repository.ModeloRepository;

@Component
public class ModeloBusiness {
	
	@Autowired
	ModeloRepository modeloRepository;
	
	@Transactional
	public Modelo buscarPorId(Integer id) {
		return modeloRepository.buscarPorId(id);
	}

	public List<ModeloDTO> buscarTodos() {
		List<ModeloDTO> resultado = new ArrayList<>();
		List<Modelo> modelos = modeloRepository.buscarTodos();
		for (Modelo modelo : modelos) {
			ModeloDTO dto = new ModeloDTO();
			dto.setId(modelo.getId());
			dto.setNome(modelo.getNome());
			
			dto.setFabricante(new FabricanteDTO());
			dto.getFabricante().setId(modelo.getFabricante().getId());
			dto.getFabricante().setNome(modelo.getFabricante().getNome());
			
			resultado.add(dto);
		}
		return resultado;
	}

	public List<ModeloDTO> buscarPorIdDto(Integer id) {
		Modelo modelo = modeloRepository.buscarPorId(id);
		ModeloDTO dto = new ModeloDTO();
		dto.setFabricante(new FabricanteDTO());
		dto.getFabricante().setId(modelo.getFabricante().getId());
		dto.getFabricante().setNome(modelo.getFabricante().getNome());
		List<ModeloDTO> resposta = new ArrayList<>();
		resposta.add(dto);
		return resposta;
	}
}