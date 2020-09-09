package com.soccer.info.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = {"team"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stardium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String stardiumName;
	
	@ManyToOne
	@JoinColumn(name="teamId")
	@JsonIgnoreProperties({"stardium"})
	private Team team;
	
	@CreationTimestamp
	private Timestamp createDate;
}
