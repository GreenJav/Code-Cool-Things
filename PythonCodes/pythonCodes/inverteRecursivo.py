'''
6 - Escreva um programa, utilizando recursão, que receba um array de inteiros de n posições e como saída, imprima os elemento na posição inversa. Exemplo - [1,2,3,4,5] -> [5,4,3,2,1].
'''
def inverteLista(lista, first=0, last=-1):
    if first >= len(lista) / 2:
        return
    lista[first], lista[last] = lista[last], lista[first]
    inverteLista(lista, first + 1, last - 1)

# lista vazia
lst = []
# numero de elementos da lista
n = int(input('Numero de elementos da lista : '))
  
# interacao
for i in range(0, n):
    print('elemento ->', i, ':')
    ele = int(input()) 
    lst.append(ele) # adiciona elemento
print('lista atual:',lst)      
inverteLista(lst)
print('lista invertida:',lst)