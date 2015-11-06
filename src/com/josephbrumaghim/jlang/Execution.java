package com.josephbrumaghim.jlang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.josephbrumaghim.jlang.keywords.Add;
import com.josephbrumaghim.jlang.keywords.Div;
import com.josephbrumaghim.jlang.keywords.GetPointer;
import com.josephbrumaghim.jlang.keywords.If;
import com.josephbrumaghim.jlang.keywords.Keyword;
import com.josephbrumaghim.jlang.keywords.KeywordBuilder;
import com.josephbrumaghim.jlang.keywords.Mul;
import com.josephbrumaghim.jlang.keywords.Print;
import com.josephbrumaghim.jlang.keywords.SetPointer;
import com.josephbrumaghim.jlang.keywords.Sub;

public class Execution {
	
	public Map<String, Object> pointers = new HashMap<>();
	public Map<String, Keyword> keywords = new HashMap<>();
	
	public Execution prev;
	
	
	public Execution(Execution prev) {
		keywords.put("getPointer", new GetPointer(this));
		keywords.put("setPointer", new SetPointer(this));
		keywords.put("print", new Print(this));
		keywords.put("if", new If(this));
		
		//Simple Math
		keywords.put("add", new Add(this));
		keywords.put("sub", new Sub(this));
		keywords.put("mul", new Mul(this));
		keywords.put("div", new Div(this));
		
		
		this.prev = prev;
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
		if(words.length > 0) {
			String word = words[0];
			return execute(word, words, new IndexHolder(), block);
		}
		return null;
	}
	
	public Keyword findKeyword(String name) {
		Execution current = this;
		while(current != null) {
			if(current.keywords.containsKey(name)) {
				return current.keywords.get(name);
			} else {
				current = current.prev;
			}
		}
		return null;
	}
	
	public Object execute(String current, String[] words, IndexHolder index, String block) {
		//System.out.println("Executing on " + current + " with " + Arrays.asList(words) + " on " + index.index + " index");
		Keyword key = findKeyword(current);
		if(key != null) {
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
	
	
	//Load file into lines
	public String[] loadFile(File f) {
		List<String> lines = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			while(br.ready()) {
				lines.add(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines.toArray(new String[lines.size()]);
	}
	
	public void loadModules(String[] lines) {
		for(int x = 0; x < lines.length; x++) {
			String[] words = lines[x].split(" ");
			List<String> module = new ArrayList<>();
			if(words[0].equals("module")) {
				String name = words[1];
				//Get Arguments
				String temp = "";
				String[] modified = Arrays.copyOfRange(lines[x].split(" "), 2, lines[x].length());
				for(String tem : modified) {
					temp += tem + " ";
				}
				lines[x] = temp;
				List<Integer> used = new ArrayList<>();
				boolean found = false;
				for(int y = x; y < lines.length; y++) {
					String newLine = "";
					String[] wordss = lines[y].split(" "); 
					if(!found) {
						used.add(y);
						for(int l = 0; l < wordss.length; l++) {
							String word = wordss[l];
							if(word.trim().equals("null")) {
								
							} else if(word.equals("endmodule")) {
								found = true;
								break;
							} else if(word.equals("module")) {
								
							} else {
								newLine += word.trim() + " ";
							}
						}
					}

					if(newLine.length() >= 1) {
						module.add(newLine);
					}
 					
					
				}
				for(int in : used) {
					lines[in] = "";
				}
				KeywordBuilder kw = new KeywordBuilder(this, 0);
				System.out.println(module);
				kw.setLines(module);
				keywords.put(name, kw);
			}
			
		}
	}	
	public void executeFile(File f) {
		String[] lines = loadFile(f);
		loadModules(lines);
		for(String line : lines) {
			executeLine(line);
		}
	}
}

