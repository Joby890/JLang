package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;
import com.josephbrumaghim.jlang.IndexHolder;

public class If extends Keyword {
	
	private Object o1;
	private String modifier;
	private Object o2;
	private String block2;
	
	
	public If(Execution exec) {
		super(exec, 3, true);
	}

	@Override
	public void load(Object[] args) {

	}
	
	@Override
	public void load(Object[] args, String block) {
		o1 = args[0];
		modifier = (String) args[1];
		o2 = args[2];
		this.block2 = block;
	}

	@Override
	public Object execute() {
		
		//All of these must convert numbers
		if(modifier.equals(">") || modifier.equals("<") || modifier.equals(">=") || modifier.equals("<=") ) {
			//Must convert to Number
			Integer num1 = convertNumber(o1);
			Integer num2 = convertNumber(o2);
			if(modifier.equals("<")) {
				if(num1 < num2) {
					return run();
				}
			} else if(modifier.equals(">")) {
				if(num1 > num2) {
					return run();
				}
			} else if(modifier.equals(">=")) {
				if(num1 >= num2) {
					return run();
				}
			} else if(modifier.equals("<=")) {
				if(num1 <= num2) {
					return run();
				}
			}
		} else if(modifier.equals("==")) {
			//Both null case handle and objectId lookup
			if(o1 == o2) {
				return run();
			} else if(o1 == null) {
				return null;
			} else if(o1.equals(o2)) {
				return run();
			}
		} else if(modifier.equals("!=")) {
			if(o1 != o2) {
				return run();
			} else if(o1 != null) {
				return null;
			} else if(!o1.equals(o2)) {
				return run();
			}
		}
		return null;
//			
//
//		
//		if(o1 == null && o2 == null) {
//			String[] words = block2.split(" ");
//			return exec.execute(words[0], words, new IndexHolder(), null);
//		}
//		if(o1 == null) {return null;}
//		if(o1.equals(o2)) {
//			String[] words = block2.split(" ");
//			return exec.execute(words[0], words, new IndexHolder(), null);
//		}
//		return null;
//		//return o1.equals(o2);
	}
	
	public Object run() {
		String[] words = block2.split(" ");
		return exec.execute(words[0], words, new IndexHolder(), null);
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
