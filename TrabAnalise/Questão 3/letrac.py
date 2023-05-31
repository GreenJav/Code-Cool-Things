import time
import random
import matplotlib.pyplot as plt

def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

def bucket_sort(arr):
    n = len(arr)
    buckets = [[] for _ in range(n)]

    for num in arr:
        index = int(num * n)
        buckets[index].append(num)

    for i in range(n):
        insertion_sort(buckets[i])

    sorted_arr = []
    for bucket in buckets:
        sorted_arr.extend(bucket)

    return sorted_arr

# Teste de tempo de execução para sequências uniformemente distribuídas
sequence_sizes = [1000, 5000, 10000, 20000, 50000]
uniform_execution_times = []

for size in sequence_sizes:
    sequence = [random.random() for _ in range(size)]

    start_time = time.time()
    bucket_sort(sequence)
    end_time = time.time()
    execution_time = end_time - start_time

    uniform_execution_times.append(execution_time)

# Teste de tempo de execução para sequências não uniformemente distribuídas
non_uniform_execution_times = []

for size in sequence_sizes:
    sequence = [random.random()**2 for _ in range(size)]

    start_time = time.time()
    bucket_sort(sequence)
    end_time = time.time()
    execution_time = end_time - start_time

    non_uniform_execution_times.append(execution_time)

# Plotando o gráfico
plt.plot(sequence_sizes, uniform_execution_times, label='Uniforme')
plt.plot(sequence_sizes, non_uniform_execution_times, label='Não Uniforme')
plt.xlabel('Tamanho da Sequência')
plt.ylabel('Tempo de Execução (segundos)')
plt.title('Tempo de Execução do BucketSort')
plt.legend()
plt.show()
