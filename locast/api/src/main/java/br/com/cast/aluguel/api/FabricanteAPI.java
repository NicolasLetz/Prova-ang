package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.business.FabricanteBusiness;
import br.com.cast.aluguel.dtos.FabricanteDTO;

@RestController
@RequestMapping(path = "fabricante")
public class FabricanteAPI {
	
	@Autowired
	FabricanteBusiness fabricanteBusiness;
	
	@RequestMapping(method= RequestMethod.GET)
	public List<FabricanteDTO> getTodos() {
		return fabricanteBusiness.buscarTodos();
	}
	@RequestMapping(path="/{id}", method= RequestMethod.GET)
	public List<FabricanteDTO> buscarPorId(@PathVariable("id") Integer id) {
		return fabricanteBusiness.buscarPorId(id);
	}
}
