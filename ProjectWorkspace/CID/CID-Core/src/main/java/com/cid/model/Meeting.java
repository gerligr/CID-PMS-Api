package com.cid.model;

import java.sql.Time;
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
public class Meeting {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	
	@Column(nullable=false)
	private Date date;
	
	@Column(nullable=false)
	private Time time;
	
	@Column(nullable=false)
	private String place;
	
	@Column(nullable=false)
	private String subject;
	
	@Column(nullable=false)
	private boolean confirmation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	

}
