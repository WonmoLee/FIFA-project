package com.soccer.info.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccer.info.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	
	public List<Player> findByTeamId(int teamId);
}
