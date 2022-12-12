package com.proyectotorneos.tipo_habilidad.domain.port.services;

import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;

import java.util.List;

public interface TipoHabilidadService {
    void guarda(TipoHabilidad o);

    TipoHabilidad buscaPorID(Integer id);

    List<TipoHabilidad> buscaTodos();

    void elimina(TipoHabilidad o);

}
