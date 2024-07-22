package Modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cliente")
public class Cliente extends Usuario {
    private String direccion;
    private String numeroTelefono;

    public Cliente(){

    }

    public Cliente(Long id, String nombre, String email, String direccion, String numeroTelefono) {
        super(id, nombre, email);
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}