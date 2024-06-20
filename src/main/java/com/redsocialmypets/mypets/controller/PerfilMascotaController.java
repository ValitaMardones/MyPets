package com.redsocialmypets.mypets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redsocialmypets.mypets.model.PerfilMascota;
import com.redsocialmypets.mypets.service.PerfilMascotaService;

@RestController
@RequestMapping("/api/perfilMascota")
public class PerfilMascotaController {

  @Autowired
  private PerfilMascotaService perfilMascotaService;

  @GetMapping("/{id}")
  public PerfilMascota getPerfilMascota(@PathVariable Long id) {
    var perfilMascota = perfilMascotaService.findPerfilMascota(id);
    return perfilMascota;
  }

  @GetMapping("/{id}/descripcion")
  public String getFotoMascotaDescripcion(@PathVariable Long id) {
    var perfilMascotaDesripcion = perfilMascotaService.findPerfilMascota(id);
    return perfilMascotaDesripcion.getDescripcion();
  }
}
