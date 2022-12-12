package com.proyectotorneos.actuacion.domain.port.repositories;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;

public interface ActuacionEquipoRepository {


    ActuacionEquipo getById(Integer id);

    void elimina(ActuacionEquipo o);
}
