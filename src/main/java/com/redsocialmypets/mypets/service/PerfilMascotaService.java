package com.redsocialmypets.mypets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.PerfilMascota;
import com.redsocialmypets.mypets.repository.PerfilMascotaRepository;

@Service
public class PerfilMascotaService {

  @Autowired
  private PerfilMascotaRepository perfilMascotaRepository;

  public PerfilMascota findPerfilMascota(Long id) {
    var perfilMascota = perfilMascotaRepository.findById(id);
    return perfilMascota.get();
  }

}
