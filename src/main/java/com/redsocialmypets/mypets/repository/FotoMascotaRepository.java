package com.redsocialmypets.mypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.FotoMascota;

@Repository
public interface FotoMascotaRepository extends JpaRepository<FotoMascota, Long> {

}
