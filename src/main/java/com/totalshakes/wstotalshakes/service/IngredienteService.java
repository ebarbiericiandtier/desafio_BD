package com.totalshakes.wstotalshakes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totalshakes.wstotalshakes.entity.Ingrediente;
import com.totalshakes.wstotalshakes.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository repository;

	public void salvar(Ingrediente ingrediente) {
		repository.save(ingrediente);
	}

	public void deletar(Integer id) {
		Ingrediente ingrediente = repository.findById(id).get();
		if (ingrediente == null)
			throw new IllegalArgumentException("Registro não encontrado");

		repository.delete(ingrediente);
	}

	public void atualizar(Ingrediente ingrediente) {
		Ingrediente ingredienteNovo = repository.findById(ingrediente.getId()).get();
		if (ingrediente == null)
			throw new IllegalArgumentException("Registro não encontrado");

		ingredienteNovo.setId(ingrediente.getId());
		ingredienteNovo.setNome(ingrediente.getNome());
		repository.delete(ingrediente);
		repository.save(ingredienteNovo);
	}

}
