
package com.emergentes.modelo;

import java.sql.Date;

public class Reserva {
    private int id_reserva;
    private int id_cliente;
    private int id_habitacion;
    private int cantidad;
    private Date fecha_entrada;
    private Date fecha_salida;
    private String cliente;
    private String habitacion;

    public Reserva() {
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id_reserva=" + id_reserva + ", id_cliente=" + id_cliente + ", id_habitacion=" + id_habitacion + ", cantidad=" + cantidad + ", fecha_entrada=" + fecha_entrada + ", fecha_salida=" + fecha_salida + ", cliente=" + cliente + ", habitacion=" + habitacion + '}';
    }
    
    
    
}
