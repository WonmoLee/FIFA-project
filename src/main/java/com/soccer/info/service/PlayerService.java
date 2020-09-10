package com.soccer.info.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.soccer.info.model.PlayerByPosition;


@Service
public class PlayerService {

	@PersistenceContext
	private EntityManager em;
	
	public List<PlayerByPosition> PlayerByPositionList() {
		List<PlayerByPosition> playerByPositionList = em.createNamedQuery("playerByPosition").getResultList();
		return playerByPositionList;
	}
}
