package com.redsocialmypets.mypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.PerfilMascota;

@Repository
public interface PerfilMascotaRepository extends JpaRepository<PerfilMascota, Long> {

}
