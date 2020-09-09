package com.soccer.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccer.info.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

}
