package com.soccer.info.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SqlResultSetMapping(
		name = "playerByPosition",
		classes = @ConstructorResult(
				targetClass = PlayerByPosition.class,
				columns = {
						@ColumnResult(name = "position", type = String.class),
						@ColumnResult(name = "PSG", type = String.class),
						@ColumnResult(name = "Barcelona", type = String.class),
						@ColumnResult(name = "RealMadrid", type = String.class)
				})
		)

@NamedNativeQuery(
		name = "playerByPosition",
		query = "select \r\n" + 
				"position, \r\n" + 
				"max(if(teamId=11, playerName, \"\")) \"PSG\",\r\n" + 
				"max(if(teamId=12, playerName, \"\")) \"Barcelona\",\r\n" + 
				"max(if(teamId=13, playerName, \"\")) \"RealMadrid\"\r\n" + 
				"from player, team\r\n" + 
				"WHERE player.teamId = team.id " + 
        		"	AND player.id NOT IN (SELECT player.id " + 
        		"							FROM player, retiredplayer " + 
        		"							WHERE retiredplayer.playerId = player.id) " + 
				"group by position;",
		resultSetMapping = "playerByPosition")

@Getter
@Setter
@ToString(exclude = {"team", "retiredPlayer"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String playerName;
	
	private String position;
	
	@ManyToOne
	@JoinColumn(name="teamId")
	@JsonIgnoreProperties({"stardium"})
	private Team team;
	
	@OneToOne(mappedBy = "player", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"player"})
	private RetiredPlayer retiredPlayer;
	
	@CreationTimestamp
	private Timestamp createDate;
}
