package bloomSupermarket;
import java.util.*;
import static java.lang.System.*;

public class AdminArea {
	static Scanner sc = new Scanner(System.in);
    static AppData data;
    
    public static void start(){
        data = AppData.getInstance();
        int opt;
        out.print("\n------------------------------------");
        out.print("\n| Bloom Supermarket                |");
        out.print("\n------------------------------------");
        out.print("\n|    Admin  Area                   |");
        out.print("\n------------------------------------");
        out.print("\n|1 - Encher o Stock                |");
        out.print("\n|2 - Listar Users                  |");
        out.print("\n|3 - Limpar Base de Dados          |");
        out.print("\n|4 - Adicionar Produtos Aleatórios |");
        out.print("\n|0 - Sair                          |");
        out.print("\n------------------------------------");

        do{
            out.print("\nOpção: ");
            opt = sc.nextInt();

            if(opt == 1){
                data.fillStock();              
            }

            if(opt == 2){
                data.listUsers();
				break;
            }
            
            if(opt == 3){
                data.reset();
				break;
            }
            
            if(opt == 4){
                data.addRandProd();
				break;
            }
            
            if(opt == 0){
                System.exit(0);
            }
        }while(opt != 1 || opt != 2 || opt != 0);
    }
}
