# Aluna: Lívia Emanuelle Carrera Soares da Silva Matrícula: 201904940008
# IMPORTAÇÕES
import random
import os

'''a)'''
percent = 0.2  # percentual de valores não nulos na matriz
n = 10000  # tamanho da matriz
mat = [[0] * n for x in range(n)]  # cria matriz n x n incialmente nula
qValores = round(percent * len(mat) ** 2)  # quantidade de valores não nulos na matriz

# Laço que preenche a matriz de maneira aletoria com valores não nulos de acordo com qValores
while qValores > 0:
    pos = [random.randint(0, len(mat) - 1), random.randint(0, len(mat) - 1)]  # acha uma posição aleatoria na matriz
    if mat[pos[0]][pos[1]] == 0:  # condição que impede de repetir posições
        mat[pos[0]][pos[1]] = random.randint(1, 9)
        qValores -= 1

'''b)'''
# Função que defina a lista alternativa
listaAlt = []
for i in range(len(mat)):
    for j in range(len(mat[0])):
        # se o valor atual da matriz for diferente de zero, adiciona [lin, col, val] na lista
        if mat[i][j] != 0:
            listaAlt.append([i, j, mat[i][j]])

'''c)'''
# Grava a matriz no arquivoA.txt
arq1 = open('arquivoA.txt', 'w')  # abre/cria o arquivo
arq1.write(f'{mat}')  # grava a matriz esparsa
tamA = os.path.getsize("arquivoA.txt")  # obtem o tamanho do arquivo
print(f'Tamanho do arquivoA.txt = {tamA} bytes')
arq1.close()  # fecha o arquivo

# Grava a matriz no arquivoB.txt
arq2 = open('arquivoB.txt', 'w')  # abre/cria o arquivo
arq2.write(f'{listaAlt}')  # grava a lista alternativa
tamB = os.path.getsize("arquivoB.txt")  # obtem o tamanho do arquivo
print(f'Tamanho do arquivoB.txt = {tamB} bytes')
arq2.close()  # fecha o arquivo

# realiza as comparações entre os tamanho mostra o percentual na tela
if tamB != 0 and tamA != 0:
    if tamA > tamB:
        print(f'O arquivoA.txt é {((tamA - tamB) / tamB) * 100:.2f}% maior que o arquivoB.txt')
    else:
        print(f'O arquivoB.txt é {((tamB - tamA) / tamA) * 100:.2f}% maior que o arquivoA.txt')


'''d)'''
def reconstroiMat(lista, matriz):
    matriz = [[0] * len(matriz) for x in range(len(matriz))]  # define a matriz
    # Percorre a lista e define os valores da matriz a partir dela
    for i in range(len(lista)):
        matriz[lista[i][0]][lista[i][1]] = lista[i][2]

    return matriz

'''
def imprimeMat(A):
    for i in range(len(A)):
        for j in range(len(A[0])):
            print(A[i][j], end=" ")
            if j == len(A) - 1:
                print()


print()
print('Matriz original: ')
imprimeMat(mat)
print()
print('Matriz reconstruida: ')
imprimeMat(reconstroiMat(listaAlt, []))
'''