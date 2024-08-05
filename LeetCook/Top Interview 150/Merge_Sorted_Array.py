#05.08.2024

# Explicando Merge_Sorted_Array do LeetCode

# O objetivo desse exercicio eh a mesclagem de arrays de maneira eficiente
# O tempo O(m + n) pedido significa que o tempo necessario para executar o algoritmo eh proporcional a soma do num de elementos nos dois arrays

from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        # Ponteiros para os finais das partes relevantes dos arrays
        p1, p2, p = m - 1, n - 1, m + n - 1

        # Mesclar nums1 e nums2 começando do final
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] > nums2[p2]:
                nums1[p] = nums1[p1]
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1
            p -= 1

        # Caso ainda existam elementos em nums2
        nums1[:p2 + 1] = nums2[:p2 + 1]



