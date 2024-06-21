package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.Publicacion;
import com.redsocialmypets.mypets.repository.PublicacionRepository;

@Service
public class PublicacionService {

  @Autowired
  private PublicacionRepository publicacionRepository;

  public List<Publicacion> findAllPublicacion() {
    return publicacionRepository.findAll();
  }

  public Publicacion getPublicacionById(Long id) {
    var publicacionId = publicacionRepository.findById(id);
    return publicacionId.get();
  }

  @Transactional
  public Publicacion savePublicacion(Publicacion publicacion) {
    Publicacion publicacionGuardar = publicacionRepository.save(publicacion);
    return publicacionGuardar;
  }

  @Transactional
  public Publicacion updatePublicacion(Publicacion publicacion) {
    Publicacion publicacionActualizar = publicacionRepository.save(publicacion);
    return publicacionActualizar;
  }

  @Transactional
  public void deletePublicacion(Long id) {
    publicacionRepository.deleteById(id);
  }
}
