package br.com.cast.aluguel.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.aluguel.dtos.VeiculoDTO;
import br.com.cast.aluguel.dtos.VeiculoFormDTO;
import br.com.cast.aluguel.dtos.VeiculoListDTO;
import br.com.cast.aluguel.entity.Veiculo;
import br.com.cast.aluguel.exceptions.DuplicatedException;
import br.com.cast.aluguel.repository.VeiculoRepository;

@Component
public class VeiculoBusiness {
	@Autowired
	VeiculoRepository veiculoRepository;
	@Autowired
	ModeloBusiness modeloBusiness;
	
	@Transactional
	public void inserir(VeiculoFormDTO veiculoDto) throws DuplicatedException {
		
		if(veiculoRepository.buscarPorPlaca(veiculoDto.getPlaca()) != null) {
			throw new DuplicatedException();
		}
		Veiculo veiculo = new Veiculo();
		veiculo.setAno(veiculoDto.getAno());
		veiculo.setPlaca(veiculoDto.getPlaca());
		veiculo.setModelo(modeloBusiness.buscarPorId(veiculoDto.getIdModelo()));

		veiculoRepository.inserir(veiculo);
	}

	public List<VeiculoListDTO> buscarTodos() {
		List<VeiculoListDTO> resposta = new ArrayList<>();
		List<Veiculo> veiculos = veiculoRepository.buscarTodos();
		for (Veiculo veiculo : veiculos) {
			VeiculoListDTO dto = new VeiculoListDTO();
			dto.setAno(veiculo.getAno());
			dto.setPlaca(veiculo.getPlaca());
			dto.setNomeFabricante(veiculo.getModelo().getFabricante().getNome());
			dto.setNomeModelo(veiculo.getModelo().getNome());
			
			resposta.add(dto);
		}
		
		return resposta;
	}
	public VeiculoDTO verificaPlaca(String placa) throws DuplicatedException {
		Veiculo veiculo = veiculoRepository.buscarPorPlaca(placa);
		VeiculoDTO dto = null;
		if(veiculo != null) {
			dto= new VeiculoDTO();
		}
		return dto;
	}
}