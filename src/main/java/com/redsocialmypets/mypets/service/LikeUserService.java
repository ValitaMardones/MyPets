package com.redsocialmypets.mypets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocialmypets.mypets.model.LikeUser;
import com.redsocialmypets.mypets.repository.LikeUserRepository;

@Service
public class LikeUserService {

  @Autowired
  private LikeUserRepository likeUserRepository;

  public LikeUser findLikeUser(Long id) {
    var likeUser = likeUserRepository.findById(id);
    return likeUser.get();
  }
}
