package br.com.saccucci.repository;

import br.com.saccucci.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {} // Com isso teremos acesso as funções do SpringData
