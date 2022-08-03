package com.totalshakes.wstotalshakes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.totalshakes.wstotalshakes.entity.Ingrediente;
import com.totalshakes.wstotalshakes.service.IngredienteService;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Ingrediente> salvar(@RequestBody Ingrediente ingrediente) {

		try {

			service.salvar(ingrediente);
			return new ResponseEntity<Ingrediente>(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Ingrediente>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Ingrediente> atualizar(@RequestBody Ingrediente ingrediente) {

		try {

			service.atualizar(ingrediente);
			return new ResponseEntity<Ingrediente>(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Ingrediente>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Ingrediente> deletar(@PathVariable(value = "id", required = true) Integer id) {
		try {
			service.deletar(id);
			return new ResponseEntity<Ingrediente>(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Ingrediente>(HttpStatus.BAD_REQUEST);
		}

	}

}
