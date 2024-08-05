//05.08.2024

// Explicando Merge_Sorted_Array do LeetCode

// O objetivo desse exercicio eh a mesclagem de arrays de maneira eficiente
// O tempo O(m + n) pedido significa que o tempo necessario para executar o algoritmo eh proporcional a soma do num de elementos nos dois arrays

#include <vector>
#include <iostream>
#include <cstdio>

using namespace std;

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        // Ponteiros para os finais das partes relevantes dos arrays
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        // Mesclar nums1 e nums2 começando do final
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Caso ainda existam elementos em nums2
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
};