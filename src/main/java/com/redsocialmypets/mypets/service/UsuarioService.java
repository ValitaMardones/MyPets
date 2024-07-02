package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.Usuario;
import com.redsocialmypets.mypets.model.DTO.UsuarioDTO;
import com.redsocialmypets.mypets.repository.UsuarioRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  // Solo usuarios autorizados podran acceder a la lista completa de usuarios
  public List<Usuario> findAllUsuario() {
    return usuarioRepository.findAll();
  }

  // Cuando soliciten informacion de usuarios se entregara un UsuarioDTO para
  // proteger datos sencibles
  public UsuarioDTO getUsuarioById(Long id) {
    Usuario usuarioId = usuarioRepository.findUsuarioById(id);
    UsuarioDTO usuarioDTOId = UsuarioDTO.builder()
        .nombre(usuarioId.getNombre())
        .apellido(usuarioId.getApellido())
        .correo(usuarioId.getCorreo())
        .build();
    return usuarioDTOId;
  }

  // Cuando se registre un nuevo Usuario solo retornaran datos del UsuarioDTO para
  // proteger datos sencibles
  @Transactional
  public UsuarioDTO saveUsuario(Usuario usuario) {
    Usuario usuarioGuardar = usuarioRepository.save(usuario);
    UsuarioDTO usuarioDTOGuardado = UsuarioDTO.builder()
        .nombre(usuarioGuardar.getNombre())
        .apellido(usuarioGuardar.getApellido())
        .correo(usuarioGuardar.getCorreo())
        .build();
    return usuarioDTOGuardado;
  }

  // Solo usuarios autorizados podran actualizar datos de los usuarios, por lo que
  // no sera necesario entregar un UsuarioDTO para proteger datos
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
