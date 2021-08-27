package com.company;

public class CalculadoraC {
    private float n1, n2;
    private float a, b, c;

    public CalculadoraC(float n1, float n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public CalculadoraC(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float soma(){
        return n1 + n2;
    }

    public float subt(){
        return n1 - n2;
    }

    public float mult(){
        return n1 * n2;
    }

    public float div(){
        try{
            return n1 / n2;
        }catch (RuntimeException e){
            throw new RuntimeException("Impossível dividir por 0.");
        }
    }

    public float exp(){
        if(n1==0 && n2==0){
            throw new RuntimeException("Valor indefinido.");
        }
        return (float) Math.pow(n1, n2);
    }

    public int rest(){
        try {
            return (int) (n1 % n2);
        }catch (RuntimeException e){
            throw new RuntimeException("Impossivel dividir por 0");
        }
    }

    public float[] root_quadraticEq(){
        try {
            float[] x = new float[2];
            x[0] = (float) ((-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a);
            x[1] = (float) ((-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a);
            return x;
        }catch (RuntimeException e){
            throw new RuntimeException("Não há raizes reais para a equação quadrática! ");
        }
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }
}
