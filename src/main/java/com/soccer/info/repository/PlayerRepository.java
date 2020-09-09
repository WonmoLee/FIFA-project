package com.soccer.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccer.info.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
