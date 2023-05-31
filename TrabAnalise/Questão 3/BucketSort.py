def bucket_sort(arr):
    # Determina o número de baldes
    num_buckets = len(arr)

    # Cria os baldes
    buckets = [[] for _ in range(num_buckets)]

    # Distribui os elementos nos baldes
    for num in arr:
        bucket_index = int(num * num_buckets)
        buckets[bucket_index].append(num)

    # Ordena individualmente cada balde usando um algoritmo de ordenação auxiliar
    for bucket in buckets:
        bucket.sort()

    # Combina os elementos ordenados dos baldes
    sorted_arr = [num for bucket in buckets for num in bucket]

    return sorted_arr
