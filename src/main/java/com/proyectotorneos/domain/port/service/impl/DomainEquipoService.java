package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.infra.entities.repositories.EquipoRepository;
import com.proyectotorneos.domain.port.service.EquipoService;
import com.proyectotorneos.domain.validators.Validador;
import com.proyectotorneos.domain.validators.ValidadorEquipo;
import com.proyectotorneos.domain.validators.ValidadorJugador;

import java.util.List;

public class DomainEquipoService implements EquipoService {

    private final EquipoRepository equipoRepository;
    private final Validador<Jugador> jugadorValidador;
    private final Validador<Equipo> equipoValidador;


    public DomainEquipoService(EquipoRepository equipoRepository) {

        this.equipoRepository = equipoRepository;
        this.jugadorValidador = new ValidadorJugador();

        equipoValidador = new ValidadorEquipo();
    }

    @Override
    public void guarda(Equipo o) {
        this.equipoRepository.alta(o);
    }

    @Override
    public Equipo buscaPorID(Integer id) {
        return this.equipoRepository.getById(id);
    }

    @Override
    public List<Equipo> getAll() {
        return this.equipoRepository.getAll();
    }


    @Override
    public void elimina(Equipo o) {

    }

    @Override
    public void agregaJugador(Equipo equipo, Jugador jugador) {

        jugadorValidador.valida(jugador);
        equipoValidador.valida(equipo);

        equipo.addJugador(jugador);
        this.equipoRepository.alta(equipo);


    }


}
