package com.soccer.info.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerByPosition {
	
	private String position;
	private String PSG;
	private String Barcelona;
	private String RealMadrid;
	
}
