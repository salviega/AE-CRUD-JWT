package com.app.crud.security.modelsSecurity;

import com.app.crud.security.enumsSecurity.PuestoNombre;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class PuestoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public PuestoModel() {
    }

    @NonNull
    @Enumerated(EnumType.STRING)
    private PuestoNombre puestoNombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public PuestoNombre getPuestoNombre() {
        return puestoNombre;
    }

    public void setPuestoNombre(@NonNull PuestoNombre puestoNombre) {
        this.puestoNombre = puestoNombre;
    }

    public PuestoModel(@NonNull PuestoNombre puestoNombre) {
        this.puestoNombre = puestoNombre;
    }
}
