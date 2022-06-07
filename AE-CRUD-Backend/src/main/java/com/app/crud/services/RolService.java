package com.app.crud.services;


import com.app.crud.models.RolModel;
import com.app.crud.repositories.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private IRolRepository rolRepository;

    public List<RolModel> getAllRol() {
        return rolRepository.findAll();
    }
    public Optional<RolModel> getRol(Long id) {
        return rolRepository.findById(id);
    }
    public RolModel createRol(RolModel rolModel) {
        return rolRepository.save(rolModel);
    }
    public RolModel updateRol(RolModel rolModel) {
        return rolRepository.save(rolModel);
    }
    public boolean deleteRol(Long id) {
        try {
            rolRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void deleteAllRol() {
        rolRepository.deleteAll();
    }
}
