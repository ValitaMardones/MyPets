package com.redsocialmypets.mypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.redsocialmypets.mypets.model.Publicacion;
import com.redsocialmypets.mypets.service.PublicacionService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publicacion")
public class PublicacionController {

  @Autowired
  private PublicacionService publicacionService;

  @GetMapping("/lista")
  public List<Publicacion> listaPublicacion() {
    return publicacionService.findAllPublicacion();
  }

  @GetMapping("/{id}")
  public Publicacion getPublicacionById(@PathVariable Long id) {
    return publicacionService.getPublicacionById(id);
  }

  @PostMapping("/agregar")
  public ResponseEntity<?> agregarPublicacion(@RequestBody @Valid Publicacion publicacionNuevo, BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(publicacionService.savePublicacion(publicacionNuevo), HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<?> actualizarPublicacion(@RequestBody @Valid Publicacion publicacionActualizar,
      BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(publicacionService.savePublicacion(publicacionActualizar), HttpStatus.CREATED);
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity<?> eliminarPublicacion(@RequestParam @Valid Long id) {
    publicacionService.deletePublicacion(id);
    return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
  }

}
