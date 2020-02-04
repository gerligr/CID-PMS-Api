package com.cid.exceptions;

public class UserException  extends CidException{

	public UserException(String message){
		super(message);
	}
	
	public UserException(Exception e){
		super(e);
	}
}
