package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.exceptions.DomainExceptionPosicionJuego;
import com.proyectotorneos.domain.model.PosicionJuego;
import com.proyectotorneos.domain.port.repositories.PosicionJuegoRepository;
import com.proyectotorneos.domain.port.service.PosicionJuegoService;

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
