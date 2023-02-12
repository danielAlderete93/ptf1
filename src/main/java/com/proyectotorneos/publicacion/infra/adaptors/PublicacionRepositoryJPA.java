package com.proyectotorneos.publicacion.infra.adaptors;

import com.proyectotorneos.publicacion.infra.entities.PublicacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepositoryJPA extends JpaRepository<PublicacionEntity, Integer> {

}
