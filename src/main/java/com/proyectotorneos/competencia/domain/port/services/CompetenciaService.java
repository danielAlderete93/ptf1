package com.proyectotorneos.competencia.domain.port.services;

import java.util.List;

public interface CompetenciaService<T> {

    void guarda(T competencia);

    T buscaPorID(Integer id);

    List<T> buscaTodas();


}
