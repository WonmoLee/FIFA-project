package com.soccer.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerByPosition {
	
	@GetMapping("/playerByPositionList")
	public String playerByPositionList() {
		return "playerByPosition";
	}
}
