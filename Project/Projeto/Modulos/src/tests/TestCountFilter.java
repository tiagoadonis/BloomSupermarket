package tests;

import modulos.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
@SuppressWarnings("unused")

public class TestCountFilter {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {
		System.out.println("Modulo de teste de CountFilter - Os Maias");
		System.out.println("Irá ser imprimido o número total de vezes que cada palavra "
							+ "aparece ao longo dos excertos do livro \"Os Maias\"");
		
		List<String> lines = new ArrayList<String>();
		
		System.out.println();
		File f = new File("maias.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			String line;
			while((line = bf.readLine()) != null) {
				lines.add(line);
			}
			bf.close();
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		CountFilter<Word> wordCounter = new CountFilter<Word>(2000);
		List<Word> text = new ArrayList<Word>();
		for (String line : lines) {
			String[] words = line.split(" ");
			for (String word : words) {
				word = word.replace(".", "");
				word = word.replace(",", "");
				word = word.replace("!", "");
				word = word.replace(";", "");
				word = word.replace(":", "");
				word = word.replace("?", "");
				if (word.equals("")) {
					continue;
				}
				Word tmp = new Word(word);
				if (!wordCounter.isMember(tmp)) {
					text.add(tmp);
				}
				wordCounter.insert(tmp);
			}
		}
		
		for (Word n : text) {
			System.out.println(n + " - " + wordCounter.count(n));
		}
	}
}
