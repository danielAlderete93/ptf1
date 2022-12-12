package com.proyectotorneos.actuacion.domain.port.services;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;

public interface ActuacionEquipoService {
    ActuacionEquipo buscaPorID(Integer id);

    void elimina(ActuacionEquipo o);

}
