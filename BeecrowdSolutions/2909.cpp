#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

constexpr int MAXN = 1e3 + 10; // Tamanho máximo da entrada
constexpr long long MOD = 1e9 + 7; // Valor do módulo

int n, sz[MAXN]; // Quantidade de frutas, tamanho dos grupos
std::pair<int, int> vet[MAXN]; // Coordenadas das frutas
long long ans, fat[MAXN], ifat[MAXN]; // Variáveis para cálculos de fatorial

struct frac {
    long long num, den; // Numerador e denominador de uma fração
    frac() = default;
    frac(long long a, long long b) : num(a), den(b) { }
    bool operator<(const frac& f) const { return num * f.den < f.num * den; }
    bool operator==(const frac& f) const { return num * f.den == f.num * den; }
};

int pnts_sz; // Tamanho do vetor de pontos
frac pnts[MAXN * MAXN]; // Vetor de pontos
std::map<int, std::vector<int>> ints[MAXN * MAXN]; // Mapa de intervalos
std::vector<std::vector<int>> gps[MAXN * MAXN]; // Vetor de grupos de filhos

long long modpow(long long b, long long e) {
    long long ret = 1;
    while (e > 0) {
        if (e & 1) ret = (ret * b) % MOD;
        b = (b * b) % MOD;
        e >>= 1;
    }
    return ret;
}

int main() {
    fat[0] = ifat[0] = 1;
    for (int i = 1; i < MAXN; i++) {
        fat[i] = (i * fat[i - 1]) % MOD; // Cálculo do fatorial
        ifat[i] = modpow(fat[i], MOD - 2); // Cálculo do inverso do fatorial
    }

    const auto nao_intersec = [](int i, int j) {
        return (vet[j].first <= vet[i].first && vet[j].second <= vet[i].second) ||
            (vet[i].first <= vet[j].first && vet[i].second <= vet[j].second);
    };

    std::cin >> n; // Leitura da quantidade de frutas
    int it = 0;
    for (int i = 0; i < n; i++) {
        std::cin >> vet[it].first >> vet[it].second; // Leitura das coordenadas das frutas
        sz[it] = 1;

        for (int j = 0; j < it; j++) {
            if (vet[j].first == vet[it].first && vet[j].second == vet[it].second) {
                // Se duas frutas forem iguais, elas são agrupadas e a contagem é atualizada
                sz[j] += sz[it];
                sz[it] = 0;
                it--;
                break;
            }

            if (nao_intersec(it, j)) continue; // Se as frutas não têm interseção, ignorar

            int da = vet[it].first - vet[j].first;
            int db = vet[j].second - vet[it].second;

            if (da < 0) {
                da = -da;
                db = -db;
            }

            int d = std::__gcd(da, db); // Calcula o MDC entre da e db
            da /= d;
            db /= d;

            pnts[pnts_sz++] = {db, da + db}; // Armazena a fração no vetor de pontos
        }
        it++;
    }
    n = it;

    std::sort(pnts, pnts + pnts_sz); // Ordena o vetor de pontos
    pnts_sz = (int) (std::unique(pnts, pnts + pnts_sz) - pnts); // Remove duplicatas

    long long tot = 1;
    for (int i = 0; i < n; i++) {
        tot = (tot * fat[sz[i]]) % MOD; // Calcula o valor total de arranjos possíveis
    }
    ans = tot;
    long long neg_tot = (MOD - tot) % MOD;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nao_intersec(i, j)) continue; // Se as frutas não têm interseção, ignorar

            int da = vet[i].first - vet[j].first;
            int db = vet[j].second - vet[i].second;

            if (da < 0) {
                da = -da;
                db = -db;
            }

            int d = std::__gcd(da, db); // Calcula o MDC entre da e db
            da /= d;
            db /= d;

            frac f{db, da + db};
            int p = (int) (std::lower_bound(pnts, pnts + pnts_sz, f) - pnts);
            int fx = db * vet[i].first + da * vet[i].second;

            std::vector<int>& s = ints[p][fx]; // Obtém o vetor de intervalos para a fração e valor de x
            s.push_back(i); // Adiciona os índices das frutas ao vetor
            s.push_back(j);
        }
    }

    for (int i = 0; i < pnts_sz; i++) {
        long long cur = tot;

        for (auto&& p : ints[i]) {
            std::vector<int>& v = p.second;
            std::sort(v.begin(), v.end());
            v.resize(std::unique(v.begin(), v.end()) - v.begin());
            gps[i].push_back(std::move(v)); // Armazena os grupos de filhos com interseção
        }
    }

    for (int i = 0; i < pnts_sz; i++) {
        long long cur = tot;

        for (auto&& gp : gps[i]) {
            int cnt = 0;

            for (int v : gp) {
                cnt += sz[v];
                cur = (cur * ifat[sz[v]]) % MOD;
            }

            cur = (cur * fat[cnt]) % MOD;
        }

        ans += cur;
        if (ans >= MOD) ans -= MOD;
        ans += neg_tot;
        if (ans >= MOD) ans -= MOD;
    }

    std::cout << ans << "\n"; // Imprime o resultado
    return 0;
}
