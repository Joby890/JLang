package com.josephbrumaghim.jlang.keywords;

import com.josephbrumaghim.jlang.Execution;

public class Sleep extends Keyword {
	
	private int time;

	public Sleep(Execution exec) {
		super(exec, 1);
	}

	@Override
	public void load(Object[] args) {
		this.time = (int) args[0];

	}

	@Override
	public Object execute() {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Failled to sleep");
			e.printStackTrace();
		}
		return null;
	}

}
