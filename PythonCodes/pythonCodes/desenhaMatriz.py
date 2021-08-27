#Lívia Emanuelle Carrera Soares da Silva - 201904940008

#tamanho da matriz maior
tamanhoM=int(input("Digite a ordem da Matriz desejada (>10)->"))
if tamanhoM < 10:
    raise Exception("Insira um numero maior que 10")
#entradas de usuario e definicoes de matriz menor e pontas
pontaSe=[int(input("Digite a linha da ponta superior esquerda->")),int(input("Digite a coluna da ponta superior esquerda->"))]
pontaId=[int(input("Digite a linha da ponta inferior direita->")),int(input("Digite a coluna da ponta inferior direita->"))]
print("\n")
#verifica pontas
if abs(pontaSe[0]-pontaId[0])>tamanhoM-1 or abs(pontaSe[1]-pontaId[1])>tamanhoM-1:
  print("Ponta incorreta, tente novamente")
  exit()
#formulas para a pontas inferior direita obedecer, caso qaudrado
'''if pontaSe[0]>Tm and pontaSe[1]>Tm:
  pontaId=[pontaSe[0]-Tm+1,pontaSe[1]-Tm+1]
elif pontaSe[1]>Tm:
  pontaId=[pontaSe[0]+Tm-1,pontaSe[1]-Tm+1]
elif pontaSe[0]>Tm:
  pontaId=[pontaSe[0]-Tm+1,pontaSe[1]+Tm-1]
else:
  pontaId=[pontaSe[0]+Tm-1,pontaSe[1]+Tm-1]'''
#cria matriz
m = [[0]*tamanhoM for i in range(tamanhoM)]
#define elementos da matriz
if pontaSe[0]>pontaId[0] and pontaSe[1]>pontaId[1]:
  for x in range(pontaId[0],pontaSe[0]):
    for y in range(pontaId[1],pontaSe[1]):
      m[x][y]="X"
      m[pontaSe[0]][y]=1
      m[pontaId[0]][y]=1
      m[x][pontaSe[1]]=1
      m[x][pontaId[1]]=1
      m[pontaSe[0]][pontaSe[1]]=1
elif pontaSe[0]>pontaId[0]:
  for x in range(pontaId[0],pontaSe[0]):
    for y in range(pontaSe[1],pontaId[1]):
      m[x][y]="X"
      m[pontaSe[0]][y]=1
      m[pontaId[0]][y]=1
      m[x][pontaSe[1]]=1
      m[x][pontaId[1]]=1
      m[pontaSe[0]][pontaId[1]]=1
elif pontaSe[1]>pontaId[1]:
  for x in range(pontaSe[0],pontaId[0]):
    for y in range(pontaId[1],pontaSe[1]):
      m[x][y]="X"
      m[pontaSe[0]][y]=1
      m[pontaId[0]][y]=1
      m[x][pontaSe[1]]=1
      m[x][pontaId[1]]=1
      m[pontaId[0]][pontaSe[1]]=1  
else:
  for x in range(pontaSe[0],pontaId[0]):
    for y in range(pontaSe[1],pontaId[1]):
      m[x][y]="X"
      m[pontaSe[0]][y]=1
      m[pontaId[0]][y]=1
      m[x][pontaSe[1]]=1
      m[x][pontaId[1]]=1
      m[pontaId[0]][pontaId[1]]=1
#printa o resultado
for i in range(len(m)):
  for j in range(len(m[0])):
    print(m[i][j], end=" ")
    if j==len(m)-1:
      print("\n")
