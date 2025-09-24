package br.com.saccucci.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saccucci.model.Person;
import br.com.saccucci.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    // Injeção de dependência
    @Autowired 
    private PersonServices services; 

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET, // Declarando o Verbo
        produces = MediaType.APPLICATION_JSON_VALUE // Declarando o que será aceito
    )
    public Person findById(@PathVariable("id") String id){
        return services.findById(id);
    }


}
