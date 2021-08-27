#Lívia Emanuelle Carrera Soares da Silva - 201904940008
'''
criação de função para geração randomica de numeros numa lista de tamanho definido
'''
def listarand():
  from random import randint
  perfeito = []
  tamanho = 50
  resposta = [1] * tamanho
  for i in range(tamanho):
    resposta[i] = randint(1,1000)
  #verificacao de perfeito
    if ePerfeito(resposta[i]):
     perfeito.append(resposta[i]) 
  print ("Geração de lista aleatória concluída:", resposta, "\n","Número total de elementos:",tamanho )
  if len(perfeito) != 0 :
    print("\n",perfeito, "é perfeito")
  else: 
    print("Não foram achados numeros perfeitos")
    
 
  return 

def ePerfeito(n):

  soma = 0
  
  for div in range(1,n):
      if n % div == 0:
        soma += div 

  if n == soma:
    return True
  else: 
    return False
  
listarand()

