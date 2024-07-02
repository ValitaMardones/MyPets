package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.Publicacion;
import com.redsocialmypets.mypets.model.DTO.PublicacionDTO;
import com.redsocialmypets.mypets.repository.PublicacionRepository;

@Service
public class PublicacionService {

  @Autowired
  private PublicacionRepository publicacionRepository;

  public List<Publicacion> findAllPublicacion() {
    return publicacionRepository.findAll();
  }

  public PublicacionDTO getPublicacionById(Long id) {
    Publicacion publicacionId = publicacionRepository.getPublicacionById(id);
    PublicacionDTO publicacionDTOId = PublicacionDTO.builder()
        .titulo(publicacionId.getTitulo())
        .contenido(publicacionId.getContenido())
        .nombrePerfil(publicacionId.getIdPerfilMascotaPublicacion().getNombre())
        .fechaComentario(publicacionId.getFechaCreacion())
        .likesComentario(publicacionId.getPublicacionLike())
        .build();
    return publicacionDTOId;
  }

  @Transactional
  public PublicacionDTO savePublicacion(Publicacion publicacion) {
    Publicacion publicacionGuardar = publicacionRepository.save(publicacion);
    PublicacionDTO publicacionDTO = PublicacionDTO.builder()
        .titulo(publicacionGuardar.getTitulo())
        .contenido(publicacionGuardar.getContenido())
        .nombrePerfil(publicacionGuardar.getIdPerfilMascotaPublicacion().getNombre())
        .fechaComentario(publicacionGuardar.getFechaCreacion())
        .likesComentario(publicacionGuardar.getPublicacionLike())
        .build();
    return publicacionDTO;
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
