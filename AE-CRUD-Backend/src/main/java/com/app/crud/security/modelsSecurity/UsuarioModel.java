package com.app.crud.security.modelsSecurity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany
    @JoinTable(name = "usuario_puesto", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "puesto_id"))
     private Set<PuestoModel> puestos = new HashSet<>();

    public UsuarioModel(String nombre, String nombreUsuario, String email, String password) {
        this.setNombre(nombre);
        this.setNombreUsuario(nombreUsuario);
        this.setEmail(email);
        this.setPassword(password);
    }

    public UsuarioModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PuestoModel> getPuestos() {
        return puestos;
    }

    public void setPuestos(Set<PuestoModel> puestos) {
        this.puestos = puestos;
    }
}
