package com.redsocialmypets.mypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.redsocialmypets.mypets.model.Usuario;
import com.redsocialmypets.mypets.model.DTO.UsuarioDTO;
import com.redsocialmypets.mypets.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/lista")
  public List<Usuario> listaUsuario() {
    return usuarioService.findAllUsuario();
  }

  @GetMapping("/{id}")
  public UsuarioDTO getUsuarioById(@PathVariable Long id) {
    return usuarioService.getUsuarioById(id);
  }

  @PostMapping("/agregar")
  public ResponseEntity<?> agregarUsuario(@RequestBody @Valid Usuario usuarioNuevo, BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(usuarioService.saveUsuario(usuarioNuevo), HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<?> actualizarUsuario(@RequestBody @Valid Usuario usuarioActualizar, BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(usuarioService.saveUsuario(usuarioActualizar), HttpStatus.CREATED);
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity<?> eliminarUsuario(@RequestParam @Valid Long id) {
    usuarioService.deleteUsuario(id);
    return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
  }

}