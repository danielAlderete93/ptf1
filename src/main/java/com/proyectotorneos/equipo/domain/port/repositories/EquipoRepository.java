package com.proyectotorneos.equipo.domain.port.repositories;

import com.proyectotorneos.equipo.domain.model.Equipo;

import java.util.List;

public interface EquipoRepository {

    void alta(Equipo equipo);

    Equipo getById(Integer id);

    List<Equipo> getAll();

    void elimina(Equipo o);

}
