package com.cid.model;

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
	private long id;	
	
	@Column(nullable=false)
	private String date;
	
	@Column(nullable=false)
	private int week;
	
	@Column(nullable=false)
	private String month;
	
	@Column(name = "eur_per_hour", nullable=false)
	private double eurPerHour;
	
	@Column(name = "pax_per_hour", nullable=false)
	private double paxPerHour;
	
	@Column(name="eur_per_pax", nullable=false)
	private double eurPerPax;
	
	@Column(name="calls_per_hour", nullable=false)
	private double callsPerHour;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;	
	
}
