package com.proyectotorneos.gol.domain.port.services;

import com.proyectotorneos.gol.domain.model.PartidoGol;

public interface PartidoGolService {

    PartidoGol buscaPorID(Integer id);

    void elimina(PartidoGol o);
}
