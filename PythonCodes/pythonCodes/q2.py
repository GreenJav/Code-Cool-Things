'''
Aluna: Livia Emanuelle Carrera Soares da Silva
Matrícula:201904940008
'''
tam = int(input('Digite o tamanho da matriz: '))

if tam % 2 != 0 or tam not in range(10, 21):        #veifica se o tamanho da matriz é válido, se não for o programa encerra.
    print("Tamanho da matriz inválido. Tente novamente")
    exit(0)

M = [[0] * tam for i in range(tam)]  # cria uma matriz tam x tam que possui todos os valores igual a 0


# função que preenche a matriz de forma recursiva
def preencheMatriz(valor, inicio, fim):
    for i in range(inicio, fim):
        for j in range(inicio, fim):
            M[i][j] = valor
    if valor == (tam / 2) - 1:      # condição de parada: caso o valor a ser inserido for igual a (tam/2) -1
        return
    preencheMatriz(valor + 1, inicio + 1, fim - 1)  #chama recursivamente a função, de modo a preencher uma area cada vez menor


preencheMatriz(0, 0, tam)   # inicia o preenchimento partindo do 0 até tam inserindo 0.
#imprime a matriz
for i in range(len(M)):
    for j in range(len(M[0])):
        print(M[i][j], end=" ")
        if j == len(M) - 1:
            print()
