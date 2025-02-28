package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.util.Arrays;

import java.io.*;
import java.util.*;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FrequencyTable ft = new FrequencyTable();

		Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\potom\\IdeaProjects\\Zadania\\zadanie7\\subor"));
			while (sc.hasNext())
				ft.addOccurrence(sc.next());
		} catch (FileNotFoundException e) {
			System.err.println("Subor neexistuje.");
		} finally {
			if (sc != null)
				sc.close();
		}

		System.out.println("Pocet roznych precitanych slov: " + ft.getWordCount());

		// Vypis po slovach
		String[] words = ft.getWords();
		System.out.println("Vyskyty slov: ");
		for (int i = 0; i < words.length; i++)
			System.out.println(words[i] + ": " + ft.getNumberOfOccurrences(words[i]));

		// test "hacknutia" objektu
		for (int i = 0; i < words.length; i++) {
			words[i] = "???";
		}

		// Vypis cez toString
		System.out.println("Vyskyty slov inak: " + ft.toString());
	}

}