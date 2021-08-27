'''
7 - Escreva uma função recursiva que determine quantas vezes um dígito k ocorre em um número natural N. Exemplo, o dígito 2 ocorre 2 vezes em 824562.
'''
import math

def tam(numero): #funcao auxiliar
    numero = abs(int(numero))
    return (1 if numero == 0 else math.floor(math.log10(numero)) + 1)

def kTimes(n, k):
    if n < k:
        return 0 
    if n % (10 ** tam(k)) == k:
        c = 1
    else:
        c = 0
    return c + kTimes(n // 10, k) #chamada recursiva

n, k = 824562, 2
print(f'O número {k} ocorre {kTimes(n, k)} vezes no número {n}') #f-string format