package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.ActuacionEquipo;

public interface ActuacionEquipoService {
    ActuacionEquipo buscaPorID(Integer id);

    void elimina(ActuacionEquipo o);

}
