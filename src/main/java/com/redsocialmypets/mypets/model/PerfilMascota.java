package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "perfil_mascotas")
public class PerfilMascota {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // private ???? foto;
  @NotBlank
  private String nombre;

  @NotBlank
  private String descripcion;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

  @ManyToOne
  @JoinColumn(name = "id_usuario")
  private Usuario idUsuarioPerfilMascota;

  @JsonIgnore
  @OneToMany(mappedBy = "idPerfilMascotaLike")
  private List<LikeUser> perfilMascotaLike;

  @JsonIgnore
  @OneToMany(mappedBy = "idPerfilMascotaComentario")
  private List<Comentario> perfilMascotaComentario;

  @JsonIgnore
  @OneToMany(mappedBy = "idPerfilMascotaPublicacion")
  private List<Publicacion> perfilMascotaPublicacion;

}
