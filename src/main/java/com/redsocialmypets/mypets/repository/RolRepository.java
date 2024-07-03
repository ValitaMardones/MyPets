package com.redsocialmypets.mypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redsocialmypets.mypets.model.Rol;
import com.redsocialmypets.mypets.model.Enum.ERol;

public interface RolRepository extends JpaRepository<Rol, Long> {

  Rol findRolByNombreRol(ERol nombreRol);
}
