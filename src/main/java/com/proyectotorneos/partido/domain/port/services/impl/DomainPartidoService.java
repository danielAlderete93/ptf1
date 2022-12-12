package com.proyectotorneos.partido.domain.port.services.impl;

import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.partido.domain.port.repositories.PartidoRepository;
import com.proyectotorneos.partido.domain.port.services.PartidoService;
import com.proyectotorneos.partido.domain.validators.ValidadorPartido;
import com.proyectotorneos.shared.domain.validators.Validador;
import com.proyectotorneos.partido.domain.validators.ValidadorFinalizaPartido;

import java.util.List;

public class DomainPartidoService implements PartidoService {
    private final PartidoRepository partidoRepository;
    private final Validador<Partido> partidoValidador;

    private final Validador<Partido> partidoValidadorFinalizaPartido;

    public DomainPartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
        this.partidoValidador = new ValidadorPartido();
        partidoValidadorFinalizaPartido = new ValidadorFinalizaPartido();
    }

    @Override
    public void guarda(Partido partido) {
        partidoValidador.valida(partido);
        partidoRepository.alta(partido);
    }

    @Override
    public Partido buscaPorID(Integer id) {
        return partidoRepository.getById(id);
    }

    @Override
    public List<Partido> buscaTodos() {
        return partidoRepository.getAll();
    }

    @Override
    public void elimina(Partido o) {

    }

    @Override
    public void finaliza(Partido partido) {
        partidoValidadorFinalizaPartido.valida(partido);
        partido.finaliza();
        partidoRepository.alta(partido);
    }

}
