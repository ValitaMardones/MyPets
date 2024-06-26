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
@Table(name = "comentarios")
public class Comentario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank
  private String contenido;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "perfilMascota_id")
  private PerfilMascota comentarioPerfilMascota;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "publicacion_id")
  private Publicacion comentarioPublicacion;

  @JsonIgnore
  @OneToMany(mappedBy = "likeComentario")
  private List<LikeUser> comentarioLike;

}
