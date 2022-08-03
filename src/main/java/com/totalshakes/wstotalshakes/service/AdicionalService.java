package com.totalshakes.wstotalshakes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.txw2.IllegalAnnotationException;
import com.totalshakes.wstotalshakes.entity.Adicional;
import com.totalshakes.wstotalshakes.repository.AdicionalRepository;

@Service
public class AdicionalService {

	@Autowired
	private AdicionalRepository repository;

	@Autowired
	private IngredienteService clienteService;

	public void salvar(Adicional adicional) {

		if (adicional == null)
			throw new IllegalAnnotationException("Ingrediente inválido");

		repository.save(adicional);
	}

	public void deletar(Integer id) {

		Adicional adicional = repository.findById(id).get();
		if (adicional == null)
			throw new IllegalArgumentException("Elemento não presente no banco");

		repository.delete(adicional);
	}

	public void atualizar(Adicional adicional) {
		Adicional adicionalNew = repository.findById(adicional.getId()).get();
		if (adicional == null)
			throw new IllegalArgumentException("Elemento não presente no banco");

		adicionalNew.setId(adicional.getId());
		adicionalNew.setIngrediente(adicional.getIngrediente());
		repository.delete(adicional);
		repository.save(adicionalNew);
	}

}
