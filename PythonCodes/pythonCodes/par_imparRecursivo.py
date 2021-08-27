'''

10 - Escreva um programa para receber um intervalo de números naturais. Exemplo 1 a 10, e imprima os números pares e ímpares através de recursão.
'''
def par_Impar(a,b):
    if a % 2 == 0:
        print(a, 'é par')
    else:
        print(a, 'é impar')
    if a == b:
        return
    else:
        par_Impar(a+1,b)

par_Impar(1,10),