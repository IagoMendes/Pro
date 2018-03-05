package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	boolean[][] isWall;

	void loadFromFile(String path) {
		
		//When using try and catch, the code tries to run "try", if it fails, uses "catch" to treat error
		try {
			//Builds object to make FileReader able to read lines
			BufferedReader reader = new BufferedReader(new FileReader(path));

			//Returns file's first line 
			String line = reader.readLine();

			//Breaks line in blank space and returns two strings, both with numbers	
			String[] words = line.split(" ");

			//Each string is converted to a int number
			int numRows = Integer.parseInt(words[0]);
			int numCols = Integer.parseInt(words[1]);

			//Uses numbers to build the array "isWall" 
			isWall = new boolean[numRows][numCols];

			//Reads each line in the file (except for the first one, already read)
			for(int i = 0; i < numRows; i++) {
				line = reader.readLine();

				//Reads each character in each line
				for(int j = 0; j < numCols; j++) {
					boolean value;
					
					if(line.charAt(j) == '#') {
						value = true;
					}
					else {
						value = false;
					}
					isWall[i][j] = value;
				}
			}
			//Closes reader
			reader.close();
		}
		//Catches bellow treat each error in its way
		catch(FileNotFoundException exception) {
			System.out.println(exception);
		}
		catch(IOException exception) {
			System.out.println(exception);
		}
	}
}
