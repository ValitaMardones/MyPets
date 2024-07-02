package com.redsocialmypets.mypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.LikeUser;

@Repository
public interface LikeUserRepository extends JpaRepository<LikeUser, Long> {

  LikeUser getLikeById(Long id);

}
