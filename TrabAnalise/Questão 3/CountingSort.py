def counting_sort(arr):
    # Encontra o valor máximo na sequência para determinar o tamanho do array de contagem
    max_value = max(arr)
    count_array = [0] * (max_value + 1)

    # Conta a ocorrência de cada elemento na sequência
    for num in arr:
        count_array[num] += 1

    # Constrói a sequência ordenada com base no array de contagem
    sorted_arr = []
    for num, count in enumerate(count_array):
        sorted_arr.extend([num] * count)

    return sorted_arr
