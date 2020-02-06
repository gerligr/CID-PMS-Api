package com.cid.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Suggestion {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	private Date date;	
	private Time time;	
	private String place;
	private String subject;
	
	@Column(columnDefinition = "boolean default false")
	private boolean confirmation;
}
