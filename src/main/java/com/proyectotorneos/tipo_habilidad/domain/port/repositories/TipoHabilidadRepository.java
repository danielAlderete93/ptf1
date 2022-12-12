package com.proyectotorneos.tipo_habilidad.domain.port.repositories;

import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;

import java.util.List;


public interface TipoHabilidadRepository {
    void alta(TipoHabilidad o);

    TipoHabilidad getById(Integer id);

    TipoHabilidad getByName(String name);

    List<TipoHabilidad> getAll();

    void elimina(TipoHabilidad o);

}
