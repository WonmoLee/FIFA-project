package com.soccer.info.dto;

import com.soccer.info.model.Player;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerRankDto {

	private int rank;
	private Player player;
}
