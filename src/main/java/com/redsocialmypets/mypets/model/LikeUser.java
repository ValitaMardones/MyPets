package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Table(name = "likes_users")
public class LikeUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private int confirm;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "perfilMascota_id")
  private PerfilMascota likePerfilMascota;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "publicacion_id")
  private Publicacion publicacionLike;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "comentario_id")
  private Comentario likeComentario;

}
