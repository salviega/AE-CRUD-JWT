package com.app.crud.controllers;

import com.app.crud.models.RolModel;
import com.app.crud.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping()
    public List<RolModel> getAllRol() {
        return rolService.getAllRol();
    }
    @GetMapping(path = "/{id}")
    public Optional<RolModel> getRol(@PathVariable("id") Long id) {
        return rolService.getRol(id);
    }
    @PostMapping()
    public RolModel createRol(@RequestBody RolModel rolModel) {
        return rolService.createRol(rolModel);
    }
    @PutMapping(path = "/{id}")
    public RolModel updateRol(@PathVariable(value = "id") Long id, @RequestBody RolModel rolModel) {
        Optional<RolModel> findedRol = rolService.getRol(id);
        findedRol.get().setRolName(rolModel.getRolName());
        findedRol.get().setDescription(rolModel.getDescription());
        final RolModel updatedRol = rolService.updateRol(findedRol.get());
        return updatedRol;
    }
    @DeleteMapping(path = "/{id}")
    public String deleteRol(@PathVariable Long id) {
        boolean ok = rolService.deleteRol(id);
        if (ok == true) {
            return "El rol fue eliminado";
        } else {
            return "No se encontro rol";
        }
    }
    @DeleteMapping
    public String deleteAllRol() {
        rolService.deleteAllRol();
        return "Todos los roles fueron eliminados";
    }
}
