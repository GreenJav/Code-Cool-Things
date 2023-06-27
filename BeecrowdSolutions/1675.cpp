#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;

const int n2 = 1 << 16; // deve ser uma potência de 2
string l[n2]; // os rótulos
int p[n2]; // as prioridades
int ost[2 * n2]; // uma árvore de ordem estatística contendo índices para rótulos e prioridades

// para ordenação comparando rótulos
bool lcmp(const int ia, const int ib) {
    return l[ia] < l[ib];
}

void recurse(int from, int to) {
    // r se tornará o índice em [from..to] com a maior prioridade
    int r = p[ost[from]] > p[ost[to]] ? from : to;
    // mova para cima na árvore até chegar ao predecessor comum
    for (int f = from, t = to; f < t; f /= 2, t /= 2) {
        // os nós internos entre f e t armazenam as prioridades máximas
        // dos nós nos subintervalos de (from..to)
        if ((f + 1 < t) && p[ost[f + 1]] > p[ost[r]])
            r = f + 1;
        if ((t - 1 > f) && p[ost[t - 1]] > p[ost[r]])
            r = t - 1;
    }
    // p[ost[r]] já é máxima em p[ost[from]]..p[ost[to]], mova para baixo
    // para encontrar o nó no nível inferior de onde esta prioridade se origina
    while (r < n2) {
        if (ost[r] == ost[r * 2])
            r = r * 2;
        else if (ost[r] == ost[r * 2 + 1])
            r = r * 2 + 1;
    }
    // divida [from..to] em um sub-treap esquerdo e um sub-treap direito
    cout << '(';
    if (from < r)
        recurse(from, r - 1);
    cout << l[ost[r]] << '/' << p[ost[r]];
    if (r < to)
        recurse(r + 1, to);
    cout << ')';
}

int main() {
    int n;
    while (cin >> n) {
        if (n == 0)
            break;

        // analisa os rótulos e prioridades
        for (int i = 0; i < n; i++) {
            string s;
            cin >> s;
            int separator = s.find('/');

            l[i] = s.substr(0, separator);
            sscanf(s.substr(separator + 1).c_str(), "%d", &p[i]);
        }
        // o nível inferior da árvore de ordem estatística consiste nos rótulos em ordem
        for (int i = 0; i < n; i++)
            ost[n2 + i] = i;
        sort(ost + n2, ost + n2 + n, lcmp);

        // constrói os níveis superiores da árvore
        for (int a = n2, b = n2 + n - 1; a > 1; a /= 2, b /= 2) {
            for (int i = a; i < b; i += 2) {
                ost[i / 2] = p[ost[i]] > p[ost[i + 1]] ? ost[i] : ost[i + 1];
            }
            if (b % 2 == 0) // o nó mais à direita é o único filho de seu pai
                ost[b / 2] = ost[b];
        }
        // recursivamente imprime o treap
        recurse(n2, n2 + n - 1);
        cout << endl;
    }
    return 0;
}
