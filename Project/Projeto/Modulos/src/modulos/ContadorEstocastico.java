package modulos;

public class ContadorEstocastico {
	static double count = 1;
    static int n = 0;

    public static void add(){
        if(count >= Math.random()){
            n++;
            update();
        }
    }

    public static void update(){
        count = 1/(Math.pow(2,n));
    }
}
