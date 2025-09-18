package br.com.saccucci.model;

import br.com.saccucci.exception.UnsupportedMathOperationException;

public class SimpleMath {
    public static Double math(String operation, String numberOne, String numberTwo) throws Exception {
        if(operation == null || operation.isEmpty()) throw new UnsupportedMathOperationException("Define a valid operation!");
        if(!Checker.isNumeric(numberOne) || !Checker.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        switch (operation) {
            case "sum":
                return Checker.convertToDouble(numberOne) + Checker.convertToDouble(numberTwo);
            case "subtraction":
                return Checker.convertToDouble(numberOne) - Checker.convertToDouble(numberTwo);
            case "multiplication":
                return Checker.convertToDouble(numberOne) * Checker.convertToDouble(numberTwo);
            case "division":
                return Checker.convertToDouble(numberOne) / Checker.convertToDouble(numberTwo);
            case "mean":
                return (Checker.convertToDouble(numberOne) + Checker.convertToDouble(numberTwo)) / 2.0;
            case "potency":
                return Math.pow(Checker.convertToDouble(numberOne), Checker.convertToDouble(numberTwo));
            case "rooting":
                return Math.pow(Checker.convertToDouble(numberOne), 1.0 / Checker.convertToDouble(numberTwo));
            default:
                throw new UnsupportedMathOperationException("Unknown operation!");
        }
    }
}
