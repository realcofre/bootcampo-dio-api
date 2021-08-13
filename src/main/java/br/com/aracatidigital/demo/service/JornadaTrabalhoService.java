package br.com.aracatidigital.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aracatidigital.demo.model.JornadaTrabalho;
import br.com.aracatidigital.demo.repository.JornadaTrabalhoRepository;

@Service
public class JornadaTrabalhoService {
	
	@Autowired
	JornadaTrabalhoRepository repository;
	
	public JornadaTrabalho save(JornadaTrabalho entity) {
		return repository.save(entity);
	}

	public List<JornadaTrabalho> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public JornadaTrabalho getById(Long id) {
		Optional<JornadaTrabalho> obj = repository.findById(id);
		JornadaTrabalho entity = obj.orElseThrow(() -> new NoSuchElementException("Entity not found"));
		return entity;
	}

	public JornadaTrabalho updateJornada(Long id, JornadaTrabalho dto) {
		JornadaTrabalho entity = repository.getById(id);
		entity.setDescricao(dto.getDescricao());
		return repository.save(entity);
	}

	public void deleteJornada(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchElementException("Id not fount " + id);
		} catch (DataIntegrityViolationException e) {
			throw new PersistenceException("Integrity violation");
		}

	}

}
