package com.redsocialmypets.mypets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.Usuario;
import com.redsocialmypets.mypets.repository.UsuarioRepository;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  public Usuario findUsuario(Long id) {
    var usuario = usuarioRepository.findById(id);
    return usuario.get();
  }

}
