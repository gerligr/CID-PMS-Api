package com.cid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sales_goals")
public class SalesGoals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
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
