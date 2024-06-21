package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.Usuario;
import com.redsocialmypets.mypets.repository.UsuarioRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  public List<Usuario> findAllUsuario() {
    return usuarioRepository.findAll();
  }

  public Usuario getUsuarioById(Long id) {
    var usuarioId = usuarioRepository.findById(id);
    return usuarioId.get();
  }

  @Transactional
  public Usuario saveUsuario(Usuario usuario) {
    Usuario usuarioGuardar = usuarioRepository.save(usuario);
    return usuarioGuardar;
  }

  @Transactional
  public Usuario updateUsuario(Usuario usuario) {
    Usuario usuarioActualizar = usuarioRepository.save(usuario);
    return usuarioActualizar;
  }

  @Transactional
  public void deleteUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }

}
