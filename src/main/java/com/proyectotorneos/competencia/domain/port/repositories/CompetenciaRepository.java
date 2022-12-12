package com.proyectotorneos.competencia.domain.port.repositories;

import com.proyectotorneos.competencia.domain.model.Competencia;

import java.util.List;

public interface CompetenciaRepository<T extends Competencia> {
    void alta(T competencia);

    T buscaPorID(Integer id);


    List<T> getAll();

    void elimina(T o);

}
