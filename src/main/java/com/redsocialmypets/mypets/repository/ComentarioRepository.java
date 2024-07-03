package com.redsocialmypets.mypets.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

  Comentario findComentarioById(long id);

  // Que perfil hizo el comentario
  @Query("SELECT c from Comentario c where c.idPerfilMascotaComentario = ?1")
  Comentario encontrarPerfilMascota(String nombrePerfil);

  // En que publicacion se hizo el comentario
  @Query("SELECT c from Comentario c where c.idPublicacionComentario = ?1")
  Comentario encontrarPublicacion(Long id);

  // Cuando se realizo el comentario
  @Query("SELECT c from Comentario c where c.fechaCreacion = ?1")
  Comentario encontrarPorFechaCreacion(LocalDateTime fechaCreacion);

}
