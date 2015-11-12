package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class Num extends Keyword {

	public Num(Execution exec) {
		super(exec, 1);
	}

	private int num;

	@Override
	public void load(Object[] args) {
		this.num = convertNumber(args[0]);
	}

	@Override
	public Object execute() {
		return num;
	}
	
	public Integer convertNumber(Object o) {
		if(o instanceof String) {
			try {
				return Integer.parseInt((String) o);
			} catch(NumberFormatException e) {
				System.out.println("Argumenment that is a String must be convertable to a number");
				throw e;
				
			}
		} else if(o instanceof Integer) {
			return (Integer) o;
		} else {
			throw new IllegalArgumentException("Unknow type to conver to Integer of " + o.getClass());
		}
	}

}
