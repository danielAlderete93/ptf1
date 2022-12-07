package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.PartidoGol;

public interface PartidoGolService {

    PartidoGol BuscaPorID(Integer id);

    void elimina(PartidoGol o);
}
