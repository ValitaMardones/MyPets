package com.redsocialmypets.mypets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redsocialmypets.mypets.model.FotoMascota;
import com.redsocialmypets.mypets.service.FotoMascotaService;

@RestController
@RequestMapping("/api/fotoMascota")
public class FotoMascotaController {

  @Autowired
  private FotoMascotaService fotoMascotaService;

  @GetMapping("/{id}")
  public FotoMascota getFotoMascota(@PathVariable Long id) {
    var fotoMascota = fotoMascotaService.findFotoMascota(id);
    return fotoMascota;
  }

  @GetMapping("/{id}/descripcion")
  public String getFotoMascotaDescripcion(@PathVariable Long id) {
    var fotoMascotaDesripcion = fotoMascotaService.findFotoMascota(id);
    return fotoMascotaDesripcion.getDescripcion();
  }
}
