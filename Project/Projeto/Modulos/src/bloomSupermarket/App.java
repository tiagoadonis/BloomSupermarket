package bloomSupermarket;

import java.util.*;
import static java.lang.System.*;
@SuppressWarnings("unused")

public class App {
    static Scanner sc = new Scanner(System.in);
    public static AppData data = new AppData(1000,500);
    
    public static void main(String[] args){
    	data.fill(500,100);
        int opt;
        out.println("Welcome To Bloom Supermarket");
        out.print("\n---------------------");
        out.print("\n| Bloom Supermarket |");
        out.print("\n---------------------");
        out.print("\n|1 - Login          |");
        out.print("\n|2 - Registar       |");
        out.print("\n|0 - Sair           |");
        out.print("\n---------------------");
        do{
            out.print("\nQue deseja fazer: ");
            opt = Integer.parseInt(sc.nextLine());
            data = AppData.getInstance();
            if(opt == 1){
                login();
            }

            if(opt == 2){
                register();
            }

            if(opt == 0){
                System.exit(0);
            }
        }while(opt != 1 || opt != 2 || opt != 0);
    }

    public static void login(){
        out.print("Email: ");
        String email = sc.next();
		out.print("Password: ");
        String password = sc.next();
        Utilizador user = new Utilizador(email, password);
        if(data.users.isMember(user)) {
			System.out.println("Login confirmado.");
			data.setCurrentUser(email);
			Snd_login(user);
		}
		else {
			try {
				System.out.print("Utilizador não registado. Pretende registar-se? (S/N) ");
				String choice = sc.next();
				System.out.println();
				if(choice.equals("s")||choice.equals("S")) {
					register();
				}
				else {
					System.exit(0);
				}
			}catch(Exception e)
			{
				
			}
		}
    }
    
    public static void register(){
        String nome, email, pass, district;
        int age;

        out.print("Nome: ");
		nome = sc.next();
		
		out.print("Email: ");
		email = sc.next();
		
		out.print("Password: ");
		pass = sc.next();
		
		out.print("Distrito: ");
		district = sc.next();

        out.print("Idade (maior ou igual a 18): ");
        age = sc.nextInt();

        Utilizador user = new Utilizador(nome, email, pass, district, age);
		data.users.insert(user);
		out.println("\nUtilizador registado com sucesso!\n");
		Snd_login(user);
    }

    public static void Snd_login(Utilizador u){
    	System.out.print("\n--------------------------------------------");
    	System.out.print("\n|               Bloom Supermarket          |");
    	System.out.print("\n--------------------------------------------");
        System.out.print("\nLogged In as: " + u.getEmail());
        System.out.print("\n--------------------------------------------");
        System.out.print("\n|1 - Comprar                               |");
        System.out.print("\n|2 - Ver Produtos                          |");
        System.out.print("\n|3 - Listar Produtos Favoritos             |");
        System.out.print("\n|4 - Adicionar Produto aos Favoritos       |");
        System.out.print("\n|5 - Sugestões de Produtos                 |");        
        System.out.print("\n|6 - Area de Admin                         |");
        System.out.print("\n|0 - Sair                                  |");
        System.out.print("\n--------------------------------------------");

        int opt_ins;

        do{
            out.print("\nQue deseja fazer: ");
            opt_ins = sc.nextInt();
            
            if(opt_ins == 1){
                data.buyProd();
            }

            if(opt_ins == 2){
            	data.listProducts();
            }

            if(opt_ins == 3){
            	data.getCurrentUser().listFavProds();
            }
            
            if(opt_ins == 4){
            	data.addProdToFav();
            }
            
            if(opt_ins == 5){
            	data.listSimilarProducts();
        	}
        
            if(opt_ins == 6){
            	if (data.admins.isMember(data.currentUser)) {
                    AdminArea.start(); 
                }
                else {
                    System.out.println("Area restrita a administradores");
                }
            }

            if(opt_ins == 0){
                System.exit(0);
            }
        }while(opt_ins != 1 || opt_ins != 2 || opt_ins != 3 || opt_ins != 4 || opt_ins != 5 || opt_ins != 6 || opt_ins != 0);
    }
}
