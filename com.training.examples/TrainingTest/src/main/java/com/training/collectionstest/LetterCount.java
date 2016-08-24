package com.training.collectionstest;

import java.util.Map;

import org.apache.log4j.Logger;

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
	private static org.apache.log4j.Logger log = Logger.getLogger(LetterCount.class);

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
		log.info("Count successful");
		System.out.println(numChars);
	}

}
