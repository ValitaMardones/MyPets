package com.redsocialmypets.mypets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redsocialmypets.mypets.model.LikeUser;
import com.redsocialmypets.mypets.repository.LikeUserRepository;

@Service
public class LikeUserService {

  @Autowired
  private LikeUserRepository likeUserRepository;

  public List<LikeUser> findAllLikeUser() {
    return likeUserRepository.findAll();
  }

  public LikeUser getLikeUserById(Long id) {
    var likeUserId = likeUserRepository.findById(id);
    return likeUserId.get();
  }

  @Transactional
  public LikeUser saveLikeUser(LikeUser likeUser) {
    LikeUser likeUserGuardar = likeUserRepository.save(likeUser);
    return likeUserGuardar;
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
