#Lívia Emanuelle Carrera Soares da Silva - 201904940008
from pythonds.basic.stack import Stack

b=input("Digite o número na base 3 ->")
p=int(input("Digite a base para que deseja converter (2-10) ->"))

def tercDecimal(a):
  dec = 0
  j=len(a)-1
  if int(a) > 0:
    for i in range(len(str(a))):
      x=a[j]
      dec += int(x)*3**i
      j-=1
  return dec

def decAny(k,base):
  restoPilha=Stack()
  numero=""
  while k>0:
    resto = k % base
    restoPilha.push(resto)
    k = k//base

  while not restoPilha.isEmpty():
    numero+=str(restoPilha.pop())

  return int(numero)

'''print( tercDecimal(b) )'''
print( "Valor",b,"na base",p,":",decAny(tercDecimal(b),p) )