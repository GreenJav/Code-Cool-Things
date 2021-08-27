def somaMultiplo(limite): 
  soma = 0
  for x in range (limite + 1):
    if x % 3 == 0 and x % 5 == 0:
        soma += x
        x += 1
    elif x % 3 == 0:
        soma += x
        x += 1
    elif x % 5 == 0:
        soma += x
        x += 1
  return print('soma dos multiplos',soma)



a = int(input('Limite:'))

somaMultiplo(a)

'''
Escreva uma função que retorne a soma de múltiplos de 3 e 5 entre 0 e limite (parâmetro). Por exemplo, se o limite for 20, ele deve retornar a soma de 3, 5, 6, 9, 10, 12, 15, 18, 20.
'''