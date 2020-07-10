package bloomSupermarket;

import java.util.*;
import modulos.*;
@SuppressWarnings("unused")

public class Produto implements Hashable {
	static Scanner sc = new Scanner(System.in);
	public String nome;
	public int calorias;
	public int proteinas;
	public int acucar;
	public int lipidosSaturados;
	public int lipidosMonoinsaturados;
	public int lipidosPoliinsaturados;	
	public int colesterol;
	public int fibras;
	public int sodio;
	public int potassio;
	public int peso;
	public int preco;
	public static int union = 13;
	public static String carnes[] = {"Frango", "Porco", "Peru", "Vaca", "Pato", "Codorniz", "Coelho", "Borrego", "Cabrito"};
	public static String peixes[] = {"Robalo", "Dourada", "Salmão", "Pescada", "Cherne", "Corvina", "Carapau", "Bacalhau", "Sardinha"};
	public static String legume[] = {"Couve", "Agrião", "Batatas", "Cebola", "Alho", "Abóbora", "Cenoura", "Curgete", "Nabo"};
	public static String frutas[] = {"Pêra", "Maça", "Melão", "Uvas", "Bananas", "Pêssego", "Laranja", "Manga", "Papaia"};
	public static String mercearia[] = {"Arroz", "Massa", "Farinha", "Feijão", "Grão", "Açúcar", "Chá", "Café", "Sal"};
	public static String padaria[] = {"Baguete", "Cacetinho", "Saloio", "Chapata", "Bijou"};
	
	public static enum Variedade{
		Carne, Peixe, Legume, Fruta, Mercearia, Padaria;
		
		public static Variedade getRandVariedade() {
			double rand = Math.random();
			if(rand < 0.165) {
				return Carne;
			}
			else if(rand < 0.33) {
				return Peixe;
			}
			else if (rand < 0.495) {
				return Legume;
			}
			else if (rand < 0.66) {
				return Fruta;
			}
			else if (rand < 0.825) {
				return Mercearia;
			}
			else {
				return Padaria;
			}
		}
	}
	
	public Produto(String nome, int calorias, int proteinas, int acucar, int lipidosSaturados, int lipidosMonoinsaturados,
			   int lipidosPoliinsaturados, int colesterol, int fibras, int sodio, int potassio, int peso, int preco) {
		
		boolean aux = false;
		
		do {
			int none = 0;
			aux = false;
			for (String a : carnes) {
				if (a.equals(nome)){
					this.nome = nome;
					System.out.print("Produto introduzido!!");
				}
				else {
					none++;
				}
			}
			for (String b : peixes) {
				if (b.equals(nome)) {
					this.nome = nome;
					System.out.print("Produto introduzido!!");
				}
				else {
					none++;
				}
			}
			for (String c : legume) {
				if(c.equals(nome)) {
					this.nome = nome;
					System.out.print("Produto introduzido!!");
				}
				else {
					none++;
				}
			}
			for (String d : frutas) {
				if (d.equals(nome)) {
					this.nome = nome;
					System.out.print("Produto introduzido!!");
				}
				else {
					none++;
				}
			}
			for (String e : mercearia) {
				if (e.equals(nome)) {
					this.nome = nome;
					System.out.print("Produto introduzido!!");
				}
				else {
					none++;
				}
			}
			for (String f : padaria) {
				if (f.equals(nome)) {
					this.nome = nome;
					System.out.print("Produto introduzido!!");
				}
				else {
					none++;
				}
			}
		
			if (none == 50) {
				System.out.println("O produto introduzido não se encontra na nossa base de dados!!");
				aux = true;
			}
		}while(aux == true);
		
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.acucar = acucar;
		this.lipidosSaturados = lipidosSaturados;
		this.lipidosMonoinsaturados = lipidosMonoinsaturados;
		this.lipidosPoliinsaturados = lipidosPoliinsaturados;
		this.colesterol = colesterol;
		this.fibras = fibras;
		this.sodio = sodio;
		this.potassio = potassio;
		this.peso = peso;
		this.preco = preco;
	}
	
	public static Produto getRandProduto(){
		Variedade var = Variedade.getRandVariedade();
		String nome = "";
		int calorias = 0, proteinas = 0, acucar = 0, lipidosSaturados = 0, lipidosMonoinsaturados = 0, lipidosPoliinsaturados = 0,
				colesterol = 0, fibras = 0, sodio = 0, potassio = 0, peso = 0, preco = 0;
		switch(var) {
		case Carne:
			double rand1 = Math.random();
			if (rand1 < 1/carnes.length) {
				nome = carnes[0];
				calorias = 2000 + (int)Math.round(Math.random()*50);
				proteinas = 200 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 20 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 30 + (int)Math.round(Math.random()*3);
				lipidosPoliinsaturados = 10 + (int)Math.round(Math.random()*2);
				colesterol = 10 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 10 + (int)Math.round(Math.random()*2);
				potassio = 10 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco = 2 + (int)Math.round(Math.random()*4);
			}
			else if (rand1 < 2*(1/carnes.length)) {
				nome = carnes[1];
				calorias = 250 +(int)Math.round(Math.random()*100) ;
				proteinas = 20 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 4 + (int)Math.round(Math.random()*5);
				lipidosMonoinsaturados = 5 + (int)Math.round(Math.random()*5);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*20);
				peso = 100;
				preco =  1 +(int)Math.round(Math.random()*3);
			}
			else if (rand1 < 3*(1/carnes.length)) {
				nome = carnes[2];
				calorias = 100 + (int)Math.round(Math.random()*50);
				proteinas = 20 + (int)Math.round(Math.random()*5);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 100;
				preco =  2 + (int)Math.round(Math.random()*2);
			}
			else if (rand1 < 4*(1/carnes.length)) {
				nome = carnes[3];
				calorias = 250 + (int)Math.round(Math.random()*50);
				proteinas = 20 + (int)Math.round(Math.random()*10);
				acucar = 0;
				lipidosSaturados = 5 + (int)Math.round(Math.random()*5);
				lipidosMonoinsaturados = 4 + (int)Math.round(Math.random()*4);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 100;
				preco =  4 +(int)Math.round(Math.random()*3) ;
			}
			else if (rand1 < 5*(1/carnes.length)) {
				nome = carnes[4];
				calorias = 2500 + (int)Math.round(Math.random()*50);
				proteinas = 340 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 35 + (int)Math.round(Math.random()*5);
				lipidosMonoinsaturados = 20 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 18 + (int)Math.round(Math.random()*2);
				colesterol = 17 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 15 + (int)Math.round(Math.random()*2);
				potassio = 10 + (int)Math.round(Math.random()*2);
				peso = 2000;
				preco =  4 + (int)Math.round(Math.random()*3);
			}
			else if (rand1 < 6*(1/carnes.length)) {
				nome = carnes[5];
				calorias = 150 + (int)Math.round(Math.random()*30);
				proteinas = 15 + (int)Math.round(Math.random()*5);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 3 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 2 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 40;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand1 < 7*(1/carnes.length)) {
				nome = carnes[6];
				calorias = 1800 + (int)Math.round(Math.random()*100);
				proteinas = 250 + (int)Math.round(Math.random()*50);
				acucar = 0;
				lipidosSaturados = 15 + (int)Math.round(Math.random()*5);
				lipidosMonoinsaturados = 18 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 10 + (int)Math.round(Math.random()*5);
				colesterol = 6 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 2 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  5 + (int)Math.round(Math.random()*3);
			}
			else if (rand1 < 8*(1/carnes.length)) {
				nome = carnes[7];
				calorias = 8000 + (int)Math.round(Math.random()*50);
				proteinas = 1240 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 150 + (int)Math.round(Math.random()*10);
				lipidosMonoinsaturados = 140 + (int)Math.round(Math.random()*10);
				lipidosPoliinsaturados = 32 + (int)Math.round(Math.random()*5);
				colesterol = 5 + (int)Math.round(Math.random()*3);
				fibras = 0;
				sodio = 2 + (int)Math.round(Math.random()*3);
				potassio = 2 + (int)Math.round(Math.random()*5);
				peso = 5000;
				preco =  30 + (int)Math.round(Math.random()*10);
			}
			else {
				nome = carnes[8];
				calorias = 6900 + (int)Math.round(Math.random()*100);
				proteinas = 1200 + (int)Math.round(Math.random()*50);
				acucar = 0;
				lipidosSaturados = 35 + (int)Math.round(Math.random()*5);
				lipidosMonoinsaturados = 60 + (int)Math.round(Math.random()*3);
				lipidosPoliinsaturados = 5 + (int)Math.round(Math.random()*2);
				colesterol = 5 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 2 + (int)Math.round(Math.random()*2);
				potassio = 2 + (int)Math.round(Math.random()*2);
				peso = 5000 ;
				preco =  50 + (int)Math.round(Math.random()*10);
			}
			break;
		case Peixe:
			double rand2 = Math.random();
			if (rand2 < 1/peixes.length) {
				nome = peixes[0];
				calorias = 350 + (int)Math.round(Math.random()*40);
				proteinas = 70 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 2 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 2 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 400;
				preco = 2 + (int)Math.round(Math.random()*2);
			}
			else if (rand2 < 2*(1/peixes.length)) {
				nome = peixes[1];
				calorias = 400 +(int)Math.round(Math.random()*10) ;
				proteinas = 80 + (int)Math.round(Math.random()*15);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*3);
				peso = 475;
				preco =  2 +(int)Math.round(Math.random()*2);
			}
			else if (rand2 < 3*(1/peixes.length)) {
				nome = peixes[2];
				calorias = 200 + (int)Math.round(Math.random()*50);
				proteinas = 35 + (int)Math.round(Math.random()*10);
				acucar = 0;
				lipidosSaturados = 2 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 4 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 2 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 230;
				preco =  2 + (int)Math.round(Math.random()*2);
			}
			else if (rand2 < 4*(1/peixes.length)) {
				nome = peixes[3];
				calorias = 200 + (int)Math.round(Math.random()*50);
				proteinas = 35 + (int)Math.round(Math.random()*15);
				acucar = 0;
				lipidosSaturados = 2 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 250;
				preco =  2 +(int)Math.round(Math.random()*2) ;
			}
			else if (rand2 < 5*(1/peixes.length)) {
				nome = peixes[4];
				calorias = 350 + (int)Math.round(Math.random()*50);
				proteinas = 300 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 7 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 4 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 3 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 2 + (int)Math.round(Math.random()*2);
				potassio = 3 + (int)Math.round(Math.random()*2);
				peso = 525;
				preco =  17 + (int)Math.round(Math.random()*5);
			}
			else if (rand2 < 6*(1/peixes.length)) {
				nome = peixes[5];
				calorias = 470 + (int)Math.round(Math.random()*40);
				proteinas = 60 + (int)Math.round(Math.random()*10);
				acucar = 0;
				lipidosSaturados = 4 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 4 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 500;
				preco =  5 + (int)Math.round(Math.random()*3);
			}
			else if (rand2 < 7*(1/peixes.length)) {
				nome = peixes[6];
				calorias = 200 + (int)Math.round(Math.random()*10);
				proteinas = 35 + (int)Math.round(Math.random()*15);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 1 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 2 + (int)Math.round(Math.random()*2);
				peso = 230;
				preco =  1 + (int)Math.round(Math.random()*3);
			}
			else if (rand2 < 8*(1/peixes.length)) {
				nome = peixes[7];
				calorias = 820 + (int)Math.round(Math.random()*10);
				proteinas = 160 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 2 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 2 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 2 + (int)Math.round(Math.random()*2);
				colesterol = 2 + (int)Math.round(Math.random()*3);
				fibras = 0;
				sodio = 2 + (int)Math.round(Math.random()*3);
				potassio = 2 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  5 + (int)Math.round(Math.random()*3);
			}
			else {
				nome = peixes[8];
				calorias = 15 + (int)Math.round(Math.random()*5);
				proteinas = 2 + (int)Math.round(Math.random()*2);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 2 + (int)Math.round(Math.random()*2);
				fibras = 0;
				sodio = 2 + (int)Math.round(Math.random()*2);
				potassio = 2 + (int)Math.round(Math.random()*2);
				peso = 100 ;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			break;
		case Legume:
			double rand3 = Math.random();
			if (rand3 < 1/legume.length) {
				nome = legume[0];
				calorias = 240 + (int)Math.round(Math.random()*30);
				proteinas = 10 + (int)Math.round(Math.random()*2);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 20 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco = 1 + (int)Math.round(Math.random()*2);
			}
			else if (rand3 < 2*(1/legume.length)) {
				nome = legume[1];
				calorias = 35 +(int)Math.round(Math.random()*5) ;
				proteinas = 5 + (int)Math.round(Math.random()*3);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 6 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 150;
				preco =  1 +(int)Math.round(Math.random()*2);
			}
			else if (rand3 < 3*(1/legume.length)) {
				nome = legume[2];
				calorias = 1300 + (int)Math.round(Math.random()*30);
				proteinas = 35 + (int)Math.round(Math.random()*5);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 26 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand3 < 4*(1/legume.length)) {
				nome = legume[3];
				calorias = 90 + (int)Math.round(Math.random()*10);
				proteinas = 20 + (int)Math.round(Math.random()*5);
				acucar = 7 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 2 + (int)Math.round(Math.random()*3);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1500;
				preco =  1 +(int)Math.round(Math.random()*2) ;
			}
			else if (rand3 < 5*(1/legume.length)) {
				nome = legume[4];
				calorias = 880 + (int)Math.round(Math.random()*30);
				proteinas = 8 + (int)Math.round(Math.random()*2);
				acucar = 2 + (int)Math.round(Math.random()*2);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 1 + (int)Math.round(Math.random()*2);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  4 + (int)Math.round(Math.random()*2);
			}
			else if (rand3 < 6*(1/legume.length)) {
				nome = legume[5];
				calorias = 440 + (int)Math.round(Math.random()*20);
				proteinas = 9 + (int)Math.round(Math.random()*5);
				acucar = 25 + (int)Math.round(Math.random()*10);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 20 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand3 < 7*(1/legume.length)) {
				nome = legume[6];
				calorias = 400 + (int)Math.round(Math.random()*20);
				proteinas = 6 + (int)Math.round(Math.random()*4);
				acucar = 38 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 20 + (int)Math.round(Math.random()*8);
				sodio = 0;
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand3 < 8*(1/legume.length)) {
				nome = legume[7];
				calorias = 150 + (int)Math.round(Math.random()*20);
				proteinas = 8 + (int)Math.round(Math.random()*5);
				acucar = 13 + (int)Math.round(Math.random()*4);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 10 + (int)Math.round(Math.random()*3);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else {
				nome = legume[8];
				calorias = 250 + (int)Math.round(Math.random()*20);
				proteinas = 1 + (int)Math.round(Math.random()*2);
				acucar = 30 + (int)Math.round(Math.random()*2);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 18 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000 ;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			break;
		case Fruta:
			double rand4 = Math.random();
			if (rand4 < 1/frutas.length) {
				nome = frutas[0];
				calorias = 560 + (int)Math.round(Math.random()*30);
				proteinas = 3 + (int)Math.round(Math.random()*2);
				acucar = 90 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 2 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 38 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco = 1 + (int)Math.round(Math.random()*2);
			}
			else if (rand4 < 2*(1/frutas.length)) {
				nome = frutas[1];
				calorias = 350 +(int)Math.round(Math.random()*15) ;
				proteinas = 1 + (int)Math.round(Math.random()*3);
				acucar = 60 + (int)Math.round(Math.random()*10);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 13 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*3);
				peso = 1000;
				preco =  2 +(int)Math.round(Math.random()*2);
			}
			else if (rand4 < 3*(1/frutas.length)) {
				nome = frutas[2];
				calorias = 100 + (int)Math.round(Math.random()*20);
				proteinas = 3 + (int)Math.round(Math.random()*5);
				acucar = 20 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 2 + (int)Math.round(Math.random()*2);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand4 < 4*(1/frutas.length)) {
				nome = frutas[3];
				calorias = 670 + (int)Math.round(Math.random()*20);
				proteinas = 5 + (int)Math.round(Math.random()*5);
				acucar = 130 + (int)Math.round(Math.random()*20);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 8 + (int)Math.round(Math.random()*3);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  4 +(int)Math.round(Math.random()*2) ;
			}
			else if (rand4 < 5*(1/frutas.length)) {
				nome = frutas[4];
				calorias = 880 + (int)Math.round(Math.random()*30);
				proteinas = 8 + (int)Math.round(Math.random()*2);
				acucar = 90 + (int)Math.round(Math.random()*30);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 17 + (int)Math.round(Math.random()*3);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 2 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand4 < 6*(1/frutas.length)) {
				nome = frutas[5];
				calorias = 380 + (int)Math.round(Math.random()*20);
				proteinas = 9 + (int)Math.round(Math.random()*5);
				acucar = 75 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 13 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  2 + (int)Math.round(Math.random()*2);
			}
			else if (rand4 < 7*(1/frutas.length)) {
				nome = frutas[6];
				calorias = 170 + (int)Math.round(Math.random()*20);
				proteinas = 3 + (int)Math.round(Math.random()*3);
				acucar = 35 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 9 + (int)Math.round(Math.random()*3);
				sodio = 0;
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand4 < 8*(1/frutas.length)) {
				nome = frutas[7];
				calorias = 600 + (int)Math.round(Math.random()*10);
				proteinas = 8 + (int)Math.round(Math.random()*4);
				acucar = 130 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 14 + (int)Math.round(Math.random()*3);
				sodio = 0;
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  2 + (int)Math.round(Math.random()*2);
			}
			else {
				nome = frutas[8];
				calorias = 750 + (int)Math.round(Math.random()*20);
				proteinas = 2 + (int)Math.round(Math.random()*3);
				acucar = 140 + (int)Math.round(Math.random()*20);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 100 + (int)Math.round(Math.random()*10);
				sodio = 0;
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000 ;
				preco =  2 + (int)Math.round(Math.random()*2);
			}
			break;
		case Mercearia:
			double rand5 = Math.random();
			if (rand5 < 1/mercearia.length) {
				nome = mercearia[0];
				calorias = 1100 + (int)Math.round(Math.random()*30);
				proteinas = 30 + (int)Math.round(Math.random()*5);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 3 + (int)Math.round(Math.random()*2);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco = 2 + (int)Math.round(Math.random()*2);
			}
			else if (rand5 < 2*(1/mercearia.length)) {
				nome = mercearia[1];
				calorias = 1500 +(int)Math.round(Math.random()*20) ;
				proteinas = 50 + (int)Math.round(Math.random()*10);
				acucar = 1 + (int)Math.round(Math.random()*2);;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 10 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  2 +(int)Math.round(Math.random()*2);
			}
			else if (rand5 < 3*(1/mercearia.length)) {
				nome = mercearia[2];
				calorias = 3600 + (int)Math.round(Math.random()*30);
				proteinas = 80 + (int)Math.round(Math.random()*25);
				acucar = 1 + (int)Math.round(Math.random()*2);;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 20 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand5 < 4*(1/mercearia.length)) {
				nome = mercearia[3];
				calorias = 900 + (int)Math.round(Math.random()*20);
				proteinas = 60 + (int)Math.round(Math.random()*5);
				acucar = 100 + (int)Math.round(Math.random()*10);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 10 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  2 +(int)Math.round(Math.random()*2) ;
			}
			else if (rand5 < 5*(1/mercearia.length)) {
				nome = mercearia[4];
				calorias = 3500 + (int)Math.round(Math.random()*30);
				proteinas = 180 + (int)Math.round(Math.random()*5);
				acucar = 60 + (int)Math.round(Math.random()*10);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 100 + (int)Math.round(Math.random()*15);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  3 + (int)Math.round(Math.random()*2);
			}
			else if (rand5 < 6*(1/mercearia.length)) {
				nome = mercearia[5];
				calorias = 380 + (int)Math.round(Math.random()*40);
				proteinas = 0;
				acucar = 900 + (int)Math.round(Math.random()*50);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 0;
				sodio = 0;
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			else if (rand5 < 7*(1/mercearia.length)) {
				nome = mercearia[6];
				calorias = 40 + (int)Math.round(Math.random()*5);
				proteinas = 2 + (int)Math.round(Math.random()*3);
				acucar = 3 + (int)Math.round(Math.random()*2);
				lipidosSaturados = 0;
				lipidosMonoinsaturados = 0;
				lipidosPoliinsaturados = 0;
				colesterol = 0;
				fibras = 0;
				sodio = 0;
				potassio = 0;
				peso = 1000;
				preco =  25 + (int)Math.round(Math.random()*10);
			}
			else if (rand5 < 8*(1/mercearia.length)) {
				nome = mercearia[7];
				calorias = 13+ (int)Math.round(Math.random()*5);
				proteinas = 2 + (int)Math.round(Math.random()*2);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  12 + (int)Math.round(Math.random()*4);
			}
			else {
				nome = mercearia[8];
				calorias = 0;
				proteinas = 0;
				acucar = 0;
				lipidosSaturados = 0;
				lipidosMonoinsaturados = 0;
				lipidosPoliinsaturados = 0;
				colesterol = 0;
				fibras = 0;
				sodio = 10 + (int)Math.round(Math.random()*5);
				potassio = 0;
				peso = 1000 ;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			break;
		case Padaria:
			double rand6 = Math.random();
			if (rand6 < 1/padaria.length) {
				nome = padaria[0];
				calorias = 2340 + (int)Math.round(Math.random()*20);
				proteinas = 80 + (int)Math.round(Math.random()*8);
				acucar = 2 + (int)Math.round(Math.random()*2);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 20 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco = 1 + (int)Math.round(Math.random()*2);
			}
			else if (rand6 < 2*(1/padaria.length)) {
				nome = padaria[1];
				calorias = 1250 +(int)Math.round(Math.random()*50) ;
				proteinas = 30 + (int)Math.round(Math.random()*10);
				acucar = 1 + (int)Math.round(Math.random()*2);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 4 + (int)Math.round(Math.random()*3);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  2 +(int)Math.round(Math.random()*2);
			}
			else if (rand6 < 3*(1/padaria.length)) {
				nome = padaria[2];
				calorias = 2300 + (int)Math.round(Math.random()*30);
				proteinas = 60 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco = 3 + (int)Math.round(Math.random()*2);
			}
			else if (rand6 < 4*(1/mercearia.length)) {
				nome = padaria[3];
				calorias = 2000 + (int)Math.round(Math.random()*10);
				proteinas = 20 + (int)Math.round(Math.random()*20);
				acucar = 0;
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 0;
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  2 +(int)Math.round(Math.random()*2) ;
			}
			else {
				nome = padaria[4];
				calorias = 2300 + (int)Math.round(Math.random()*30);
				proteinas = 80 + (int)Math.round(Math.random()*5);
				acucar = 70 + (int)Math.round(Math.random()*5);
				lipidosSaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosMonoinsaturados = 1 + (int)Math.round(Math.random()*2);
				lipidosPoliinsaturados = 1 + (int)Math.round(Math.random()*2);
				colesterol = 0;
				fibras = 28 + (int)Math.round(Math.random()*5);
				sodio = 1 + (int)Math.round(Math.random()*2);
				potassio = 1 + (int)Math.round(Math.random()*2);
				peso = 1000;
				preco =  1 + (int)Math.round(Math.random()*2);
			}
			break;
		}
		return new Produto(nome, calorias, proteinas, acucar, lipidosSaturados, lipidosMonoinsaturados, lipidosPoliinsaturados,
		         colesterol, fibras, sodio, potassio, peso, preco);
	}
	
	public static double intersect(Produto a, Produto b) {
		double intersects = 0;
		if(a.nome == b.nome) intersects++;
		intersects += 1 - ((double)Math.abs(a.calorias - b.calorias))/Math.max(a.calorias, b.calorias);
		intersects += 1 - ((double)Math.abs(a.proteinas - b.proteinas))/Math.max(a.proteinas, b.proteinas);
		intersects += 1 - ((double)Math.abs(a.acucar - b.acucar))/Math.max(a.acucar, b.acucar);
		intersects += 1 - ((double)Math.abs(a.lipidosSaturados - b.lipidosSaturados))/Math.max(a.lipidosSaturados, b.lipidosSaturados);
		intersects += 1 - ((double)Math.abs(a.lipidosMonoinsaturados - b.lipidosMonoinsaturados))/Math.max(a.lipidosMonoinsaturados, b.lipidosMonoinsaturados);
		intersects += 1 - ((double)Math.abs(a.lipidosPoliinsaturados - b.lipidosPoliinsaturados))/Math.max(a.lipidosPoliinsaturados, b.lipidosPoliinsaturados);
		intersects += 1 - ((double)Math.abs(a.colesterol - b.colesterol))/Math.max(a.colesterol, b.colesterol);
		intersects += 1 - ((double)Math.abs(a.fibras - b.fibras))/Math.max(a.fibras, b.fibras);	
		intersects += 1 - ((double)Math.abs(a.sodio - b.sodio))/Math.max(a.sodio, b.sodio);	
		intersects += 1 - ((double)Math.abs(a.potassio - b.potassio))/Math.max(a.potassio, b.potassio);	
		intersects += 1 - ((double)Math.abs(a.peso - b.peso))/Math.max(a.peso, b.peso);	
		intersects += 1 - ((double)Math.abs(a.preco - b.preco))/Math.max(a.preco, b.preco);	
		return intersects;
	}
	
	public List<String> transform(){
		List<String> descricao = new ArrayList<String>();
		descricao.add(nome);
		descricao.add(String.valueOf(calorias));
		descricao.add(String.valueOf(proteinas));
		descricao.add(String.valueOf(acucar));
		descricao.add(String.valueOf(lipidosSaturados));
		descricao.add(String.valueOf(lipidosMonoinsaturados));
		descricao.add(String.valueOf(lipidosPoliinsaturados));
		descricao.add(String.valueOf(colesterol));
		descricao.add(String.valueOf(fibras));
		descricao.add(String.valueOf(sodio));
		descricao.add(String.valueOf(potassio));
		descricao.add(String.valueOf(peso));
		descricao.add(String.valueOf(preco));
		return descricao;
	}
	
	@Override
	public int hashCode(int seed) {
		double toConc = Math.pow(seed, seed+1);
		String toHash = nome + toConc;
		return toHash.hashCode();
	}
	
	public static int union() {
		return union;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void print() {
		System.out.printf("%s - Calorias (%dg) - Proteínas (%dg) - Açúcar (%dg) - Lípidos Saturados (%dg) - Lípidos Monoinsaturados (%dg)"
				+ " - Lípidos Poliinsaturados (%dg) - Colesterol (%dg) - Fibras (%dg) - Sódio (%dg) - Potássio (%dg) - Peso (%dg) - Preço (%d€)\n", 
				nome, calorias, proteinas, acucar, lipidosSaturados, lipidosMonoinsaturados, lipidosPoliinsaturados, colesterol, fibras, sodio, potassio, peso, preco);
	}
	
	@Override
	public String toString() {
		return nome+" -> Calorias: "+calorias+", Proteinas: "+proteinas+", Açúcar: "+acucar+", Lipidos Saturados: "+lipidosSaturados+
				", Lípidos Monoinsaturados: "+lipidosMonoinsaturados+", Lípidos Poliinsaturados: "+lipidosPoliinsaturados+
				", Colesterol: "+colesterol+", Fibras: "+fibras+", Sódio: "+sodio+", Potássio: "+potassio+", Peso: "+peso+"g, Preço: "+preco+"€"; 
	}
}