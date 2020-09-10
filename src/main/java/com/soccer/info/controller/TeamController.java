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

import com.soccer.info.dto.TeamRankDto;
import com.soccer.info.model.Team;
import com.soccer.info.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeamController {

	private static final Logger log = LoggerFactory.getLogger(TeamController.class);
	private final TeamRepository teamRepository;
	
	//팀 등록페이지 이동
	@GetMapping("/teamSaveForm")
	public String teamSaveForm() {
		return "teamSaveForm";
	}
		
	//팀 목록페이지 이동
	@GetMapping("/teamList")
	public String teamList(Model model) {
		List<Team> teams = teamRepository.findAll();
		List<TeamRankDto> teamRankDtoList = new ArrayList<>();
		for (int i = 0; i < teams.size(); i++) {
			TeamRankDto teamRankDto = TeamRankDto.builder()
														.rank(i+1)
														.team(teams.get(i))
														.build();
			teamRankDtoList.add(teamRankDto);
		}
		model.addAttribute("teamRankDtoList", teamRankDtoList);
		return "teamList";
	}
	
	//팀 등록 기능
	@PostMapping("/teamSignup")
	public String stardiumSignup(Model model, Team team) {
		teamRepository.save(team);
		log.info("등록된 팀정보 : " + team);
		model.addAttribute("teamList", teamRepository.findAll());
		return "teamList";
	}
	
	@DeleteMapping("/teamDelete")
	public @ResponseBody String teamDelete(@RequestBody Team team) {
		teamRepository.deleteById(team.getId());
		return "성공";
	}
		
}
