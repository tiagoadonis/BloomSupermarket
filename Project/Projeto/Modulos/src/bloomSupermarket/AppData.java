package bloomSupermarket;

import java.util.*;
import modulos.*;
import static java.lang.System.*;
@SuppressWarnings("unused")

public class AppData{
	static Scanner sc = new Scanner(System.in);
	public List<Produto> listProdutos;
	public List<Utilizador> listUsers;
	public BloomFilter<Utilizador> users;
	public BloomFilter<Utilizador> admins;
	public Utilizador currentUser;
	public CountFilter<Produto> inventory;
	private int numMaxUsers;
	private int numMaxProdutos;
	private static AppData current;
    
	public AppData(int numMaxUsers, int numMaxProdutos) {
		listProdutos = new ArrayList<Produto>();
		listUsers = new ArrayList<Utilizador>();
		users = new BloomFilter<Utilizador>(numMaxUsers);
		admins = new BloomFilter<Utilizador>(10);
		inventory = new CountFilter<Produto>(numMaxProdutos);
		this.numMaxProdutos = numMaxProdutos;
		this.numMaxUsers = numMaxUsers;
		current = this;
	}
	    
	public void setCurrentUser(String email) {
		for (Utilizador user : listUsers) {
			if (user.getEmail().equals(email)) {
				this.currentUser = user;
				break;
			}
		}
	}
	    
	public static AppData getInstance() {
		return current;
	}
	
	public Utilizador getCurrentUser() {
		return currentUser;
	}
	
	public void listProducts() {
		int i = 1;
		for (Produto a : listProdutos) {
			System.out.printf("%4d - ", i++);
			a.print();
		}
	}
		
	public void listSimilarProducts() {
		List<Produto> favProdutos = currentUser.getListFavProds();
		for (Produto favProduto : favProdutos) {
			Lista<Comparisson> simProdutos = new Lista<Comparisson>();
			for (Produto otherProduto : listProdutos) {
				if (favProduto.equals(otherProduto)) continue;
				double distance = 1 - Produto.intersect(favProduto, otherProduto)/Produto.union();
				Comparisson comp = new Comparisson(favProduto, otherProduto, distance);
				simProdutos.add(comp);
			}
			System.out.println("Porque gosta de " + favProduto + " sugerimos:");
			for (int i = 0; i < 3; i++) {
				Produto prod = simProdutos.get(i).getSimProd();
				prod.print();
			}
			System.out.println();
		}
	}
	
	public int addProdToFav() {
		System.out.print("Insira o nome do Produto: ");
		String nome = sc.nextLine();
		for (Produto prod : listProdutos) {
			if (prod.getNome().equals(nome)) {
				System.out.println(currentUser.addFavProd(prod));
				return 0;
			}
		}
		System.out.println("Produto não encontrado");
		return 1;
	}
	
	public void buyProd() {
		List<Produto> favProds = currentUser.getListFavProds();
		int i = 1;
		for (Produto prod : favProds) {
			System.out.print("Disponibilidade: " + inventory.count(prod) + " - " + i++ + " - ");
			prod.print();
		}
		System.out.println("Voltar atras - 0");
		System.out.print("Escolha o produto que quer comprar: ");
		int prodIndex = Integer.parseInt(sc.nextLine()) - 1;
		if (prodIndex >= 0) {
			Produto prod = favProds.get(prodIndex);
			currentUser.buyProd(prod);
			inventory.delete(prod);
		}
		else {
			System.out.println("Não temos esse produto em stock!!");
		}
	}
	
	public void fill(int newProducts, int newUsers) {
		main_for:
		for(int i = 0; i < newProducts; i++) {
			Produto aux = Produto.getRandProduto();
			for(Produto prod : listProdutos) {
				if (prod.getNome().equals(aux.getNome())) {
					continue main_for;
				}
			}
			listProdutos.add(aux);
			int rand = (int)Math.round(Math.random() * 2 + 1);
			for (int j = 0; j < rand; j++) {
				inventory.insert(aux);
			}
		}
		
		for (int i = 0; i < newUsers; i++) {
			Utilizador aux = Utilizador.getRandUtilizador();
			int numFavProdutos = (int)Math.round(Math.random()*newProducts/100) + 2;
			for (int j = 0; j < numFavProdutos; j++) {
				aux.addFavProd(listProdutos.get((int)Math.random()*listProdutos.size()));
			}
			listUsers.add(aux);
			users.insert(aux);
		}
	
		Utilizador administrator1 = new Utilizador("Tiago", "tiago.adonis@ua.pt", "12345", "Guarda", 19);
		listUsers.add(administrator1);
		users.insert(administrator1);
		admins.insert(administrator1);
		for (int j = 0; j < 5; j++) {
			administrator1.addFavProd(listProdutos.get((int)(Math.random()*listProdutos.size())));
		}	
		
		Utilizador administrator2 = new Utilizador("Bruno", "bruno25@ua.pt", "12346", "Viseu", 19);
		listUsers.add(administrator2);
		users.insert(administrator2);
		admins.insert(administrator2);
		for (int j = 0; j < 5; j++) {
			administrator2.addFavProd(listProdutos.get((int)(Math.random()*listProdutos.size())));
		}	
		
		Utilizador profPrat = new Utilizador("Antonio", "ajst@ua.pt", "EprecisoTrabalhar", "Aveiro", 20);
		listUsers.add(profPrat);
		users.insert(profPrat);
		admins.insert(profPrat);
		for (int j = 0; j < 5; j++) {
			profPrat.addFavProd(listProdutos.get((int)(Math.random()*listProdutos.size())));
		}
	}
	    
	public void listUsers() {
		System.out.println("Lista de Utilizadores: ");
		for (Utilizador user : listUsers) {
			System.out.println(user);
		}
	}
	
	public void addRandProd() {
		System.out.print("Quantos Produtos pretende adiconar?: ");
		int numProdToAdd = Integer.parseInt(sc.nextLine());
		main_for:
		for (int i = 0; i < numProdToAdd; i++) {
			Produto aux = Produto.getRandProduto();
			for (Produto prod : listProdutos) {
				if (prod.getNome().equals(aux.getNome())) {
					continue main_for;
				}
			}
			listProdutos.add(aux);
			inventory.insert(aux);
		}
	}
	
	public void fillStock() {
		for (Produto prod : listProdutos) {
			if (inventory.count(prod) == 0) {
				int rand = (int)Math.round(Math.random()*2) + 1;
				for (int i = 0; i < rand; i++) {
					inventory.insert(prod);
				}
			}
		}
	}
	
	public void reset() {
		listProdutos = new ArrayList<Produto>();
		listUsers = new ArrayList<Utilizador>();
		users = new BloomFilter<Utilizador>(numMaxUsers);
		inventory = new CountFilter<Produto>(numMaxProdutos);
	}
}
