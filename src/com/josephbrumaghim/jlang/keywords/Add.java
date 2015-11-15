package com.josephbrumaghim.jlang.keywords;

import java.util.Arrays;

import com.josephbrumaghim.jlang.Execution;

public class Add extends Keyword {
	
	private Object num1;
	private Object num2;

	public Add(Execution exec) {
		super(exec,2);
	}

	@Override
	public void load(Object[] args) {
		try {
			num1 = Integer.parseInt((String) args[0]);
		} catch (Exception e) {
			num1 = args[0];
		}
		try {
			num2 = Integer.parseInt((String) args[1]);
		} catch (Exception e) {
			num2 = args[1];
		}

	}

	@Override
	public Object execute() {
		if(num1 instanceof Integer && num2 instanceof Integer) {
			return (int) num1 + (int) num2;
		} else if(num1 instanceof Integer && num2 instanceof String) {
			return ""+ num1 + num2;
		} else if(num1 instanceof String) {
			return (String) num1 + num2; 
		}
		return null;

	}

}
