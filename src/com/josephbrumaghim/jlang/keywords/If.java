package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;
import com.josephbrumaghim.jlang.IndexHolder;

public class If extends Keyword {
	
	private Object o1;
	private String modifier;
	private Object o2;
	private String truthy;
	private String falsey;
	
	
	public If(Execution exec) {
		super(exec, 3, true);
	}

	@Override
	public void load(Object[] args) {

	}
	
	@Override
	public void load(Object[] args, String[] blocks) {
		o1 = args[0];
		modifier = (String) args[1];
		o2 = args[2];
		this.truthy = blocks[0];
		if(blocks.length > 1) {
			this.falsey = blocks[1];
		}
	}

	@Override
	public Object execute() {
		return run(check());
	}
	
	
	public boolean check() {
		
		//All of these must convert numbers
		if(modifier.equals(">") || modifier.equals("<") || modifier.equals(">=") || modifier.equals("<=") ) {
			//Must convert to Number
			Integer num1 = convertNumber(o1);
			Integer num2 = convertNumber(o2);
			if(modifier.equals("<")) {
				if(num1 < num2) {
					return true;
				} else {
					return false;
				}
			} else if(modifier.equals(">")) {
				if(num1 > num2) {
					return true;
				} else {
					return false;
				}
			} else if(modifier.equals(">=")) {
				if(num1 >= num2) {
					return true;
				} else {
					return false;
				}
			} else if(modifier.equals("<=")) {
				if(num1 <= num2) {
					return true;
				} else {
					return false;
				}
			}
		} else if(modifier.equals("==")) {
			//Both null case handle and objectId lookup
			if(o1 == o2) {
				return true;
			} else if(o1 == null) {
				return false;
			} else if(o1.equals(o2)) {
				return true;
			} else {
				run(false);
			}
		} else if(modifier.equals("!=")) {
			if(o1 == o2) {
				return false;
			} else if(o1 == null) {
				return true;
			} else if(!o1.equals(o2)) {
				return false;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public Object run(boolean t) {
		String[] words;
		if(t) {
			words = truthy.split(" ");
		} else {
			if(falsey != null) {
				words = falsey.split(" ");
			} else {
				words = new String[0];
			}
		}
		if(words.length == 0) {
			return null;
		}
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
