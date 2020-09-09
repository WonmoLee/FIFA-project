package com.soccer.info.model;

import java.sql.Timestamp;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.soccer.info.controller.PlayerByPositionController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SqlResultSetMapping(
		name = "playerByPosition",
		classes = @ConstructorResult(
				targetClass = PlayerByPositionController.class,
				columns = {
						@ColumnResult(name = "position", type = String.class),
						@ColumnResult(name = "LS", type = String.class),
						@ColumnResult(name = "ST", type = String.class),
						@ColumnResult(name = "RS", type = String.class)
				})
		)

@NamedNativeQuery(
		name = "playerByPosition",
		query = "select \r\n" + 
				"position, \r\n" + 
				"max(if(teamId=11, playerName, \"\")) \"파리생제르망\",\r\n" + 
				"max(if(teamId=12, playerName, \"\")) \"바르셀로나\"\r\n" + 
				"max(if(teamId=12, playerName, \"\")) \"레알마드리드\"\r\n" + 
				"from player\r\n" + 
				"group by position;",
		resultSetMapping = "playerByPosition")

@Getter
@Setter
@ToString(exclude = {"team"})
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
	
	@CreationTimestamp
	private Timestamp createDate;
}
