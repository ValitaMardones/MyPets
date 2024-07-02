package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.LikeUser;
import com.redsocialmypets.mypets.model.DTO.LikesDTO;
import com.redsocialmypets.mypets.repository.LikeUserRepository;

@Service
public class LikeUserService {

  @Autowired
  private LikeUserRepository likeUserRepository;

  public List<LikeUser> findAllLikeUser() {
    return likeUserRepository.findAll();
  }

  public LikesDTO getLikeUserById(Long id) {
    LikeUser likeUserId = likeUserRepository.getLikeById(id);
    LikesDTO likesDTOId = LikesDTO.builder()
        .likesUsuario(likeUserId.getIdPerfilMascotaLike().getNombre())
        .likesComentario(likeUserId.getIdComentarioLike().getId())
        .likesPublicacion(likeUserId.getIdPublicacionLike().getId())
        .build();
    return likesDTOId;
  }

  @Transactional
  public LikesDTO saveLikeUser(LikeUser likeUser) {
    LikeUser likeUserGuardar = likeUserRepository.save(likeUser);
    LikesDTO likesDTO = LikesDTO.builder()
        .likesUsuario(likeUserGuardar.getIdPerfilMascotaLike().getNombre())
        .likesComentario(likeUserGuardar.getIdComentarioLike().getId())
        .likesPublicacion(likeUserGuardar.getIdPublicacionLike().getId())
        .build();
    return likesDTO;
  }

  @Transactional
  public LikeUser updateLikeUser(LikeUser likeUser) {
    LikeUser likeUserActualizar = likeUserRepository.save(likeUser);
    return likeUserActualizar;
  }

  @Transactional
  public void deleteLikeUser(Long id) {
    likeUserRepository.deleteById(id);
  }
}
