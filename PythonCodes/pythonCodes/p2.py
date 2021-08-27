# Aluna: Lívia Emanuelle Carrera Soares da Silva Matrícula: 201904940008
# Função que gera a sequência por meio de uma matriz de ordem n
def geraSequencia(n):
    mat = [[0] * n for x in range(n)]       #cria a matriz
    # laços que percorrem a matriz
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if j == 0 or i == j:
                mat[i][j] = 1       # define os elementos dos extremos como 1
            if 1 < i != j:
                mat[i][j] = mat[i - 1][j] + mat[i - 1][j - 1]   # define os elementos de acordo com a lógica da sequência
    return mat

# Função que retorna uma lista com as somas correspondentes de cada linha da sequência
def pegaSoma(seq):
    soma = [0] * len(seq)   #inicia a lista com os valores nulos

    # laço para percorrer a matriz que contém a sequência
    for i in range(len(seq)):
        for j in range(len(seq[0])):
            if seq[i][j] != 0:
                soma[i] = soma[i] + seq[i][j]   # soma todos os elementos da linha
    return soma     #retorna a soma

# Função que imprime na tela a sequência e a soma das linhas
def imprimeAll(seq, soma):
    print('Sequência: ')
    for i in range(len(seq)):
        for j in range(len(seq[0])):
            if seq[i][j] != 0:
                print(seq[i][j], end=" ")
            if j == len(seq) - 1:
                print(f'\t\t\tSoma da linha {i+1}= {soma[i]}')


N = int(input('Digite o valor de N: '))     # captura a entrada do usuario
if N <= 0:  # testa se o valor de N é válido
    print('Valor inserido inválido. Tente novamente.')
    exit(0)

seq = geraSequencia(N)      # cria a sequência
soma = pegaSoma(seq)        # define as somas
imprimeAll(seq, soma)       # imprime tudo
