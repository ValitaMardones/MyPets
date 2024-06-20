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
  private long id;

  // private ???? foto;
  @NotBlank
  private String descripcion;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "user_id")
  private Usuario perfilMascotaUsuario;

  @JsonIgnore
  @OneToMany(mappedBy = "likePerfilMascota")
  private List<LikeUser> perfilMascotaLike;

  @JsonIgnore
  @OneToMany(mappedBy = "comentarioPerfilMascota")
  private List<Comentario> perfilMascotaComentario;

  @JsonIgnore
  @OneToMany(mappedBy = "publicacionPerfilMascota")
  private List<Publicacion> perfilMascotaPublicacion;

}
