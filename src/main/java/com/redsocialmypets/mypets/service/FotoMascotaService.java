package com.redsocialmypets.mypets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.FotoMascota;
import com.redsocialmypets.mypets.repository.FotoMascotaRepository;

@Service
public class FotoMascotaService {

  @Autowired
  private FotoMascotaRepository fotoMascotaRepository;

  public FotoMascota findFotoMascota(Long id) {
    var fotoMascota = fotoMascotaRepository.findById(id);
    return fotoMascota.get();
  }

}
