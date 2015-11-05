package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;
import com.josephbrumaghim.jlang.IndexHolder;

public class IfNot extends Keyword {
	
	private Object o1;
	private Object o2;
	private String block2;
	
	
	public IfNot(Execution exec) {
		super(exec, 2, true);
	}

	@Override
	public void load(Object[] args) {

	}
	
	@Override
	public void load(Object[] args, String block) {
		o1 = args[0];
		o2 = args[1];
		this.block2 = block;
	}

	@Override
	public Object execute() {
		if(o1 == null && o2 == null) {
			return false;
		}
		if(!o1.equals(o2)) {
			String[] words = block2.split(" ");
			return exec.execute(words[0], words, new IndexHolder(), null);
		}
		return null;
		//return o1.equals(o2);
	}

}
