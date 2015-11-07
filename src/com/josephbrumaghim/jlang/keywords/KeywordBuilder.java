package com.josephbrumaghim.jlang.keywords;

import java.util.List;

import com.josephbrumaghim.jlang.Execution;

public class KeywordBuilder extends Keyword {

	private List<String> lines;
	private String[] args;
	private Execution newExec;

	public KeywordBuilder(Execution exec, int argsLength) {
		super(exec, 0);
		 newExec = new Execution(exec);
	}

	@Override
	public void load(Object[] as) {
		for(int x = 0; x < as.length; x++) {
			newExec.pointers.put(args[x], as[x]);
		}
	}
	
	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	@Override
	public Object execute() {
		System.out.println("Executing");
		Object result = null;
		
		for(int x = 0; x < lines.size(); x++) {
			Object o = newExec.executeLine(lines.get(x));
			if(lines.size() == 1) {
				result = o;
			} else if(o != null) {
				result = o;
			}

		}
		newExec = new Execution(exec);
		return result;
		
	}

	public void setArguments(String[] args) {
		this.argsLength = args.length;
		this.args = args;
	}

}
