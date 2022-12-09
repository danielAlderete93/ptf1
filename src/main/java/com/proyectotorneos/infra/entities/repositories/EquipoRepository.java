package com.proyectotorneos.infra.entities.repositories;

import com.proyectotorneos.domain.model.Equipo;

import java.util.List;

public interface EquipoRepository {

    void alta(Equipo equipo);

    Equipo getById(Integer id);

    List<Equipo> getAll();

    void elimina(Equipo o);

}
