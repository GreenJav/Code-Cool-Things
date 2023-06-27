#include <iostream>
#include <cstring>

using namespace std;
#define MAXSIZE 100

struct NoArvore {
    char letra;
    NoArvore* esquerda;
    NoArvore* direita;
};

// Funções para percurso infixo, prefixo e posfixo
void infixa(NoArvore*);
void prefixa(NoArvore*);
void posfixa(NoArvore*);

// Funções auxiliares para impressão dos percursos
void printInfixa(char*);
void printPrefixa(char*);
void printPosfixa(char*);

// Função para inserir um elemento na árvore
NoArvore* push(NoArvore*, char);

// Função para buscar um elemento na árvore
bool busca(NoArvore*, char);

// Arrays para armazenar os elementos dos percursos
char letrasInfixa[MAXSIZE] = {0};
char letrasPosfixa[MAXSIZE] = {0};
char letrasPrefixa[MAXSIZE] = {0};

int i = 0;
int j = 0;
int k = 0;

void teste(NoArvore* no) {
    if (no) {
        teste(no->esquerda);
        cout << no->letra << " ";
        teste(no->direita);
    }
}

int main() {
    char comando[20], letra;

    NoArvore* no = NULL;
    while (cin >> comando) {
        if (strcmp(comando, "I") == 0) {
            cin >> letra;
            no = push(no, letra); // Inserir elemento na árvore
        } else if (strcmp(comando, "INFIXA") == 0) {
            infixa(no); // Percorrer a árvore em ordem infixa
            printInfixa(letrasInfixa); // Imprimir elementos em ordem infixa
        } else if (strcmp(comando, "PREFIXA") == 0) {
            prefixa(no); // Percorrer a árvore em ordem prefixa
            printPrefixa(letrasPrefixa); // Imprimir elementos em ordem prefixa
        } else if (strcmp(comando, "P") == 0) {
            cin >> letra;
            if (busca(no, letra))
                cout << letra << " existe" << endl; // Verificar se o elemento existe na árvore
            else
                cout << letra << " nao existe" << endl;
        } else {
            posfixa(no); // Percorrer a árvore em ordem posfixa
            printPosfixa(letrasPosfixa); // Imprimir elementos em ordem posfixa
        }
    }

    return 0;
}

// Função para inserir um elemento na árvore
NoArvore* push(NoArvore* no, char letra) {
    if (!no) {
        no = new NoArvore();
        no->letra = letra;
        no->direita = no->esquerda = nullptr;
    } else if (no->letra > letra) {
        no->esquerda = push(no->esquerda, letra); // Inserir na subárvore esquerda
    } else {
        no->direita = push(no->direita, letra); // Inserir na subárvore direita
    }
    return no;
}

// Função para buscar um elemento na árvore
bool busca(NoArvore* no, char letra) {
    if (!no) {
        return false; // Elemento não encontrado
    }
    if (no->letra == letra) {
        return true; // Elemento encontrado
    }
    if (no->letra > letra) {
        return busca(no->esquerda, letra); // Buscar na subárvore esquerda
    } else {
        return busca(no->direita, letra); // Buscar na subárvore direita
    }
}

// Função para imprimir o percurso infixo
void printInfixa(char* letras) {
    for (int z = 0; z < i; ++z) {
        if (!z) {
            cout << letrasInfixa[z];
        } else {
            cout << " " << letrasInfixa[z];
        }
    }
    i = 0;
    cout << endl;
}

// Função para imprimir o percurso prefixo
void printPrefixa(char* letras) {
    for (int z = 0; z < k; ++z) {
        if (!z) {
            cout << letrasPrefixa[z];
        } else {
            cout << " " << letrasPrefixa[z];
        }
    }
    k = 0;
    cout << endl;
}

// Função para imprimir o percurso posfixo
void printPosfixa(char* letras) {
    for (int z = 0; z < j; ++z) {
        if (!z) {
            cout << letrasPosfixa[z];
        } else {
            cout << " " << letrasPosfixa[z];
        }
    }
    j = 0;
    cout << endl;
}

// Função recursiva para percorrer a árvore em ordem infixa
void infixa(NoArvore* no) {
    if (no) {
        infixa(no->esquerda); // Percorrer a subárvore esquerda
        letrasInfixa[i++] = no->letra; // Armazenar elemento
        infixa(no->direita); // Percorrer a subárvore direita
    }
}

// Função recursiva para percorrer a árvore em ordem posfixa
void posfixa(NoArvore* no) {
    if (no) {
        posfixa(no->esquerda); // Percorrer a subárvore esquerda
        posfixa(no->direita); // Percorrer a subárvore direita
        letrasPosfixa[j++] = no->letra; // Armazenar elemento
    }
}

// Função recursiva para percorrer a árvore em ordem prefixa
void prefixa(NoArvore* no) {
    if (no) {
        letrasPrefixa[k++] = no->letra; // Armazenar elemento
        prefixa(no->esquerda); // Percorrer a subárvore esquerda
        prefixa(no->direita); // Percorrer a subárvore direita
    }
}
