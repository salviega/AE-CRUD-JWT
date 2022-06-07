package com.app.crud.security.repositoriesSecurity;

import com.app.crud.security.enumsSecurity.PuestoNombre;
import com.app.crud.security.modelsSecurity.PuestoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PuestoRepository extends JpaRepository<PuestoModel, Integer> {

    Optional<PuestoModel> findByPuestoNombre(PuestoNombre puestoNombre);
}
