package com.redsocialmypets.mypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.redsocialmypets.mypets.model.PerfilMascota;
import com.redsocialmypets.mypets.model.DTO.PerfilDTO;
import com.redsocialmypets.mypets.service.PerfilMascotaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/perfilMascota")
public class PerfilMascotaController {

  @Autowired
  private PerfilMascotaService perfilMascotaService;

  @GetMapping("/lista")
  public List<PerfilMascota> listaPerfilMascota() {
    return perfilMascotaService.findAllPerfilMascota();
  }

  @GetMapping("/{id}")
  public PerfilDTO getPerfilMascotaById(@PathVariable Long id) {
    return perfilMascotaService.getPerfilMascotaById(id);
  }

  @PostMapping("/agregar")
  public ResponseEntity<?> agregarPerfilMascota(@RequestBody @Valid PerfilMascota perfilMascotaNuevo,
      BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(perfilMascotaService.savePerfilMascota(perfilMascotaNuevo), HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<?> actualizarPerfilMascota(@RequestBody @Valid PerfilMascota perfilMascotaActualizar,
      BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(perfilMascotaService.savePerfilMascota(perfilMascotaActualizar), HttpStatus.CREATED);
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity<?> eliminarPerfilMascota(@RequestParam @Valid Long id) {
    perfilMascotaService.deletePerfilMascota(id);
    return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
  }
}