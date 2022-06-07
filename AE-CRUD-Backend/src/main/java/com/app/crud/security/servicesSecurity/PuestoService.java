package com.app.crud.security.servicesSecurity;

import com.app.crud.security.enumsSecurity.PuestoNombre;
import com.app.crud.security.modelsSecurity.PuestoModel;
import com.app.crud.security.repositoriesSecurity.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PuestoService {

    @Autowired
    private PuestoRepository puestoRepository;

    public Optional<PuestoModel> getByPuestoNombre(PuestoNombre puestoNombre) {
        return puestoRepository.findByPuestoNombre(puestoNombre);
    }
}
