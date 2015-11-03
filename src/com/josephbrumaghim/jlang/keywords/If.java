package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;
import com.josephbrumaghim.jlang.IndexHolder;

public class If extends Keyword {
	
	private Object o1;
	private Object o2;
	private String block2;
	
	
	public If() {
		super(2, true);
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
		if(o1.equals(o2)) {
			String[] words = block2.split(" ");
			Execution.execute(words[0], words, new IndexHolder(), null);
		}
		return o1.equals(o2);
	}

}
