package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.redsocialmypets.mypets.model.Enum.ELikeUser;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "likes_users")
public class LikeUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Enumerated
  @Column(name = "confirmacion")
  private ELikeUser confirmacion;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "id_perfilMascota")
  private PerfilMascota idPerfilMascotaLike;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "id_publicacion")
  private Publicacion idPublicacionLike;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "id_comentario")
  private Comentario idComentarioLike;

}
