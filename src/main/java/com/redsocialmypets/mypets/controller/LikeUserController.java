package com.redsocialmypets.mypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redsocialmypets.mypets.model.LikeUser;
import com.redsocialmypets.mypets.model.DTO.LikesDTO;
import com.redsocialmypets.mypets.service.LikeUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/likeUser")
public class LikeUserController {

  @Autowired
  private LikeUserService likeUserService;

  @GetMapping("/lista")
  public List<LikeUser> listaLikeUser() {
    return likeUserService.findAllLikeUser();
  }

  // Modificar para que cuando solicite revisar un like por id, me muestre un
  // LikeDTO
  @GetMapping("/{id}")
  public LikesDTO getLikeUserById(@PathVariable Long id) {
    return likeUserService.getLikeUserById(id);
  }

  // Modificar para que cuando agrege un like, me muestre confirmacion con un
  // likeDTO
  @PostMapping("/agregar")
  public ResponseEntity<?> agregarLikeUser(@RequestBody @Valid LikeUser likeUserNuevo, BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(likeUserService.saveLikeUser(likeUserNuevo), HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<?> actualizarLikeUser(@RequestBody @Valid LikeUser likeUserActualizar, BindingResult result) {
    if (result.hasErrors()) {
      return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
    }
    return new ResponseEntity<>(likeUserService.saveLikeUser(likeUserActualizar), HttpStatus.CREATED);
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity<?> eliminarLikeUser(@RequestParam @Valid Long id) {
    likeUserService.deleteLikeUser(id);
    return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
  }

}
