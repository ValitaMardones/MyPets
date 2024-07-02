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
  @JoinColumn(name = "id_perfilMascota")
  private PerfilMascota idPerfilMascotaPublicacion;

  @JsonIgnore
  @OneToMany(mappedBy = "idPublicacionLike")
  private List<LikeUser> publicacionLike;

  @JsonIgnore
  @OneToMany(mappedBy = "idPublicacionComentario")
  private List<Comentario> publicacionComentario;

}
