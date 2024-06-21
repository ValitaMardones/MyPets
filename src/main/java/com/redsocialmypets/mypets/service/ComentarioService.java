package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.Comentario;
import com.redsocialmypets.mypets.repository.ComentarioRepository;

@Service
public class ComentarioService {

  @Autowired
  private ComentarioRepository comentarioRepository;

  public List<Comentario> findAllComentario() {
    return comentarioRepository.findAll();
  }

  public Comentario getComentarioById(Long id) {
    var comentarioId = comentarioRepository.findById(id);
    return comentarioId.get();
  }

  @Transactional
  public Comentario saveComentario(Comentario comentario) {
    Comentario comentarioGuardar = comentarioRepository.save(comentario);
    return comentarioGuardar;
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
