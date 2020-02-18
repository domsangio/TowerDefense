package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			
			while((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}
			
			br.close();
			return builder.toString();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static int parseString(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
