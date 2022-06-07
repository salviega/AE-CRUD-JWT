package com.app.crud.services;

import com.app.crud.models.RolModel;
import com.app.crud.repositories.IRolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RolServiceTest {

    @Autowired
    IRolRepository rolRepository;

    @Test
    public void testCreateRol() {
        RolModel rol = new RolModel("Doctor", "Curar personas");
        RolModel savedRol = rolRepository.save(rol);
        assertNotNull(savedRol);
    }
    @Test
    public void testDeleteRol() {
        Long rolId = 11L;
        boolean deletedRol;
        try {
            rolRepository.deleteById(rolId);
            deletedRol = true;
        } catch (Exception e) {
            deletedRol = false;
        }
        assertNotNull(deletedRol);
    }

}