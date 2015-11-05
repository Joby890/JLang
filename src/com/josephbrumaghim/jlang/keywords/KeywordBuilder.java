package com.josephbrumaghim.jlang.keywords;

import java.util.List;

import com.josephbrumaghim.jlang.Execution;

public class KeywordBuilder extends Keyword {

	private List<String> lines;

	public KeywordBuilder(Execution exec, int argsLength) {
		super(exec, 0);
	}

	@Override
	public void load(Object[] args) {
		
	}
	
	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	@Override
	public Object execute() {
		Object result = null;
		Execution newExec = new Execution(exec);
		for(int x = 0; x < lines.size(); x++) {
			Object o = newExec.executeLine(lines.get(x));
			if(lines.size() == 1) {
				result = o;
			} else if(o != null) {
				result = o;
			}

		}
		return result;
		
	}

}
