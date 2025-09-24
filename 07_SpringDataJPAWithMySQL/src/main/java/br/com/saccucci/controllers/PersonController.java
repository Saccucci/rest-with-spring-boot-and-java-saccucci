package br.com.saccucci.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return services.findAll();
    }

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET, // Declarando o Verbo
        produces = MediaType.APPLICATION_JSON_VALUE // Vai produzir JSON
    )
    public Person findById(@PathVariable("id") String id){
        return services.findById(id);
    }

    @RequestMapping(
        method = RequestMethod.POST, // Declarando o Verbo
        consumes = MediaType.APPLICATION_JSON_VALUE, // Vai consumir JSON
        produces = MediaType.APPLICATION_JSON_VALUE // Vai produzir JSON

    )
    public Person create(@RequestBody Person person){
        return services.create(person);
    }

    @RequestMapping(
        method = RequestMethod.PUT, // Declarando o Verbo
        consumes = MediaType.APPLICATION_JSON_VALUE, // Vai consumir JSON
        produces = MediaType.APPLICATION_JSON_VALUE // Vai produzir JSON

    )
    public Person update(@RequestBody Person person){
        return services.update(person);
    }

    @RequestMapping(value = "/{id}",
        method = RequestMethod.DELETE // Declarando o Verbo
    )
    public void delete(@PathVariable("id") String id){
        services.delete(id);
    }


}
