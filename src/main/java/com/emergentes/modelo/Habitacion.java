
package com.emergentes.modelo;

public class Habitacion {
    private int id_habitacion;
    private int numero_habitacion;
    private String descripcion;
    private int max_ocupantes;
    private Float precio;

    public Habitacion() {
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public int getMax_ocupantes() {
        return max_ocupantes;
    }

    public void setMax_ocupantes(int max_ocupantes) {
        this.max_ocupantes = max_ocupantes;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id_habitacion=" + id_habitacion + ", numero_habitacion=" + numero_habitacion + ", descripcion=" + descripcion + ", max_ocupantes=" + max_ocupantes + ", precio=" + precio + '}';
    }

    
    
    
}
