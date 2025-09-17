package br.com.saccucci.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saccucci.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math") // Todos os métodos desta classe deverão começar com /math
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(  @PathVariable("numberOne") String numberOne,
                        @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    // http://localhost:8080/subtraction/sum/3/5
    // http://localhost:8080/math/division/3/5

    public static Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
		if (strNumber == null) throw new UnsupportedMathOperationException("Please set a numeric value!");; 
		String number = strNumber.replaceAll(",", ".");// Moeda Americana x Brasileira
		return Double.parseDouble(number);
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false; 
		String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
