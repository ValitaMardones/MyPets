package com.redsocialmypets.mypets.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

  private String nombre;
  private String apellido;
  private String correo;

}
