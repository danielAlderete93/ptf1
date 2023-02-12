package com.proyectotorneos.publicacion.domain.port.repositories;

import com.proyectotorneos.publicacion.domain.model.Publicacion;
import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;

import java.util.List;

public interface PublicacionRespository {
    void alta(Publicacion o);

    Publicacion getById(Integer id);

    List<Publicacion> getAll();

    void elimina(Publicacion o);
}
