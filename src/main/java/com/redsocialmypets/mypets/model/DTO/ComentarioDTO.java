package com.redsocialmypets.mypets.model.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.redsocialmypets.mypets.model.LikeUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComentarioDTO {

  private String contenido; // Que se publico
  private String nombrePerfil; // Quien lo publico
  private LocalDateTime fechaComentario; // Cuando se publico
  private String tituloPublicacion; // Donde se publico
  private List<LikeUser> likesComentario; // Quien ha dado like

}
