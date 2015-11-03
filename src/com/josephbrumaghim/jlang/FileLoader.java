package com.josephbrumaghim.jlang;

import java.io.File;

public class FileLoader {

	public File loadFile(String name) {
		return new File(name + ".joby");
	}
	
	
}
