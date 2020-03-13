package dev.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// a utility class that holds methods that will help us
public class Utils {

	// this method takes a path of an archive and read every line adding to the
	// string builder
	// at the end it will return the string builder variable
	public static String loadFileAsString(String path) {
		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	// this method will take a string representing a number and convert it to
	// integer
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
