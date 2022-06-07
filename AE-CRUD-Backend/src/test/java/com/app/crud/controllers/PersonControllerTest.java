package com.app.crud.controllers;

import com.app.crud.services.RolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonControllerTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private RolService rolService;

    @Test
    public void testCreatePerson() {
        Long rolId = 1L;
        Optional<PersonModel> addedPerson = rolService.getRol(rolId).map(rol -> {
            PersonModel person = new PersonModel();
            person.setPhone("3197499064");
            person.setName("Santiago");
            person.setLastName("Viana");
            person.setRol(rol);
            return person;
        });
        assertNotNull(addedPerson.get());
    }
    @Test
    public void testUpdatePerson() {
        Long personId = 1L;
        Optional<PersonModel> findedPerson = personService.getPerson(personId);
        findedPerson.get().setName("Fernando");
        findedPerson.get().setLastName("Viana");
        findedPerson.get().setPhone("6243319");
        assertNotNull(findedPerson.get());
    }


}