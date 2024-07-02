package com.redsocialmypets.mypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.redsocialmypets.mypets.model.Comentario;
import com.redsocialmypets.mypets.service.ComentarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

  @Autowired
  private ComentarioService comentarioService;

  @GetMapping("/lista")
  public List<Comentario> listaComentario() {
    return comentarioService.findAllComentario();
  }

  // Modificar para que cuando solicite revisar un comentario por id, me muestre
  // un comentarioDTO
  @GetMapping("/{id}")
  public Comentario getComentarioById(@PathVariable Long id) {
    return comentarioService.getComentarioById(id);
  }

  // Modificar para que cuando agrege un comentario, me muestre confirmacion con
  // un comentarioDTO
  @PostMapping("/agregar")
  public ResponseEntity<?> agregarComentario(@RequestBody @Valid Comentario comentarioNuevo, BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(comentarioService.saveComentario(comentarioNuevo), HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<?> actualizarComentario(@RequestBody @Valid Comentario comentarioActualizar,
      BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(comentarioService.saveComentario(comentarioActualizar), HttpStatus.CREATED);
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity<?> eliminarComentario(@RequestParam @Valid Long id) {
    comentarioService.deleteComentario(id);
    return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
  }

}
