package com.redsocialmypets.mypets.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class LikeUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int confirm;

  @CreationTimestamp
  private LocalDateTime fechaCreacion;

}
