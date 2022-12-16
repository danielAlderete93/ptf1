package com.proyectotorneos.tabla.app;

import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;
import com.proyectotorneos.tabla.app.mapper.TablaPosicionesMapper;
import com.proyectotorneos.tabla.app.response.TablaPosicionResponse;
import com.proyectotorneos.tabla.domain.model.EntradaTablaPosicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia/")
public class ControllerTablaPosicion {

    private final CompetenciaService<CompetenciaLiga> competenciaLigaService;
    private final CompetenciaService<CompetenciaGrupo> competenciaGrupoService;
    private final TablaPosicionesMapper mapper;

    @Autowired
    public ControllerTablaPosicion(CompetenciaService<CompetenciaLiga> competenciaLigaService, CompetenciaService<CompetenciaGrupo> competenciaGrupoService, TablaPosicionesMapper mapper) {
        this.competenciaLigaService = competenciaLigaService;
        this.competenciaGrupoService = competenciaGrupoService;
        this.mapper = mapper;
    }

    @GetMapping(value = "liga/{id}/tabla", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TablaPosicionResponse> getOneTabla(@PathVariable Integer id) {
        CompetenciaLiga competenciaLiga;
        List<EntradaTablaPosicion> tablaPosiciones;
        TablaPosicionResponse response;

        competenciaLiga = competenciaLigaService.buscaPorID(id);
        tablaPosiciones = competenciaLiga.getTabla();
        response = mapper.toResponse(tablaPosiciones, competenciaLiga.getNombre(), competenciaLiga.getId());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "grupo/{id}/tabla", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<TablaPosicionResponse>> getAllTabla(@PathVariable Integer id) {
        CompetenciaGrupo competenciaLiga;
        List<TablaPosicionResponse> response;

        competenciaLiga = competenciaGrupoService.buscaPorID(id);
        response = competenciaLiga.getGrupos()
                .stream()
                .map(c -> mapper.toResponse(c.getTabla(), c.getNombre(), c.getId()))
                .toList();

        return ResponseEntity.ok(response);

    }
}
