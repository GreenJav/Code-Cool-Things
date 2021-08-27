package blabla;

import java.util.Scanner;

public class q5 {
    public static int fat(int n){
        if(n <= 1){
            return 1;
        }
        return n*fat(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o expoente x -> ");
        float x = scanner.nextFloat();
        System.out.print("Digite o número de termos -> ");
        int k = scanner.nextInt();
        if (k==0 || x==0){
            System.out.println("Valor de e^x = 1");
            return;
        }
        float s=1;
        for (int i = 1; i <= k; i++) {
            s = s + (float) Math.pow(x,i)/fat(i);
        }
        System.out.println("Valor de e^"+x+" resultante = "+s);
    }
}
