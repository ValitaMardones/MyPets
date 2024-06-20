package com.redsocialmypets.mypets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.Publicacion;
import com.redsocialmypets.mypets.repository.PublicacionRepository;

@Service
public class PublicacionService {

  @Autowired
  private PublicacionRepository publicacionRepository;

  public Publicacion findPublicacion(Long id) {
    var publicacion = publicacionRepository.findById(id);
    return publicacion.get();
  }
}
