package br.com.aracatidigital.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aracatidigital.demo.model.JornadaTrabalho;
import br.com.aracatidigital.demo.service.JornadaTrabalhoService;


@RestController
@RequestMapping("/jornadas")
public class JornadaTrabalhoController {

	@Autowired
	JornadaTrabalhoService service;

	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho entity) {
		return service.save(entity);
	}

	@GetMapping
	public List<JornadaTrabalho> getJornadaList() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("id") Long id) throws Exception {
		JornadaTrabalho obj = service.getById(id);
		return ResponseEntity.ok().body(obj);

	}

	@PutMapping("/{id}")
	public JornadaTrabalho updateJornada(@PathVariable("id") Long id, @RequestBody JornadaTrabalho dto) {
		return service.updateJornada(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<JornadaTrabalho> deleteByID(@PathVariable("id") Long id) throws Exception {

		service.deleteJornada(id);

		return ResponseEntity.noContent().build();

	}

}
