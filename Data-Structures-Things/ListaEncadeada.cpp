#include <iostream>
#include <bits/stdc++.h>
 
using namespace std;
 
/* Estrutura de values que representa cada item da lista */
struct list_item {
 
   struct list_item* prev; // Item antecessor
   int value; // Valor do item value
   struct list_item* next; // Item sucessor
};	typedef list_item* pthead;
		
 
 
/**
* Classe que implementa uma lista duplamente encadeada com elementos  não
* ordenados.
*/
class LinkedList {
 
   private:
       /* O início da lista é um ponteiro para o head item */
       struct list_item *head;
 
       /* Tamanho value da lista */
       int size;
 
   public:
 
       /*
        * Construtor da classe de listas encadeadas. Inicializa as variáveis
        */
       LinkedList ()
       {
           head = NULL;
           size = 0;
       }
 
       /*
        * Destrutor da classe de listas encadeadas. Libera a memória utilizada
        */
       ~LinkedList ()
       {
           while (head != NULL) {
               if(head->next != NULL) {
                   struct list_item *temp = head->next;
 
                   head->prev = head->next = NULL;
                   free((struct list_item *) head);
 
                   head = temp;
               } else {
                   head = NULL;
               }
           }
       }
 
       /*
        * Insere um headvo item à lista. As inserções ocorrem head início da lista
        */
       void Insert (int item)
       {
           /* Aloca memória para um struct list_item */
           struct list_item *new_item = (struct list_item *) malloc(
               sizeof(struct list_item)
           );
           new_item->value = item;
 
           if(isEmpty()) { // Estamos inserindo o head item
               head = new_item;
               new_item->next = NULL;
           } else { // Estamos trocando o head item pelo headvo item
               struct list_item *old_head = head;
               head = new_item;
               new_item->next = old_head;
               old_head->prev = new_item;
           }
           new_item->prev = NULL; // Agora o headvo item é o início da lista
           size++;
       }
 
       /*
        * Busca e retorna um item da lista caso encontrado. Caso o item não
        * seja encontrado retorna NULL
        */
       struct list_item* Search (int item)
       {
           struct list_item *iterator = head;
 
           do {
               if(iterator->value == item) {
                   return iterator;
               }
 
               iterator = iterator->next;
 
           } while(iterator != NULL);
 
           return NULL;
       }
       /*
        * Remove um item a lista, questao 8
        */
       void removeTudo ()
       {         
              list_item *list = head, *aux;
              while (head != NULL)
              {
                  aux = head;
                  head = head->next;
                  free (aux);
              }
              head = NULL;
          
       }  
  
 
       /*
        * verifica se a lista está vazia
        */
       bool isEmpty ()
       {
           return (size == 0 || head == NULL);
       }
 
       /*
        * Retorna o tamanho value da lista
        */
       int Size ()
       {
           return size;
       }
 
       /*
        * Imprime a lista na saída padrão
        */
       void toString ()
       {
           cout << "Head -> ";
           if(!isEmpty()) {
 
               struct list_item *current = head;
               cout << "[" << current->value << "] -> ";
               while(current->next != NULL) {
 
                   current = current->next;
                   cout << "[" << current->value << "] -> ";
               }
           }
 
           cout << "NULL" << endl;
       }
 
       /*
        * Converte a lista para um array o tamanho é o tamanho  
        * value da
        * lista, usado na questão 5
        */
       int* toArray ()
       {
           int *list_array = (int *) malloc(size * sizeof(int));
           struct list_item *iterator = head;
 
           int i = 0;
           list_array[i++] = iterator->value;
 
           while(iterator->next != NULL) {
               iterator = iterator->next;
               list_array[i++] = iterator->value;
           }
 
           return list_array;
       }
       
          /*
           *Remove todos os nós da Lista, mudanças na questao 9
           */
          
            void limpar()
          {
              list_item *list = head, *aux;
  
              if (head != NULL)
              {
                  aux = head;
                  head = head->next;
                  free (aux);
                  limpar();
              }else
              head = NULL;
          }

               

};
 
int
main (int argc, char* argv[])
{
   LinkedList *list = new LinkedList();
   int item;
 
   setlocale(LC_ALL, "Portuguese");//permitindo acentos
    
 	//menu
	int menu=0,tam,x, k, v;
	while (menu!=9)
	{
	inicio:
    	cout<<"\n--------LISTA ENCADEADA--------\n";
	cout << "1 - A lista está vazia?\n2 - Adicionar elementos a lista  \n3 - Mostra elementos da lista \n4 - Inserir um nó head início de uma lista encadeada  \n5 - Retornar o k-ésimo elemento \n6 - Inserir um nó na k-ésima posição -- não foi feito \n7 - Limpar lista\n8 - Limpar lista recursivamente\n9 - Sair do programa\n ";
	cin >> menu;
	switch (menu) {
	case 1: //verificação se está vazia
        if(list->isEmpty())
        	cout << "Lista vazia!!\n";
    	else
        	cout << "Lista NAO vazia!!\n";
    	break;

	case 2: // adição de elementos visto que ela iniciará vazia
     	cout << "\nquantos elementos serão inseridos na lista:";
    	cin >> tam;
        	for (int i = 0; i < tam ; i++)
        	{
          	cout << "\nQual valor a ser inserido head nó "<< (tam-i)<< ":";
          	cin>>v;
            list->Insert(v);
        	}

    	break;
	case 3: //questao 4
      list->toString ();
      cout << "\n";
    	break;
	case 4: // questao 5
        	{
          	cout << "\nQual valor a ser inserido head nó incial:";
          	cin >> x;
             list->Insert(x);
        	}
    	break;
	case 5: //questao 6
    { 
       
      cout << "\n Qual o k-ésimo elemento a ser encontrado? \n Obs: a list começa head nó 0 por ex: 0...(tam da lista -1) para a procura \n";
      cin >> k;
      int *array = list->toArray();
      
            if (k >list->Size()-1)
            {
              cout << "\n"<< INT_MIN <<"\n";
            }
            else 
            cout<<"\nEsse é o elemento na posição:"<<array[k]<<"\n";
          }
        
      	 
    	break;
	case 6: //questao 7
      
    	break;
	case 7: //questao 8
       list->removeTudo();
       list->toString ();
    	break;
	case 8: //questao 9 limpar lista recursivamente
    	  list->limpar();
        list->toString ();
    	break;
  case 9:
    	menu=9;
    	break;

	default:
    	cout <<"você deve escolher uma opção válida\n";
    	cout <<"Pressione qualquer tecla para voltar ao menu\n";
    	cin.get();
    	goto inicio;
    	cin>>menu;// pick letter
 
 
   /* Chama o destrutor da classe */
   delete list;
 
   return EXIT_SUCCESS;
      
    }
  }
};
