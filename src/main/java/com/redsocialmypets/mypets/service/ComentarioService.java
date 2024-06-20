package com.redsocialmypets.mypets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.Comentario;
import com.redsocialmypets.mypets.repository.ComentarioRepository;

@Service
public class ComentarioService {

  @Autowired
  private ComentarioRepository comentarioRepository;

  public Comentario findComentario(Long id) {
    var comentario = comentarioRepository.findById(id);
    return comentario.get();
  }
}
