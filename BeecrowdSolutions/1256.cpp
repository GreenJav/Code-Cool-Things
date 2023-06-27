#include <iostream>
#include <vector>

using namespace std;

const int MAX = 100;

struct Node {
    Node* next;
    int value;

    Node(int val) : value(val), next(nullptr) {}
};

struct TDes {
    Node* inicio;
    Node* final;

    TDes() : inicio(nullptr), final(nullptr) {}
};

void inicializa(TDes* vetor, int n) {
    // Inicializa as listas encadeadas de cada posição da tabela de dispersão
    for (int i = 0; i < n; i++) {
        vetor[i].inicio = nullptr;
        vetor[i].final = nullptr;
    }
}

void insereNo(TDes* vetor, int ind, int e) {
    // Insere um novo nó com valor 'e' na lista encadeada da posição 'ind' da tabela de dispersão
    Node* aux = new Node(e);
    aux->next = nullptr;

    if (vetor[ind].inicio == nullptr) {
        // Se a lista estiver vazia, o novo nó será o primeiro
        vetor[ind].inicio = aux;
    } else {
        // Caso contrário, o novo nó será inserido no final da lista
        vetor[ind].final->next = aux;
    }

    // Atualiza o ponteiro final para o novo nó inserido
    vetor[ind].final = aux;
}

void imprimiHash(Node* inicio, int ind) {
    // Imprime os elementos da lista encadeada
    Node* aux = inicio;

    cout << ind << " -> ";

    while (aux != nullptr) {
        // Imprime o valor do nó atual
        cout << aux->value << " -> ";

        // Avança para o próximo nó na lista
        aux = aux->next;
    }

    // Indica o final da lista
    cout << "\\" << endl;
}

int main() {
    TDes vetor[MAX];
    int key, num, n, e, i, j;

    cin >> n;

    for (j = 0; j < n; j++) {
        cin >> key >> num;
        inicializa(vetor, key);

        for (i = 0; i < num; i++) {
            cin >> e;
            insereNo(vetor, e % key, e);
        }

        for (i = 0; i < key; i++) {
            // Imprime a lista encadeada correspondente a cada posição da tabela de dispersão
            imprimiHash(vetor[i].inicio, i);
        }

        if (j + 1 < n) {
            // Adiciona uma linha em branco após cada caso de teste, exceto o último
            cout << endl;
        }
    }

    return 0;
}
