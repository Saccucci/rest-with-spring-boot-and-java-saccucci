package br.com.saccucci.model;

import br.com.saccucci.exception.UnsupportedMathOperationException;

public class Checker {

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
