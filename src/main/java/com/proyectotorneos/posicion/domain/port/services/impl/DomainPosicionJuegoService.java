package com.proyectotorneos.posicion.domain.port.services.impl;

import com.proyectotorneos.posicion.domain.exceptions.DomainExceptionPosicionJuego;
import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import com.proyectotorneos.posicion.domain.port.repositories.PosicionJuegoRepository;
import com.proyectotorneos.posicion.domain.port.services.PosicionJuegoService;

import java.util.List;


public class DomainPosicionJuegoService implements PosicionJuegoService {

    private final PosicionJuegoRepository posicionJuegoRepository;

    public DomainPosicionJuegoService(PosicionJuegoRepository posicionJuegoRepository) {
        this.posicionJuegoRepository = posicionJuegoRepository;
    }

    @Override
    public void guarda(PosicionJuego o) {
        if (null != posicionJuegoRepository.getByName(o.getNombre())) {
            throw new DomainExceptionPosicionJuego("Ya existe una posicion de juego con ese nombre");
        }
        posicionJuegoRepository.alta(o);

    }

    @Override
    public PosicionJuego buscaPorID(Integer id) {
        return posicionJuegoRepository.getById(id);
    }

    @Override
    public List<PosicionJuego> buscaTodos() {
        return posicionJuegoRepository.getAll();
    }


    @Override
    public void elimina(PosicionJuego o) {
        posicionJuegoRepository.elimina(o);
    }
}
