package com.totalshakes.wstotalshakes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.totalshakes.wstotalshakes.entity.Adicional;
import com.totalshakes.wstotalshakes.entity.Ingrediente;
import com.totalshakes.wstotalshakes.service.AdicionalService;

@Controller
@RequestMapping("/adicional")
public class AdicionalController {

	@Autowired
	private AdicionalService service;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Adicional> salvar(@RequestBody Adicional adicional) {

		try {

			service.salvar(adicional);
			return new ResponseEntity<Adicional>(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Adicional>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Adicional> deletar(@PathVariable(value = "id", required = true) Integer id) {
		try {
			service.deletar(id);
			return new ResponseEntity<Adicional>(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Adicional>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Adicional> atualizar(@RequestBody Adicional adicional) {

		try {

			service.atualizar(adicional);
			return new ResponseEntity<Adicional>(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Adicional>(HttpStatus.BAD_REQUEST);
		}

	}
}
