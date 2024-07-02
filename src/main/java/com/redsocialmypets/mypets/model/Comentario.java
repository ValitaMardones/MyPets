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
  @JoinColumn(name = "id_perfilMascota")
  private PerfilMascota idPerfilMascotaComentario;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "id_publicacion")
  private Publicacion idPublicacionComentario;

  @JsonIgnore
  @OneToMany(mappedBy = "idComentarioLike")
  private List<LikeUser> comentarioLike;

}
