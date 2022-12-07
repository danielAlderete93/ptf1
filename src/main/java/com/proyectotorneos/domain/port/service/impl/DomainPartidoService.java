package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.port.repositories.PartidoRepository;
import com.proyectotorneos.domain.port.service.PartidoService;
import com.proyectotorneos.domain.validators.ValidadorPartido;
import com.proyectotorneos.domain.validators.Validador;
import com.proyectotorneos.domain.validators.ValidadorFinalizaPartido;

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
