package com.totalshakes.wstotalshakes.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.totalshakes.wstotalshakes.ConvertToEnumTipo;
import com.totalshakes.wstotalshakes.Ingredientes;

@Entity
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Convert(converter = ConvertToEnumTipo.class)
	private Ingredientes nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ingredientes getNome() {
		return nome;
	}

	public void setNome(Ingredientes nome) {
		this.nome = nome;
	}

}
