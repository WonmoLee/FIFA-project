package com.soccer.info.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.soccer.info.model.Stardium;
import com.soccer.info.repository.StardiumRepository;
import com.soccer.info.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StardiumController {
	
	private static final Logger log = LoggerFactory.getLogger(StardiumController.class);
	private final TeamRepository teamRepository;
	private final StardiumRepository stardiumRepository;
	
	//스타디움 등록페이지 이동
	@GetMapping("/stardiumSaveForm")
	public String stardiumSaveForm(Model model) {
		model.addAttribute("teamList", teamRepository.findAll());
		return "stardiumSaveForm";
	}
	
	//스타디움 목록 페이지 이동
	@GetMapping("/stardiumList")
	public String stardiumList(Model model) {
		model.addAttribute("stardiumList", stardiumRepository.findAll());
		return "stardiumList";
	}
	
	@PostMapping("/stardiumSignup")
	public String stardiumSignup(Model model, Stardium stardium) {
		stardiumRepository.save(stardium);
		log.info("등록된 경기장정보 : " + stardium);
		model.addAttribute("stardiumList", stardiumRepository.findAll());
		return "stardiumList";
	}
	
}
