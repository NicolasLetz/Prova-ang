package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.business.VeiculoBusiness;
import br.com.cast.aluguel.dtos.VeiculoDTO;
import br.com.cast.aluguel.dtos.VeiculoFormDTO;
import br.com.cast.aluguel.dtos.VeiculoListDTO;
import br.com.cast.aluguel.exceptions.DuplicatedException;

@RestController
@RequestMapping(path = "veiculo")
public class VeiculoAPI {
	
	@Autowired
	VeiculoBusiness veiculoBusiness;
	
	@RequestMapping(method= RequestMethod.POST)
	public void salvar(@RequestBody VeiculoFormDTO veiculoFormDto) throws DuplicatedException {
		veiculoBusiness.inserir(veiculoFormDto);
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public List<VeiculoListDTO> buscarTodos() {
		return veiculoBusiness.buscarTodos();
	}
	@RequestMapping(path="/{placa}", method= RequestMethod.GET)
	public VeiculoDTO verificaDuplicidade(@PathVariable("placa") String placa) throws DuplicatedException {
		return veiculoBusiness.verificaPlaca(placa);
	}
}