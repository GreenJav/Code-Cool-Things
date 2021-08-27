'''
Visão geral:
O programa compara uma matriz menor B com uma maior A, visando identificar onde a matriz B se repete em A e quantas vezes isso acorre.
Aluna: Livia Emanuelle Carrera Soares da Silva
Matrícula:201904940008
'''

import random

tam = int(input('Digite o tamanho da matriz A: '))      #obtem o tamanho da matriz

if tam not in range(10, 21):  # veifica se o tamanho da matriz é válido, se não for o programa encerra.
    print("Tamanho da matriz inválido. Tente novamente")
    exit(0)

# cria uma matriz tam x tam que possui todos os valores aleatórios entre entre 0 e 9
A = [[0] * tam for x in range(tam)]
for i in range(len(A)):
    for j in range(len(A[0])):
        A[i][j] = random.randint(0,9)

# cria a matriz B 2x2 com elementos aleatórios entre 0 e 9
B = [[0] * 2 for x in range(2)]
for i in range(len(B)):
    for j in range(len(B[0])):
        B[i][j] = random.randint(0,9)


# Função que procura o padrão de uma matriz menor m1 em uma matriz maior m2
def procuraPadrao(m1, m2):
    i, j = 0, 0     #variveis que acompanham as possições na matriz m2

    def ppRec(m1, m2, i, j, qtdPadroes):    #encapsula uma função recursiva em outra para melhorar a implementação
        c = 0
        a1 = []
        for x in range(len(m1)):    # laços de repetições para percorrer uma area len(m1) x len(m1) na matriz m2
            for y in range(len(m1[0])):
                if m2[i + x][j + y] == m1[x][y]:    # se o valor for igual ao de m1, incrementa o contador
                    c += 1
        if c == len(m1)**2:      # se houver um total de len(m1)² acertos, então mostra a posição do padrão encontrado
            qtdPadroes += 1
            print("Padrão encontrado na posição: ", [i, j])
        if [i, j] == [len(m2) - len(m1), len(m2) - len(m1)]:        #condição de parada da função: Quando for avaliado a ultima posição possivel dentro de m2
            print('Quantidade total de padrões encontrados:', qtdPadroes)       #mostra o resultado
            return
        elif j == len(m2) - 2:                      # se a coluna atual for a ultima possivel dentro m2, então avança para a proxima linha
            ppRec(m1, m2, i + 1, 0, qtdPadroes)
        else:                                       # caso contrario, avança para o proximo elemento à direita
            ppRec(m1, m2, i, j + 1, qtdPadroes)

    ppRec(m1, m2, i, j, 0)      #inicia a recursividade


# imprime a matriz A
print('         MATRIZ A')
for i in range(len(A)):
    for j in range(len(A[0])):
        print(A[i][j], end=" ")
        if j == len(A) - 1:
            print()
# imprime a matriz B
print('         MATRIZ B')
for i in range(len(B)):
    for j in range(len(B[0])):
        print(B[i][j], end=" ")
        if j == len(B) - 1:
            print()

procuraPadrao(B, A)     #verifica os padrões e mostra o resultado
