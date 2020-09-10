package com.soccer.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soccer.info.model.RetiredPlayer;

public interface RetiredPlayerRepository extends JpaRepository<RetiredPlayer, Integer> {

}
