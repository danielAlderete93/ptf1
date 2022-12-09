package com.proyectotorneos.infra.entities.repositories;

import com.proyectotorneos.domain.model.TipoHabilidad;

import java.util.List;


public interface TipoHabilidadRepository {
    void alta(TipoHabilidad o);

    TipoHabilidad getById(Integer id);

    TipoHabilidad getByName(String name);

    List<TipoHabilidad> getAll();

    void elimina(TipoHabilidad o);

}
