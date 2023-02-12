package com.proyectotorneos.shared.infra.config.db;

import com.proyectotorneos.actuacion.domain.port.repositories.ActuacionEquipoRepository;
import com.proyectotorneos.actuacion.domain.port.services.ActuacionEquipoService;
import com.proyectotorneos.actuacion.domain.port.services.impl.DomainActuacionEquipoService;
import com.proyectotorneos.competencia.domain.model.CompetenciaFaseEliminatoria;
import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.domain.port.repositories.CompetenciaRepository;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;
import com.proyectotorneos.competencia.domain.port.services.impl.DomainCompetenciaFaseEliminatoria;
import com.proyectotorneos.competencia.domain.port.services.impl.DomainCompetenciaGrupoService;
import com.proyectotorneos.competencia.domain.port.services.impl.DomainCompetenciaLigaService;
import com.proyectotorneos.equipo.domain.port.repositories.EquipoRepository;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import com.proyectotorneos.equipo.domain.port.service.impl.DomainEquipoService;
import com.proyectotorneos.fecha.domain.port.repositories.FechaCompetitivaRepository;
import com.proyectotorneos.fecha.domain.port.services.FechaCompetitivaService;
import com.proyectotorneos.fecha.domain.port.services.impl.DomainFechaCompetitivaService;
import com.proyectotorneos.gol.domain.port.repositories.PartidoGolRepository;
import com.proyectotorneos.gol.domain.port.services.PartidoGolService;
import com.proyectotorneos.gol.domain.port.services.impl.DomainPartidoGolService;
import com.proyectotorneos.habilidad.domain.port.repositories.HabilidadJugadorRepository;
import com.proyectotorneos.habilidad.domain.port.services.HabilidadJugadorService;
import com.proyectotorneos.habilidad.domain.port.services.impl.DomainHabilidadJugadorService;
import com.proyectotorneos.jugador.domain.port.repositories.JugadorRepository;
import com.proyectotorneos.jugador.domain.port.services.JugadorService;
import com.proyectotorneos.jugador.domain.port.services.impl.DomainJugadorService;
import com.proyectotorneos.partido.domain.port.repositories.PartidoRepository;
import com.proyectotorneos.partido.domain.port.services.PartidoService;
import com.proyectotorneos.partido.domain.port.services.impl.DomainPartidoService;
import com.proyectotorneos.posicion.domain.port.repositories.PosicionJuegoRepository;
import com.proyectotorneos.posicion.domain.port.services.PosicionJuegoService;
import com.proyectotorneos.posicion.domain.port.services.impl.DomainPosicionJuegoService;
import com.proyectotorneos.publicacion.domain.port.repositories.PublicacionRespository;
import com.proyectotorneos.publicacion.domain.port.services.PublicacionService;
import com.proyectotorneos.publicacion.domain.port.services.impl.DomainPublicacionService;
import com.proyectotorneos.tipo_habilidad.domain.port.repositories.TipoHabilidadRepository;
import com.proyectotorneos.tipo_habilidad.domain.port.services.TipoHabilidadService;
import com.proyectotorneos.tipo_habilidad.domain.port.services.impl.DomainTipoHabilidadService;
import com.proyectotorneos.torneo.domain.port.repositories.TorneoRepository;
import com.proyectotorneos.torneo.domain.port.service.TorneoService;
import com.proyectotorneos.torneo.domain.port.service.impl.DomainTorneoService;
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

    @Bean
    CompetenciaService<CompetenciaLiga> competenciaLigaService(CompetenciaRepository<CompetenciaLiga> repository) {
        return new DomainCompetenciaLigaService(repository);
    }

    @Bean
    CompetenciaService<CompetenciaGrupo> competenciaGrupoService(CompetenciaRepository<CompetenciaGrupo> repository) {
        return new DomainCompetenciaGrupoService(repository);
    }

    @Bean
    CompetenciaService<CompetenciaFaseEliminatoria> competenciaFaseEliminatoriaService(CompetenciaRepository<CompetenciaFaseEliminatoria> repository) {
        return new DomainCompetenciaFaseEliminatoria(repository);
    }

    @Bean
    PublicacionService publicacionPublicacionService(PublicacionRespository repository) {
        return new DomainPublicacionService(repository);
    }

    @Bean
    TorneoService torneoService(TorneoRepository repository) {
        return new DomainTorneoService(repository);
    }

}
