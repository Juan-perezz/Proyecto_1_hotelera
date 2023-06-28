
package com.emergentes.dao;

import com.emergentes.modelo.Habitacion;
import java.util.List;

public interface HabitacionDAO {
    public void insert(Habitacion habitacion) throws Exception;
    public void update(Habitacion habitacion) throws Exception;
    public void delete(int id_habitacion) throws Exception;
    public Habitacion getById(int id_habitacion) throws Exception;
    public List<Habitacion> getAll() throws Exception;
}
