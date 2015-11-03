package com.josephbrumaghim.jlang;

import java.util.HashMap;
import java.util.Map;

import com.josephbrumaghim.jlang.keywords.Add;
import com.josephbrumaghim.jlang.keywords.Div;
import com.josephbrumaghim.jlang.keywords.GetPointer;
import com.josephbrumaghim.jlang.keywords.If;
import com.josephbrumaghim.jlang.keywords.Keyword;
import com.josephbrumaghim.jlang.keywords.Mul;
import com.josephbrumaghim.jlang.keywords.Print;
import com.josephbrumaghim.jlang.keywords.SetPointer;
import com.josephbrumaghim.jlang.keywords.Sub;

public class Execution {
	
	public static Map<String, Object> pointers = new HashMap<>();
	public static Map<String, Keyword> keywords = new HashMap<>();
	
	
	static {
		keywords.put("getPointer", new GetPointer());
		keywords.put("setPointer", new SetPointer());
		keywords.put("print", new Print());
		keywords.put("if", new If());
		
		//Simple Math
		keywords.put("add", new Add());
		keywords.put("sub", new Sub());
		keywords.put("mul", new Mul());
		keywords.put("div", new Div());
	}
	
	
	public Object executeLine(String line) {
		//Right now only one block per line.
		String block = "";
		if(line.contains("[") && line.contains("]")) {
			int startX = line.indexOf('[');
			int startY = line.indexOf(']');
			for(int x = startX + 1; x < startY; x++) {
				block += line.charAt(x);
			}
		}
		String[] words = line.split(" ");
		String word = words[0];
		execute(word, words, new IndexHolder(), block);
//			if(keywords.containsKey(word)) {
//				Keyword key = keywords.get(word);
//				key.load(words[++i]);
//				System.out.println(key.execute());
//				
		
		return null;
	}
	//"print getPointer name";
	public static Object execute(String current, String[] words, IndexHolder index, String block) {
		//System.out.println("Executing on " + current + " with " + Arrays.asList(words) + " on " + index.index + " index");
		if(keywords.containsKey(current)) {
			Keyword key = keywords.get(current);
			if(words.length - index.index - key.argsLength > 0) {
				Object[] args = new Object[key.argsLength];
				for(int x = 0; x < key.argsLength; x++) {
					Object o = execute(words[++index.index], words, index, block);
					args[x] = o;
				}
				if(key.block) {
					key.load(args, block);
				} else {
					key.load(args);
				}
				
				return key.execute();
				
				
			} else {
				System.out.println("Error not enough args in command");
			}
		} else {
			return current;
		}
		return null;
	}
	

	
}

