package com.redsocialmypets.mypets.model.DTO;

import java.util.List;

import com.redsocialmypets.mypets.model.Comentario;
import com.redsocialmypets.mypets.model.LikeUser;
import com.redsocialmypets.mypets.model.Publicacion;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LikesDTO {

  private LikeUser likesUsuario; // Quien dio like
  private List<Comentario> likesComentario;// A que comentarios dio like
  private List<Publicacion> likesPublicacion; // A que publicaciones dio like

}
