package com.cid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
//@Entity
public class Sales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", referencedColumnName = "id")
	private Team team;	
	
	@Column(nullable=false)
	private Date date;
	
	@Column(nullable=false)
	private int week;
	
	@Column(nullable=false)
	private int eurPerHour;
	
	@Column(nullable=false)
	private int paxPerHour;
	
	@Column(nullable=false)
	private int eurPerPax;
	
	@Column(nullable=false)
	private int callsPerHour;
	
	
}
