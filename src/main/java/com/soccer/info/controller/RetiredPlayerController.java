package com.soccer.info.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.soccer.info.dto.PlayerRankDto;
import com.soccer.info.model.Player;
import com.soccer.info.model.RetiredPlayer;
import com.soccer.info.repository.PlayerRepository;
import com.soccer.info.repository.RetiredPlayerRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RetiredPlayerController {
	
	private final PlayerRepository playerRepository;
	private final RetiredPlayerRepository retiredPlayerRepository;
	
	@GetMapping("/retiredPlayerSaveForm")
	public String retiredPlayerSaveForm(Model model) {
		model.addAttribute("playerList", playerRepository.findAll());
		return "retiredPlayerSaveForm";
	}
	
	@PostMapping("/retiredSignup")
	public String retiredSignup(Model model, RetiredPlayer retiredPlayer) {
		retiredPlayerRepository.save(retiredPlayer);
		List<Player> players = playerRepository.findAll();
		List<PlayerRankDto> playerRankDtoList = new ArrayList<>();
		for (int i = 0; i < players.size(); i++) {
			PlayerRankDto playerRankDto = PlayerRankDto.builder()
														.rank(i+1)
														.player(players.get(i))
														.build();
			playerRankDtoList.add(playerRankDto);
		}
		model.addAttribute("playerRankDtoList", playerRankDtoList);
		return "playerList";
	}
}
