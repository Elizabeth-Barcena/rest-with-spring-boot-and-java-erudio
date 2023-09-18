package br.com.erudio.math;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.erudio.Exceptions.UnsupportedMathOperationException;
import br.com.erudio.converters.NumberConverter;

public class SimpleMath {
	private final AtomicLong counter = new AtomicLong();
	

	public Double sum(Double numberOne, Double numberTwo) {
		
		return numberOne + numberTwo;
	}
	
	public Double subtraction(Double numberOne,Double numberTwo
			) {
		return numberOne - numberTwo;
	}

	public Double multiplication( Double numberOne, Double numberTwo
			) {
		return numberOne * numberTwo;
	}

	public Double division(Double numberOne,Double numberTwo){
		return numberOne / numberTwo;
	}

	public Double mean(Double numberOne,Double numberTwo
			) {
		return (numberOne + numberTwo)/2;
	}
	
	public Double squareRoot(Double number
			){
	
		return Math.sqrt(number);
	}
	

}
