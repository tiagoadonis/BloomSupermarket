package tests;
import bloomSupermarket.*;
import modulos.*;
import java.util.*;

public class MHTest {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Modulo de teste de MinHashing - Produtos\n");
		List<Produto> listProds = new ArrayList<Produto>();
		List<MinHashing> listProdsHash = new ArrayList<MinHashing>();
		
		for (int i = 0; i < 5; i++) {
			Produto tmp = Produto.getRandProduto();
			listProds.add(tmp);
			listProdsHash.add(new MinHashing(tmp.transform(), 100));
			tmp.print();
		}
		System.out.println();
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++) {
				System.out.printf("Distancia entre %s e %s: %1.2f\n", 
								  listProds.get(i).getNome(), listProds.get(j).getNome(),1 - MinHashing.getSimilarity(listProdsHash.get(i), listProdsHash.get(j)));
			}
		}
		
		System.out.println("\nEste modulo demonstra a criação de 5 produtos aleatoriamente e a sua comparação através de minHashing (100 Hashes)");
	}
}
