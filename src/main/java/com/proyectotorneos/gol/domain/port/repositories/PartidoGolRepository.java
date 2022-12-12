package com.proyectotorneos.gol.domain.port.repositories;

import com.proyectotorneos.gol.domain.model.PartidoGol;

import java.util.List;

public interface PartidoGolRepository {
    void alta(PartidoGol o);

    PartidoGol getById(Integer id);

    List<PartidoGol> getAll();

    void elimina(PartidoGol o);
}
