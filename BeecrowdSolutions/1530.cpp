#include <iostream>
#include <cstring>
using namespace std;

const int ALPHABET_SIZE = 26;
const int MAX_CHARS = 200000;

struct State {
    int len; // Comprimento do estado atual
    int link; // Índice do estado pai no autômato de sufixo
    int next[ALPHABET_SIZE]; // Array de próximos estados para cada caractere do alfabeto
};

class SuffixAutomata {
    State* m_state; // Array de estados do autômato
    int m_stateCount; // Contador de estados
    int m_last; // Índice do último estado adicionado
    long long m_uniqueSubstrings; // Contador de substrings únicas

public:
    SuffixAutomata(unsigned int maxStates); // Construtor
    void extend(int sym); // Estende o autômato com o símbolo dado
    void reset(); // Reinicia o autômato
    long long getUniqueSubstrings() const; // Retorna o número de substrings únicas
};

SuffixAutomata::SuffixAutomata(unsigned int maxStates) {
    m_state = new State[maxStates];
    reset();
}

void SuffixAutomata::extend(int sym) {
    int cur = m_stateCount++;
    m_state[cur].len = m_state[m_last].len + 1;
    memset(m_state[cur].next, 0, sizeof(int) * ALPHABET_SIZE);

    int p;
    // Percorre os links de sufixo até encontrar um estado com o símbolo atual ou chegar à raiz
    for (p = m_last; p != -1 && m_state[p].next[sym] == 0; p = m_state[p].link) {
        m_state[p].next[sym] = cur;
    }

    if (p == -1) {
        // Se nenhum estado com o símbolo atual for encontrado, define o link do novo estado para a raiz
        m_state[cur].link = 0;
    } else {
        int q = m_state[p].next[sym];
        if (m_state[p].len + 1 == m_state[q].len)
            m_state[cur].link = q;
        else {
            int clone = m_stateCount++;
            m_state[clone].len = m_state[p].len + 1;
            memcpy(m_state[clone].next, m_state[q].next, sizeof(int) * ALPHABET_SIZE);
            m_state[clone].link = m_state[q].link;

            for (; p != -1 && m_state[p].next[sym] == q; p = m_state[p].link) {
                m_state[p].next[sym] = clone;
            }

            m_state[q].link = m_state[cur].link = clone;
        }
    }

    m_last = cur;
    m_uniqueSubstrings += m_state[cur].len - m_state[m_state[cur].link].len;
}

void SuffixAutomata::reset() {
    m_state[0].len = 0;
    m_state[0].link = -1;
    memset(m_state[0].next, 0, sizeof(int) * ALPHABET_SIZE);
    m_stateCount = 1;
    m_last = 0;
    m_uniqueSubstrings = 0;
}

long long SuffixAutomata::getUniqueSubstrings() const {
    return m_uniqueSubstrings;
}

int main() {
    string instructions;
    while (getline(cin, instructions)) {
        SuffixAutomata sa(MAX_CHARS * 2); // Cria uma nova instância do autômato de sufixo

        for (char c : instructions) {
            if (c >= 'a' && c <= 'z') {
                sa.extend(static_cast<int>(c - 'a')); // Estende o autômato com o símbolo atual
            } else if (c == '?') {
                cout << sa.getUniqueSubstrings() << endl; // Imprime o número de substrings únicas no autômato
            }
        }
    }

    return 0;
}
