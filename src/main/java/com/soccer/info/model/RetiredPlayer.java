package com.soccer.info.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "player")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RetiredPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String reason;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "playerId")
	private Player player;
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
