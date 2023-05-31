def radix_sort(arr):
    # Encontra o valor máximo na sequência para determinar o número de dígitos
    max_value = max(arr)
    num_digits = len(str(max_value))

    # Faz o sorting por cada dígito em ordem crescente
    for i in range(num_digits):
        # Inicializa os baldes vazios
        buckets = [[] for _ in range(10)]

        # Distribui os elementos nos baldes com base no dígito atual
        for num in arr:
            digit = (num // (10 ** i)) % 10
            buckets[digit].append(num)

        # Reorganiza a sequência com base nos elementos nos baldes
        arr = [num for bucket in buckets for num in bucket]

    return arr
