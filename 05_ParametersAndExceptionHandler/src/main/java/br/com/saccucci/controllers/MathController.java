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

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(  @PathVariable("numberOne") String numberOne,
                        @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(  @PathVariable("numberOne") String numberOne,
                        @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(  @PathVariable("numberOne") String numberOne,
                        @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(  @PathVariable("numberOne") String numberOne,
                        @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2.0;
    }

     // http://localhost:8080/math/potency/3/5
    @RequestMapping("/potency/{numberOne}/{numberTwo}")
    public Double potency(  @PathVariable("numberOne") String numberOne,
                        @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.pow(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/rooting/3/5
    @RequestMapping("/rooting/{numberOne}/{numberTwo}")
    public Double rooting(  @PathVariable("numberOne") String numberOne,
                        @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.pow(convertToDouble(numberOne), 1.0 / convertToDouble(numberTwo));
    }

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
