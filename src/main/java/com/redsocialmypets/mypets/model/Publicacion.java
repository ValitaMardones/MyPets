package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@Table(name = "publicaciones")
public class Publicacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank
  private String titulo;
  @NotBlank
  private String contenido;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "perfilMascota_id")
  private PerfilMascota publicacionPerfilMascota;

  @JsonIgnore
  @OneToMany(mappedBy = "publicacionLike")
  private List<LikeUser> likePublicacion;

  @JsonIgnore
  @OneToMany(mappedBy = "comentarioPublicacion")
  private List<Comentario> publicacionComentario;

}
