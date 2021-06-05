package com.sc.bank.exceptions;

public class IdNotFoundException extends Exception{// checked
	private String msg;
	
	public IdNotFoundException(String msg) {
		this.msg=msg;
	}
	@Override
	public String getMessage() {
        return this.msg;
    }

	
}
