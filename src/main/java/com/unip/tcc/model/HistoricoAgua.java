package com.unip.tcc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="historico_agua")
public class HistoricoAgua {
	
	@Id
	@GeneratedValue(generator= "increment")
	@GenericGenerator(name="increment", strategy ="increment")
	@Column(name="id")
	private Integer id;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="quantidade_litros_hora")
	private Double quantidadeLitrosHora;
	
	@Column(name="quantidade_litros_total")
	private Double quantidadeLitrosTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getQuantidadeLitrosHora() {
		return quantidadeLitrosHora;
	}

	public void setQuantidadeLitrosHora(Double quantidadeLitrosHora) {
		this.quantidadeLitrosHora = quantidadeLitrosHora;
	}

	public Double getQuantidadeLitrosTotal() {
		return quantidadeLitrosTotal;
	}

	public void setQuantidadeLitrosTotal(Double quantidadeLitrosTotal) {
		this.quantidadeLitrosTotal = quantidadeLitrosTotal;
	}
}
