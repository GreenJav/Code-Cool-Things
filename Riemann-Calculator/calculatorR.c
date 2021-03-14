
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
double f(double x);
double rie(int select,double b,double a,int n);
double simp(double b,double a,int n);

int main()
{
    double a,b;
    int n,k;
    double E;
    printf("1--Riemann a Esquerda\n");
    printf("2--Riemann a Direita\n");
    printf("3--Soma Media\n");
    printf("4--Soma Trapezoidal\n");
    printf("5--Regra de Simpson\n");
    printf("\nLimite Superior:");
    scanf("%lf",&b);
    printf("\nLimite Inferior:");
    scanf("%lf",&a);
    printf("\nNumero de Particoes:");
    scanf("%d", &n);
    printf("\nQual Somatorio? ");
    scanf("%d", &k);
    if(k==5){
        E=simp(b,a,10000000)-simp(b,a,n);
        printf("Resultado: %.3lf\n", simp(b,a,n));
        printf("Erro: %lf\n", E);
    }
    else{
        E=rie(k,b,a,10000000)-rie(k,b,a,n);
        printf("Resultado: %.3lf\n", rie(k,b,a,n));
        printf("Erro: %lf\n", E);
    }
}

double f(double x)
{
    return(-x*x+4);
}

double rie(int select,double b,double a,int n)
{
    double S,delta,SS;
    int i;
    delta=(b-a)/n;
    S=0;
    SS=0;
    if(select==1)
    {   //Somatorio de Riemann à Esquerda
        for(i=0;i<n;i++)
          S=S+f(a+i*delta);
        return(S*delta);
    }
    if(select==2)
    {   //Somatorio de Riemann à Direita
        for(i=0;i<n;i++)
          S=S+f(a+(i+1)*delta);
        return(S*delta);
    }
    if(select==3)
    {   //Soma Media
        for(i=0;i<n;i++)
          S=S+f(a+((i+1)*delta+i*delta)/2.0);
        return(S*delta);
    }
    if(select==4)
    {   //Soma Trapezoidal
        return((rie(1,b,a,n)+rie(2,b,a,n))/2);
    }
}
double simp(double b,double a,int n)
{
    return((2*rie(3,b,a,n)+rie(4,b,a,n))/3.0);
}