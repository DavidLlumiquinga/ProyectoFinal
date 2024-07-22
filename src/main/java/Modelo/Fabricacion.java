package Modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Fabricacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Producto producto;
    private LocalDateTime fechaFabricacion;
    private boolean fabricado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDateTime getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDateTime fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public boolean isFabricado() {
        return fabricado;
    }

    public void setFabricado(boolean fabricado) {
        this.fabricado = fabricado;
    }
}