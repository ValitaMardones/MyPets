package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.PerfilMascota;
import com.redsocialmypets.mypets.repository.PerfilMascotaRepository;

@Service
public class PerfilMascotaService {

  @Autowired
  private PerfilMascotaRepository perfilMascotaRepository;

  public List<PerfilMascota> findAllPerfilMascota() {
    return perfilMascotaRepository.findAll();
  }

  public PerfilMascota getPerfilMascotaById(Long id) {
    var perfilMascotaId = perfilMascotaRepository.findById(id);
    return perfilMascotaId.get();
  }

  @Transactional
  public PerfilMascota savePerfilMascota(PerfilMascota perfilMascota) {
    PerfilMascota perfilMascotaGuardar = perfilMascotaRepository.save(perfilMascota);
    return perfilMascotaGuardar;
  }

  @Transactional
  public PerfilMascota updatePerfilMascota(PerfilMascota perfilMascota) {
    PerfilMascota perfilMascotaActualizar = perfilMascotaRepository.save(perfilMascota);
    return perfilMascotaActualizar;
  }

  @Transactional
  public void deletePerfilMascota(Long id) {
    perfilMascotaRepository.deleteById(id);
  }

}
