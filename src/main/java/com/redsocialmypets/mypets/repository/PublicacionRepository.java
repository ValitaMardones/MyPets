package com.redsocialmypets.mypets.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

  Publicacion getPublicacionById(Long idPerfil);

  // Buscar publicacion por titulo
  @Query("SELECT p from publicacion p where p.titulo = ?1")
  Publicacion encontrarPublicacionPorTitulo(String titulo);

  // Buscar publicacion por palabras claves del contenido

  // Buscar publicacion por fecha de creacion
  @Query("SELECT p from Publicacion p where p.fechaCreacion = ?1")
  Publicacion encontrarPorFechaCreacion(LocalDateTime fechaCreacion);

}
