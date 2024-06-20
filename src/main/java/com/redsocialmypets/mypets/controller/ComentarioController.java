package com.redsocialmypets.mypets.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.redsocialmypets.mypets.model.Comentario;
import com.redsocialmypets.mypets.service.ComentarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

  @Autowired
  private ComentarioService comentarioService;

  @GetMapping("/{id}")
  public Comentario getComentario(@PathVariable Long id) {
    var comentario = comentarioService.findComentario(id);
    return comentario;
  }

  @GetMapping("/{id}/contenido")
  public String getComentarioContenido(@PathVariable Long id) {
    var comentarioContenido = comentarioService.findComentario(id);
    return comentarioContenido.getContenido();
  }

}
