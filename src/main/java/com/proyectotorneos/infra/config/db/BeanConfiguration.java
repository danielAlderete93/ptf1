package com.proyectotorneos.infra.config.db;

import com.proyectotorneos.domain.port.service.*;
import com.proyectotorneos.domain.port.service.impl.*;
import com.proyectotorneos.infra.entities.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    TipoHabilidadService tipoHabilidadService(TipoHabilidadRepository tipoHabilidadRepository) {
        return new DomainTipoHabilidadService(tipoHabilidadRepository);
    }

    @Bean
    HabilidadJugadorService habilidadJugadorService(HabilidadJugadorRepository habilidadJugadorRepository) {
        return new DomainHabilidadJugadorService(habilidadJugadorRepository);
    }

    @Bean
    PosicionJuegoService posicionJuegoService(PosicionJuegoRepository posicionJuegoRepository) {
        return new DomainPosicionJuegoService(posicionJuegoRepository);
    }

    @Bean
    JugadorService jugadorService(JugadorRepository jugadorRepository) {
        return new DomainJugadorService(jugadorRepository);
    }

    @Bean
    EquipoService equipoService(EquipoRepository equipoRepository) {
        return new DomainEquipoService(equipoRepository);
    }

    @Bean
    PartidoService partidoService(PartidoRepository partidoRepository) {
        return new DomainPartidoService(partidoRepository);
    }

    @Bean
    ActuacionEquipoService actuacionEquipoService(ActuacionEquipoRepository repository) {
        return new DomainActuacionEquipoService(repository);
    }

    @Bean
    PartidoGolService partidoGolService(PartidoGolRepository repository) {
        return new DomainPartidoGolService(repository);
    }

    @Bean
    FechaCompetitivaService fechaCompetitivaService(FechaCompetitivaRepository repository) {
        return new DomainFechaCompetitivaService(repository);
    }


}
