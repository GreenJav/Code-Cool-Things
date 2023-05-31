def quicksort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[len(arr) // 2]
        lesser = [x for x in arr if x < pivot]
        equal = [x for x in arr if x == pivot]
        greater = [x for x in arr if x > pivot]
        return quicksort(lesser) + equal + quicksort(greater)

# Exemplo de uso
input_sequence = [63, 47, 81, 21, 94, 75, 13, 38, 97, 52]
sorted_sequence = quicksort(input_sequence)
print(sorted_sequence)