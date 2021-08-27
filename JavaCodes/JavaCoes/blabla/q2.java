package blabla;

import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um inteiro não negativo-> ");
        int k = scanner.nextInt();
        if(k==0){
            System.out.println("0! = 1");
            return;
        }
        int fat=1;
        for (int i = 1; i <= k; i++) {
            fat*=i;
        }
        System.out.println(k+"! = "+fat);
    }
}
