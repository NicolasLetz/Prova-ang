package br.com.cast.aluguel.dtos;

public class VeiculoDTO {
	private Integer id;
	private ModeloDTO modelo;
	private String placa;
	private Integer ano;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ModeloDTO getModelo() {
		return modelo;
	}
	public void setModelo(ModeloDTO modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
