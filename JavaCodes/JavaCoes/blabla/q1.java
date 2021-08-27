package blabla;

public class q1 {
    public static void main(String[] args) {
        int s=0;
        for (int i = 1; i <= 100; i++) {
            s+=i;
        }
        System.out.println("Soma de 1 a 100 com laço for: "+s);

        s=0;
        int i=0;
        while(i<=100){
            s+=i;
            i++;
        }

        System.out.println("Soma de 1 a 100 com laço while: "+s);
    }
}
