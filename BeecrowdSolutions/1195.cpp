#include <iostream>
using namespace std;

struct Node {
    Node* left;
    int value;
    Node* right;
};

// Função para encontrar o pai de um valor na árvore
Node* findParent(Node* root, int value) {
    if (root == nullptr) {
        return nullptr;
    } else if (value <= root->value) { // Se o valor é menor ou igual ao valor do nó raiz
        if (root->left == nullptr) {
            return root; // Retorna o nó atual como pai
        } else {
            return findParent(root->left, value); // Procura recursivamente no filho esquerdo
        }
    } else { // Se o valor é maior que o valor do nó raiz
        if (root->right == nullptr) {
            return root; // Retorna o nó atual como pai
        } else {
            return findParent(root->right, value); // Procura recursivamente no filho direito
        }
    }
}

// Percorre a árvore em pré-ordem e imprime os valores
void printPreOrder(Node* root) {
    if (root != nullptr) {
        cout << " " << root->value; // Imprime o valor do nó atual
        printPreOrder(root->left); // Percorre recursivamente o filho esquerdo
        printPreOrder(root->right); // Percorre recursivamente o filho direito
    }
}

// Percorre a árvore em ordem e imprime os valores
void printInOrder(Node* root) {
    if (root != nullptr) {
        printInOrder(root->left); // Percorre recursivamente o filho esquerdo
        cout << " " << root->value; // Imprime o valor do nó atual
        printInOrder(root->right); // Percorre recursivamente o filho direito
    }
}

// Percorre a árvore em pós-ordem e imprime os valores
void printPostOrder(Node* root) {
    if (root != nullptr) {
        printPostOrder(root->left); // Percorre recursivamente o filho esquerdo
        printPostOrder(root->right); // Percorre recursivamente o filho direito
        cout << " " << root->value; // Imprime o valor do nó atual
    }
}

int main() {
    Node* root;
    Node* parent;
    Node* aux;
    int size, numCases, c, d, value;

    root = nullptr;
    cin >> numCases; // Lê o número de casos de teste

    for (c = 1; c <= numCases; c++) {
        root = nullptr;

        cin >> size; // Lê o tamanho do conjunto de números

        // Constrói a árvore a partir dos valores lidos
        for (d = 0; d < size; d++) {
            cin >> value; // Lê um valor

            aux = new Node(); // Cria um novo nó
            aux->value = value; // Atribui o valor ao nó
            aux->left = nullptr; // Define o filho esquerdo como nulo
            aux->right = nullptr; // Define o filho direito como nulo

            parent = findParent(root, value); // Encontra o pai do valor na árvore
            if (parent == nullptr) {
                root = aux; // Se o pai é nulo, o novo nó é a raiz da árvore
            } else if (value <= parent->value) {
                parent->left = aux; // Se o valor é menor ou igual ao pai, o novo nó é o filho esquerdo
            } else {
                parent->right = aux; // Se o valor é maior que o pai, o novo nó é o filho direito
            }
        }

        cout << "Case " << c << ":" << endl;

        // Imprime os percursos da árvore
        cout << "Pre.:";
        printPreOrder(root);
        cout << endl;

        cout << "In..:";
        printInOrder(root);
        cout << endl;

        cout << "Post:";
        printPostOrder(root);
        cout << endl << endl;
    }

    return 0;
}
