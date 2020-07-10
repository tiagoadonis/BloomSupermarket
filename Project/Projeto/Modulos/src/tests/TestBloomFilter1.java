package tests;
import modulos.*;
import java.util.*; 

public class TestBloomFilter1 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Modulo de teste de BloomFilter - Capitais de Distrito de Portugal Continental\n");
		String[] capitais = {"Viana do Castelo", "Braga", "Vila Real", "Bragan�a", "Porto", "Aveiro", "Viseu", "Guarda",
						   "Coimbra", "Castelo Branco", "Leiria", "Santar�m", "Portalegre", "Lisboa", "�vora", "Set�bal", 
						   "Beja", "Faro"};
		
		BloomFilter<Cidade> distritos = new BloomFilter<Cidade>(capitais.length);
		
		for (int i = 0; i < capitais.length; i++) {
			Cidade toInsert = new Cidade(capitais[i]);
			distritos.insert(toInsert);
		}
		
		System.out.println("Insira um nome de uma cidade para saber se � capital de um distrito de Portugal");
		while (true) {
			System.out.print("Cidade (\"fim\" para acabar teste) : ");
			String cidade = sc.nextLine();
			if (cidade.equals("fim")) {
				System.out.println("Teste Terminado"); 
				break;
			}
			if (distritos.isMember(new Cidade(cidade))) {
				System.out.println(cidade + " � uma capital de distrito!");
			}
			else {
				System.out.println(cidade + " n�o � capital de distrito!");
			}
		}
	}
}