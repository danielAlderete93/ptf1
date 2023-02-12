package com.proyectotorneos.torneo.domain.model;

import com.proyectotorneos.competencia.domain.model.Competencia;
import com.proyectotorneos.publicacion.domain.model.Publicacion;
import com.proyectotorneos.shared.domain.model.Identificable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Torneo extends Identificable {
    private String nombre;
    private String descripcion;
    /*TODO: UsuarioAsignados*/
    private Competencia competencia;
    private List<Publicacion> publicaciones;

    public void agregaPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }
}
