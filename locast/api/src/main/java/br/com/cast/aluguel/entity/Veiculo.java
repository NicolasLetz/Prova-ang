package br.com.cast.aluguel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo", schema = "aluguel")
public class Veiculo {

	@Id
	@SequenceGenerator(name = "generator_veiculo", initialValue = 1, allocationSize = 1, sequenceName = "aluguel.seq_id_veiculo")
	@GeneratedValue(generator = "generator_veiculo", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_modelo", nullable = false)
	private Modelo modelo;

	@Column(name = "placa", length = 7, nullable = false)
	private String placa;

	@Column(name = "ano", nullable = false)
	private Integer ano;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
