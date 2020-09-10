package com.soccer.info.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.soccer.info.model.PlayerByPosition;
import com.soccer.info.service.PlayerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayerByPositionController {
	
	private final PlayerService playerService;
	
	@GetMapping("/playerByPositionList")
	public String playerByPositionList(Model model) {
		List<PlayerByPosition> playerByPosition = playerService.PlayerByPositionList();
		System.out.println(playerByPosition);
		model.addAttribute("playerByPositionList", playerByPosition);
		return "playerByPosition";
	}
	
	
}
