package com.redsocialmypets.mypets.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.LikeUser;

@Repository
public interface LikeUserRepository extends JpaRepository<LikeUser, Long> {

  LikeUser getLikeById(Long id);

  // Cuando se realizo el like
  @Query("SELECT l from LikeUser l where l.fechaCreacion = ?1")
  LikeUser encontrarPorFechaCreacion(LocalDateTime fechaCreacion);

}
