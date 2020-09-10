package com.soccer.info.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soccer.info.model.Player;
import com.soccer.info.repository.PlayerRepository;
import com.soccer.info.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayerByTeamController {

	private final TeamRepository teamRepository;
	private final PlayerRepository playerRepository;
	
	@GetMapping("/playerByTeamList")
	public String playerByTeamList(Model model) {
		model.addAttribute("teamList", teamRepository.findAll());
		System.out.println(model);
		return "playerByTeam";
	}
	
	@GetMapping("/getPlayer/{teamId}")
	public @ResponseBody List<Player> teamPlayerProc(@PathVariable int teamId) {
		return playerRepository.findByTeamId(teamId);
	}
}
