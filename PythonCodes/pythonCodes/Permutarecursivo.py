'''

9 - Dada uma lista qualquer de números naturais positivos de 3 elementos, escreva uma função recursiva que retorne uma lista incluindo todas as permutações possíveis. Exemplo [1,2,3] - > [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
'''
def permuta(lista):
    if not lista:
        return [[]]
    resultado = []
    for e in lista:
        temp = lista[:]
        temp.remove(e)
        resultado.extend([[e] + r for r in permuta(temp)])

    return resultado
print(permuta([1, 2, 3]))