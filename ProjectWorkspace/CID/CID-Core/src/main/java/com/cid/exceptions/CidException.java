package com.cid.exceptions;

import lombok.Getter;
import lombok.Setter;

public class CidException extends RuntimeException{

	@Getter
	@Setter
	int code;
	
	public CidException(String message){
		super(message);
	}
	
	public CidException(Exception e){
		super(e);
	}
}
