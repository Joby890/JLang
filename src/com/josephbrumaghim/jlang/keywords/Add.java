package com.josephbrumaghim.jlang.keywords;

public class Add extends Keyword {
	
	private int num1;
	private int num2;

	public Add() {
		super(2);
	}

	@Override
	public void load(Object[] args) {
		if(args[0] instanceof String) {
			num1 = Integer.parseInt((String)args[0]);	
		} else {
			num1 = (int) args[0];
		}
		if(args[1] instanceof String) {
			num2 = Integer.parseInt((String)args[1]);	
		} else {
			num2 = (int) args[1];
		}

	}

	@Override
	public Object execute() {
		return num1 + num2;
	}

}
