package com.redsocialmypets.mypets.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerfilDTO {

  private String nombreUsuario;
  private String apellidoUsuario;
  private String nombrePerfil;

}
