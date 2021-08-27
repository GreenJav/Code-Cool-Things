'''
Aluna: Livia Emanuelle Carrera Soares da Silva
Matrícula:201904940008
'''
k = 5

def produzSequencia(n):
    if n == 1:
        print(1, '.')
        return
    if n % 2 == 0:
        print(n, end=', ')
        produzSequencia(n / 2)
    else:
        print(n, end=', ')
        produzSequencia((n * 3) + 1)


print('Sequência:', end=' ')
produzSequencia(k)
