package br.com.erudio.Controllers;


import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.exceptions.*;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){

		return service.findAll();
	}
	@RequestMapping(value= "/{id}",
			method=RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id)throws Exception {
		
			return service.findById(id);
	}
	@RequestMapping(value= "/sub/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
			if(!NumberConverter.isNumeric(numberOne)| !NumberConverter.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	private  Person create(@RequestBody Person person){
		return service.create(person);

	}
	@RequestMapping(value= "/mult/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
			if(!NumberConverter.isNumeric(numberOne)| !NumberConverter.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	@RequestMapping(value= "/div/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
			if(!NumberConverter.isNumeric(numberOne)| !NumberConverter.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		return math.division(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value= "/mean/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
			if(!NumberConverter.isNumeric(numberOne)| !NumberConverter.isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	@RequestMapping(value= "/squareRoot/{number}",
			method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "number") String number
			)throws Exception {
		
			if(!NumberConverter.isNumeric(number)) {
				throw new UnsupportedMathOperationException("Please set a numeric value!");
			
		}
		return math.squareRoot(NumberConverter.convertToDouble(number));
	}
	
}

