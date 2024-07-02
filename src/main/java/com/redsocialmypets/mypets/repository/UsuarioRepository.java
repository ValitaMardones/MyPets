package com.redsocialmypets.mypets.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario findUsuarioById(long id);

  String getNombreById(Long id);

  String getApellidoById(Long id);

  @Query("SELECT u from Usuario u where u.nombre = :nombreUsuario AND u.apellido = :apellidoUsuario")
  Usuario encontrarPorNombreApellido(@Param("nombreUsuario") String nombreUsuario,
      @Param("apellidoUsuario") String apellidoUsuario);

  @Query("SELECT u from Usuario u where u.correo = ?1")
  Usuario encontrarPorCorreo(String correo);

  @Query("SELECT u from Usuario u where u.fechaCreacion = ?1")
  Usuario encontrarPorFechaCreacion(LocalDateTime fechaCreacion);
}
