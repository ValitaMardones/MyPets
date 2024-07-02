package com.redsocialmypets.mypets.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LikesDTO {

  private String likesUsuario; // Quien dio like
  private Long likesComentario;// A que comentarios dio like
  private Long likesPublicacion; // A que publicaciones dio like

}
