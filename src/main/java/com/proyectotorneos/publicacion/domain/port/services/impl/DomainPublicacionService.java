package com.proyectotorneos.publicacion.domain.port.services.impl;

import com.proyectotorneos.publicacion.domain.model.Publicacion;
import com.proyectotorneos.publicacion.domain.port.repositories.PublicacionRespository;
import com.proyectotorneos.publicacion.domain.port.services.PublicacionService;

import java.util.List;


public class DomainPublicacionService implements PublicacionService {

    private final PublicacionRespository publicacionRespository;

    public DomainPublicacionService(PublicacionRespository publicacionRespository) {
        this.publicacionRespository = publicacionRespository;
    }

    @Override
    public void guarda(Publicacion o) {
        publicacionRespository.alta(o);
    }

    @Override
    public Publicacion buscaPorID(Integer id) {
        return publicacionRespository.getById(id);
    }

    @Override
    public List<Publicacion> buscaTodos() {
        return publicacionRespository.getAll();
    }

    @Override
    public void elimina(Publicacion o) {
        publicacionRespository.elimina(o);
    }
}
