package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.Partido;

import java.util.List;

public interface PartidoService {
    void guarda(Partido o);

    Partido buscaPorID(Integer id);

    List<Partido> buscaTodos();

    void elimina(Partido o);

    void finaliza(Partido partido);

}
