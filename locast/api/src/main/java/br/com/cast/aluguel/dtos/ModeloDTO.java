package br.com.cast.aluguel.dtos;

public class ModeloDTO {
	private Integer id;
	private String nome;
	private FabricanteDTO fabricante;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public FabricanteDTO getFabricante() {
		return fabricante;
	}
	public void setFabricante(FabricanteDTO fabricante) {
		this.fabricante = fabricante;
	}
}
