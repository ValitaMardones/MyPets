package com.redsocialmypets.mypets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redsocialmypets.mypets.model.Usuario;
import com.redsocialmypets.mypets.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/{id}")
  public Usuario getUsuario(@PathVariable Long id) {
    var usuario = usuarioService.findUsuario(id);
    return usuario;
  }

  @GetMapping("/{id}/nombre")
  public String getUsuarioNombre(@PathVariable Long id) {
    var usuarioNombre = usuarioService.findUsuario(id);
    return usuarioNombre.getNombre();
  }

  @GetMapping("/{id}/apellido")
  public String getUsuarioApellido(@PathVariable Long id) {
    var usuarioApellido = usuarioService.findUsuario(id);
    return usuarioApellido.getApellido();
  }

  @GetMapping("/{id}/correo")
  public String getUsuarioCorreo(@PathVariable Long id) {
    var usuarioCorreo = usuarioService.findUsuario(id);
    return usuarioCorreo.getCorreo();
  }

}
