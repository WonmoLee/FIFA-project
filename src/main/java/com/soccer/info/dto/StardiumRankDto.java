package com.soccer.info.dto;

import com.soccer.info.model.Stardium;

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
public class StardiumRankDto {

	private int rank;
	private Stardium stardium;
}
