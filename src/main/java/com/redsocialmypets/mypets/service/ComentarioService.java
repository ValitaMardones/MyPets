package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.Comentario;
import com.redsocialmypets.mypets.model.DTO.ComentarioDTO;
import com.redsocialmypets.mypets.repository.ComentarioRepository;

@Service
public class ComentarioService {

  @Autowired
  private ComentarioRepository comentarioRepository;

  public List<Comentario> findAllComentario() {
    return comentarioRepository.findAll();
  }

  public ComentarioDTO getComentarioById(Long id) {
    Comentario comentarioId = comentarioRepository.findComentarioById(id);
    ComentarioDTO comentarioDTOId = ComentarioDTO.builder()
        .contenido(comentarioId.getContenido())
        .nombrePerfil(comentarioId.getIdPerfilMascotaComentario().getNombre())
        .fechaComentario(comentarioId.getFechaCreacion())
        .tituloPublicacion(comentarioId.getIdPublicacionComentario().getTitulo())
        .likesComentario(comentarioId.getComentarioLike())
        .build();
    return comentarioDTOId;
  }

  @Transactional
  public ComentarioDTO saveComentario(Comentario comentario) {
    Comentario comentarioGuardar = comentarioRepository.save(comentario);
    ComentarioDTO comentarioDTO = ComentarioDTO.builder()
        .contenido(comentarioGuardar.getContenido())
        .nombrePerfil(comentarioGuardar.getIdPerfilMascotaComentario().getNombre())
        .fechaComentario(comentarioGuardar.getFechaCreacion())
        .tituloPublicacion(comentarioGuardar.getIdPublicacionComentario().getTitulo())
        .likesComentario(comentarioGuardar.getComentarioLike())
        .build();
    return comentarioDTO;
  }

  @Transactional
  public Comentario updateComentario(Comentario comentario) {
    Comentario comentarioActualizar = comentarioRepository.save(comentario);
    return comentarioActualizar;
  }

  @Transactional
  public void deleteComentario(Long id) {
    comentarioRepository.deleteById(id);
  }
}
