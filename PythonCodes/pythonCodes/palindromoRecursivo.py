'''
5 - Escreva um programa recursivo para verificar se uma determinada String é palíndromo ou não.
'''
def ePalindromo(palavra):
    if len(palavra) < 2: return print('eh palindromo')
    if palavra[0] != palavra[-1]: return print('n eh palindromo')
    return ePalindromo(palavra[1:-1])

teste = input('escreva uma palavra:')
ePalindromo(teste)