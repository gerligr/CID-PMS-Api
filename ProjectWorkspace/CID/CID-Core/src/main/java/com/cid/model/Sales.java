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
@Entity
public class Sales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;	
	
	@Column(nullable=false)
	private String date;
	
	@Column(nullable=false)
	private int week;
	
	@Column(name = "eur_per_hour", nullable=false)
	private int eurPerHour;
	
	@Column(name = "pax_per_hour", nullable=false)
	private int paxPerHour;
	
	@Column(name="eur_per_pax", nullable=false)
	private int eurPerPax;
	
	@Column(name="calls_per_hour", nullable=false)
	private int callsPerHour;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;	
}
