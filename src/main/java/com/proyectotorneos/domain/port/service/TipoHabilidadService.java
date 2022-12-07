package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.TipoHabilidad;

import java.util.List;

public interface TipoHabilidadService {
    void guarda(TipoHabilidad o);

    TipoHabilidad buscaPorID(Integer id);

    List<TipoHabilidad> buscaTodos();

    void elimina(TipoHabilidad o);

}
