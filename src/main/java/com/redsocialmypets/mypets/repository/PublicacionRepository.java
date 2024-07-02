package com.redsocialmypets.mypets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

  List<Publicacion> getPublicacionesById(Long idPerfil);

}
