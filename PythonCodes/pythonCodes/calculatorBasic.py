import sys
def soma():
    x = float(input("primeiro numero: "))
    y = float(input("segundo numero: "))
    print("Soma: ",x+y)

def subtracao():
    x = float(input("primeiro numero: "))
    y = float(input("segundo numero: "))
    print("Subtracao: ",x-y)

def multiplicacao():
    x = float(input("primeiro numero: "))
    y = float(input("segundo numero: "))
    print("Multiplicacao: ",x*y)

def divisao():
    x = float(input("primeiro numero: "))
    y = float(input("segundo numero: "))
    print("Divisao: ",x/y)

def menu():
      print("1 - Somar")
      print("2 - Subtrair")
      print("3 - Multiplicação")
      print("4 - Divisão ")
      print("5 - Sair")

      opcao = int(input("Opção: "))

      if(opcao==1):
          soma()
      if(opcao==2):
          subtracao()
      if(opcao==3):
          multiplicacao()
      if(opcao==4):
          divisao()
      if(opcao==5):
        sys.exit()
      
menu()
'''
 Crie uma calculadora em Python, o programa deve ter as quatro operações básicas em formato de funções. Também deve ter uma função que mostre um menu de opções para o usuário interagir e escolher qual operação matemática deseja executar. Exemplo: 1 - Soma, 2 - Subtração, 3 - Multiplicação, 4 - Divisão, 5 - Fechar programa.
'''