package blabla;

public class q7 {
    public static void main(String[] args) {
        System.out.println("Valor da soma S = "+somaEp(4,160000));

        System.out.println("|\t\tTabela\t\t|\n");
        System.out.println("|\tQtd de termos\t|\tResultado\t|");
        for (int i = 50000; i <= 200000; i+=25000) {
            System.out.println("|\t"+i+"\t|\t"+somaEp(4,i)+"\t|");
        }

        /* A partir de testes intuitivos e dos dados da tabela, é possivel afirmar que por volta de no minímo 160 mil
        termos a soma resulta em 3.14159 */
    }

    public static float somaEp(float x, int qT){
        float s = 0;
        for (int i = 0; i < qT; i++) {
            s += (float) Math.pow(-1, i)*x/(2*i+1);
        }
        return s;
    }
}
