# Aluna: Lívia Emanuelle Carrera Soares da Silva Matrícula: 201904940008
# Função pegaExtremos
# Retorna uma tupla com o maior e menor valor de um lista passada como parâmetro
def pegaExtremos(lista):
    maior = lista[0]
    menor = lista[0]
    for x in lista:
        if x > maior:
            maior = x
        if x < menor:
            menor = x
    return (maior, menor)

# Função isPrime
# Retorna True se um número n passado como parâmetro é primo, retorna False caso contrário
def isPrime(n):
    for x in range(2, round(n**(1/2))+1):   # realiza a busca por divisores de n partindo de 2 até sqrt(n)+1
        if n % x == 0:
            return False

    return True

# Função geraPrimos
# Gera e retorna uma lista com todos os primos no intervalo fornecido como parâmetro
def geraPrimos(inicio, fim):
    listaPrimos = []
    for x in range(inicio, fim):
        if isPrime(x):
            listaPrimos.append(x)

    return listaPrimos

# Função pegaPercentual
# Retorna uma lista com os percentuais da quantidade numeros terminados com 1,3,5,7 e 9, respectivamente
# exemplo: pegaPercentual([10,9,3,22]) vai retornar [0, 25, 0, 0, 25]
def pegaPercentual(lista):
    dig = [0] * 5
    for x in lista:
        if x % 10 == 1:
            dig[0] += 1
        if x % 10 == 3:
            dig[1] += 1
        if x % 10 == 5:
            dig[2] += 1
        if x % 10 == 7:
            dig[3] += 1
        if x % 10 == 9:
            dig[4] += 1
    return [100 * dig[0] / len(lista), 100 * dig[1] / len(lista), 100 * dig[2] / len(lista), 100 * dig[3] / len(lista),
            100 * dig[4] / len(lista)]


lista = geraPrimos(2, 100000)   # gera a lista de primos

grupos = [[]] * 4   # inicia os 4 grupos da lista, 25% da lista para cada

# Laço que percorre a lista de 25% em 25%, de modo que que cada 25% vai para um dos 4 grupos já criados
c = 0   # variável que controla o atual grupo
for x in range(0, len(lista), round(len(lista) / 4)):   # anda de 25% em 25% da lista
    aux = []    # variável auxiliar que vai para o grupoa atual
    passo = x + round(len(lista) / 4)   # define o passo para percorrer os 25% atual da lista (grupo)
    if len(lista) - x < round(len(lista) / 4):      # caso len(lista) não seja divisivel por 4, faz que o resto seja adicionado ao ultimo grupo.
        passo = len(lista)
    for i in range(x, passo):   # percorre os 25% atual da lista
        aux.append(lista[i])    # adiciona à aux
    grupos[c] = aux     # defina o grupo
    if c < 3:   # controle do grupo
        c += 1

pg = [] # inicia os percentuais de cada grupo
for i in range(len(grupos)):
    pg.append(pegaPercentual(grupos[i]))    # adiciona a pg os percentuais de cada grupo

# Variável que recebe o maior e menor da média de percentuais
extremosMedia = pegaExtremos([sum([pg[0][0], pg[1][0], pg[2][0], pg[3][0]]) / 4, sum([pg[0][1], pg[1][1], pg[2][1], pg[3][1]]) / 4,
                              sum([pg[0][2], pg[1][2], pg[2][2], pg[3][2]]) / 4, sum([pg[0][3], pg[1][3], pg[2][3], pg[3][3]]) / 4,
                              sum([pg[0][4], pg[1][4], pg[2][4], pg[3][4]]) / 4])
extremosGrupos = [] # Variável que recebe os extremos dos percentuais de cada grupo
for i in range(len(grupos)):
    extremosGrupos.append( pegaExtremos(pg[i]) )    # adiciona os extremos

# Define o texto que será inserido no arquivo de resultado do programa.
texto = ['Intervalo, GPO1, GPO3, GPO5, GPO7, GPO9, Maior, Menor,\n',
         f'[00%; 25%], {pg[0][0]:.2f}%, {pg[0][1]:.2f}%, {pg[0][2]:.2f}%, {pg[0][3]:.2f}%, {pg[0][4]:.2f}%, {extremosGrupos[0][0]:.2f}%, {extremosGrupos[0][1]:.2f}%\n',
         f']25%; 50%], {pg[1][0]:.2f}%, {pg[1][1]:.2f}%, {pg[1][2]:.2f}%, {pg[1][3]:.2f}%, {pg[1][4]:.2f}%, {extremosGrupos[1][0]:.2f}%, {extremosGrupos[1][1]:.2f}%\n',
         f']50%; 75%], {pg[2][0]:.2f}%, {pg[2][1]:.2f}%, {pg[2][2]:.2f}%, {pg[2][3]:.2f}%, {pg[2][4]:.2f}%, {extremosGrupos[2][0]:.2f}%, {extremosGrupos[2][1]:.2f}%\n',
         f']75%; 100%], {pg[3][0]:.2f}%, {pg[3][1]:.2f}%, {pg[3][2]:.2f}%, {pg[3][3]:.2f}%, {pg[3][4]:.2f}%, {extremosGrupos[3][0]:.2f}%, {extremosGrupos[3][1]:.2f}%\n',

         f'Média, {sum([pg[0][0], pg[1][0], pg[2][0], pg[3][0]])/4:.2f}%, {sum([pg[0][1], pg[1][1], pg[2][1], pg[3][1]])/4:.2f}%, {sum([pg[0][2], pg[1][2], pg[2][2], pg[3][2]])/4:.2f}%, {sum([pg[0][3], pg[1][3], pg[2][3], pg[3][3]])/4:.2f}%, {sum([pg[0][4], pg[1][4], pg[2][4], pg[3][4]])/4:.2f}%, {extremosMedia[0]:.2f}%, {extremosMedia[1]:.2f}%\n']

arq = open('restultadoP1.txt', 'w')
for i in texto:     #escreve o texto no arquivo
    arq.write(i)
arq.close()
