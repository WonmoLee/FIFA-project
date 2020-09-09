package com.soccer.info.model;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString(exclude = {"stardium"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String teamName;
	
	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"team"})
	private List<Stardium> stardium;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("team")
	private List<Player> players;
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
