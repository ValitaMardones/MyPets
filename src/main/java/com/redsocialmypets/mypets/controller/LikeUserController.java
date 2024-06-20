package com.redsocialmypets.mypets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redsocialmypets.mypets.model.LikeUser;
import com.redsocialmypets.mypets.service.LikeUserService;

@RestController
@RequestMapping("/api/likeUser")
public class LikeUserController {

  @Autowired
  private LikeUserService likeUserService;

  @GetMapping("{id}")
  public LikeUser getLikeUser(@PathVariable Long id) {
    var likeUser = likeUserService.findLikeUser(id);
    return likeUser;
  }

  @GetMapping("{id}/confirm")
  public Integer getLikeUserConfirm(@PathVariable Long id) {
    var likeUserConfirm = likeUserService.findLikeUser(id);
    return likeUserConfirm.getConfirm();
  }

}
