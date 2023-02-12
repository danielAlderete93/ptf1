package com.proyectotorneos.publicacion.domain.port.services;

import com.proyectotorneos.publicacion.domain.model.Publicacion;
import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;

import java.util.List;

public interface PublicacionService {
    void guarda(Publicacion o);

    Publicacion buscaPorID(Integer id);

    List<Publicacion> buscaTodos();

    void elimina(Publicacion o);
}
