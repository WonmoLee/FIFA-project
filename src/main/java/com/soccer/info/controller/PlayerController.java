package com.soccer.info.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soccer.info.dto.PlayerRankDto;
import com.soccer.info.model.Player;
import com.soccer.info.repository.PlayerRepository;
import com.soccer.info.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayerController {

	private static final Logger log = LoggerFactory.getLogger(PlayerController.class);
	private final TeamRepository teamRepository;
	private final PlayerRepository playerRepository;
	
	//선수 등록페이지 이동
	@GetMapping("/playerSaveForm")
	public String playerSaveForm(Model model) {
		model.addAttribute("teamList", teamRepository.findAll());
		return "playerSaveForm";
	}
	
	//선수 목록페이지 이동
	@GetMapping("/playerList")
	public String playerList(Model model) {
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
	
	@PostMapping("/playerSignup")
	public String playerSignup(Model model, Player player) {
		playerRepository.save(player);
		log.info("등록된 선수정보 : " + player);
		model.addAttribute("playerList", playerRepository.findAll());
		System.out.println(model);
		return "playerList";
	}
	
	@DeleteMapping("/playerDelete")
	public @ResponseBody String playerDelete(@RequestBody Player player) {
		playerRepository.deleteById(player.getId());
		return "성공";
	}
}
