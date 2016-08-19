package com.training.collectionstest;

import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * This class has a main method that displays the letters in the given input
 * string and displays the number of times each letter has occurred
 * 
 * @author Ponmalar
 *
 */
public class LetterCount {

	public static void main(String args[]) throws IOException {

		String input = null;
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		System.out.println("Enther a string");
		input = br.readLine();
		int len = input.length();
		Map<Character, Integer> numChars = new HashMap<Character, Integer>(Math.min(len, 26));

		for (int i = 0; i < len; ++i) {
			char charAt = input.charAt(i);

			if (!numChars.containsKey(charAt)) {
				numChars.put(charAt, 1);
			} else {
				numChars.put(charAt, numChars.get(charAt) + 1);
			}
		}

		System.out.println(numChars);
	}

}
