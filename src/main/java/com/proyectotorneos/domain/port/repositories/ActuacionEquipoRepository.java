package com.proyectotorneos.domain.port.repositories;

import com.proyectotorneos.domain.model.ActuacionEquipo;

public interface ActuacionEquipoRepository {


    ActuacionEquipo getById(Integer id);

    void elimina(ActuacionEquipo o);
}
