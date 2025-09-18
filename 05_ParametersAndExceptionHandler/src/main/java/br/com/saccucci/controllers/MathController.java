package br.com.saccucci.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saccucci.exception.UnsupportedMathOperationException;
import br.com.saccucci.model.SimpleMath;

@RestController
@RequestMapping("/math") // Todos os métodos desta classe deverão começar com /math
public class MathController {

    // http://localhost:8080/math/sum/3/5
    // http://localhost:8080/math/subtraction/3/5
    // http://localhost:8080/math/multiplication/3/5
    // http://localhost:8080/math/division/3/5
    // http://localhost:8080/math/mean/3/5
    // http://localhost:8080/math/potency/3/5
    // http://localhost:8080/math/rooting/3/5
    
    @RequestMapping("/{operation}/{numberOne}/{numberTwo}")
    public Double operation(
        @PathVariable("operation") String operation,
        @PathVariable("numberOne") String numberOne,
        @PathVariable("numberTwo") String numberTwo) 
    throws Exception {
        return SimpleMath.math(operation, numberOne, numberTwo);
    }

}
