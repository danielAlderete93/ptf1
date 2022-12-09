package com.proyectotorneos.infra.entities.repositories;

import com.proyectotorneos.domain.model.ActuacionEquipo;

public interface ActuacionEquipoRepository {


    ActuacionEquipo getById(Integer id);

    void elimina(ActuacionEquipo o);
}
