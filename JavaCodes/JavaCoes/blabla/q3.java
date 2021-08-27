package blabla;

import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite n-> ");
        int n = scanner.nextInt();
        float[] v = new float[n];
        for (int i = 0; i < v.length; i++) {
            System.out.print("Digite o "+(i+1)+" valor-> ");
            v[i] = scanner.nextFloat();
        }
        float med = 0, var=0;
        for (int i = 0; i < v.length; i++) {
            med += v[i];
        }
        med /= v.length;
        for (int i = 0; i < v.length; i++) {
            var += Math.pow(v[i]-med,2);
        }
        var = (float) Math.pow(var/v.length, 0.5);
        System.out.printf("Média dos valores = %.2f\n", med);
        System.out.printf("Desvio padrão dos valores = %.2f\n", var);
    }
}
