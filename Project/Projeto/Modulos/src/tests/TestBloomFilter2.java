package tests;

import modulos.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
@SuppressWarnings("unused")

public class TestBloomFilter2 {

static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		System.out.println("Modulo de teste de BloomFilter - Os Maias");
		
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
		
		BloomFilter<Word> texto = new BloomFilter<Word>(2000);
		for (String line : lines) {
			String[] words = line.split(" ");
			for(String word : words) {
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
				if (!texto.isMember(tmp)) {
					texto.insert(tmp);
				}
			}
		}
		
		System.out.println("Foram extraídos vários excertos do livro \"Os Maias\" de Eça de Queirós");
		System.out.println("O texto tem um total de 1991 palavras e está escrito em minúsculas");
		System.out.println("Tente adivinhar uma palavra que pertenca aos excertos retirados");
		
		while (true) {
			System.out.print("Palavra (\"fim\" para acabar teste): ");
			String word = sc.nextLine();
			if (word.equals("fim")) {
				System.out.println("Teste Terminado");
				break;
			}
			if (texto.isMember(new Word(word.toLowerCase()))) {
				System.out.println(word + " pertence aos excertos!"); 
				
			}
			else {
				System.out.println(word + " não pertence aos excertos!");
			}
		}
	}
}
