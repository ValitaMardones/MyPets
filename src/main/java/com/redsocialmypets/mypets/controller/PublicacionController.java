package com.redsocialmypets.mypets.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.redsocialmypets.mypets.model.Publicacion;
import com.redsocialmypets.mypets.service.PublicacionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publicacion")
public class PublicacionController {

  @Autowired
  private PublicacionService publicacionService;

  @GetMapping("/{id}")
  public Publicacion getPublicacion(@PathVariable Long id) {
    var publicacion = publicacionService.findPublicacion(id);
    return publicacion;
  }

  @GetMapping("/{id}/titulo")
  public String getPublicacionTitulo(@PathVariable Long id) {
    var publicacionTitulo = publicacionService.findPublicacion(id);
    return publicacionTitulo.getTitulo();
  }

  @GetMapping("/{id}/contenido")
  public String getPublicacionContenido(@PathVariable Long id) {
    var publicacionContenido = publicacionService.findPublicacion(id);
    return publicacionContenido.getContenido();
  }

}
