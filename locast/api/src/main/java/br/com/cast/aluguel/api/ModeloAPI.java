package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.business.ModeloBusiness;
import br.com.cast.aluguel.dtos.ModeloDTO;

@RestController
@RequestMapping(path = "modelo")
public class ModeloAPI {
	
	@Autowired
	ModeloBusiness modeloBusiness;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ModeloDTO> getTodos() {
		return modeloBusiness.buscarTodos();
	}
	@RequestMapping(path="/{id}", method= RequestMethod.GET)
	public List<ModeloDTO> buscarPorId(@PathVariable("id") Integer id) {
		return modeloBusiness.buscarPorIdDto(id);
	}
}