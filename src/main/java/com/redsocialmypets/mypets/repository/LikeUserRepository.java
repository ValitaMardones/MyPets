package com.redsocialmypets.mypets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocialmypets.mypets.model.LikeUser;

@Repository
public interface LikeUserRepository extends JpaRepository<LikeUser, Long> {

  List<LikeUser> getLikesById(Long idPerfil);

}
