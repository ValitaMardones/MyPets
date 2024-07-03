package com.redsocialmypets.mypets.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.PerfilMascota;

@Repository
public interface PerfilMascotaRepository extends JpaRepository<PerfilMascota, Long> {

  PerfilMascota findPerfilMascotaById(long id);

  String findNombreUsuarioById(Long id);

  // Buscar por nombre del perfilMascota
  @Query("SELECT m from PerfilMascota m where m.nombre = ?1")
  PerfilMascota encontrarNombrePerfil(String nombre);

  // Buscar por palabras claves dentro de la descripcion del PerfilMascota
  @Query(value = "SELECT * from PerfilMascota m where m.descripcion LIKE %:patron%", nativeQuery = true)
  PerfilMascota encontrarPerfilPorDescripcion(String patron);

  // Cuantos comentarios ha realizado

  // Cuantas publicaciones ha realizado

  // Cuando like ha realizado

  // Cuando se registro el perfilMascota
  @Query("SELECT m from PerfilMascota m where m.fechaCreacion = ?1")
  PerfilMascota encontrarPorFechaCreacion(LocalDateTime fechaCreacion);

}
