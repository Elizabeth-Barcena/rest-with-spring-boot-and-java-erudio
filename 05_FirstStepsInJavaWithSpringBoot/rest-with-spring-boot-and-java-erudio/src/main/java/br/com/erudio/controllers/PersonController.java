package br.com.erudio.controllers;

import java.util.List;

import br.com.erudio.data.vo.v2.PersonVoV2;
import br.com.erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.erudio.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.erudio.data.vo.v1.PersonVO;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;

	@GetMapping(produces = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_XML, Mediatype.APPLICATION_YAML})
	public List<PersonVO> findAll(){

		return service.findAll();
	}
	@GetMapping(value = "/{id}", produces = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_XML,Mediatype.APPLICATION_YAML})
	public PersonVO findById(@PathVariable(value = "id") Long id)throws Exception {
			return service.findById(id);
	}
	@PostMapping(consumes = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_YAML, Mediatype.APPLICATION_XML},
			produces = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_YAML, Mediatype.APPLICATION_XML})
	private PersonVO create(@RequestBody PersonVO person){
		return service.create(person);
	}
	@PostMapping(value = "/v2",consumes = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_YAML, Mediatype.APPLICATION_XML},
			produces = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_YAML, Mediatype.APPLICATION_XML})
	private PersonVoV2 createV2(@RequestBody PersonVoV2 person){

		return service.createV2(person);
	}
	@PutMapping(consumes = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_YAML, Mediatype.APPLICATION_XML},
			produces = {Mediatype.APPLICATION_JSON, Mediatype.APPLICATION_YAML, Mediatype.APPLICATION_XML})
	private PersonVO update(@RequestBody PersonVO person){
		return service.update(person);
	}
	@DeleteMapping(value = "/{id}")
	private  ResponseEntity<?> delete(@PathVariable(value = "id")Long id){
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}
}

