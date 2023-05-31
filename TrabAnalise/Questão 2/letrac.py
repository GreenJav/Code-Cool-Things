import time
import random
import matplotlib.pyplot as plt

def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[largest]:
        largest = left

    if right < n and arr[right] > arr[largest]:
        largest = right

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heapsort(arr):
    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)

def generate_sequence(size):
    return random.sample(range(1, size+1), size)

def test_execution_time(sequence, algorithm):
    start_time = time.time()
    algorithm(sequence)
    end_time = time.time()
    return end_time - start_time

# Teste de tempo de execução para sequências ordenadas em ordem crescente, decrescente e desordenadas
sequence_sizes = [100, 1000, 10000, 100000]
sorted_times = []
reverse_times = []
random_times = []

for size in sequence_sizes:
    sorted_sequence = list(range(1, size+1))
    reverse_sequence = list(range(size, 0, -1))
    random_sequence = generate_sequence(size)

    sorted_time = test_execution_time(sorted_sequence, heapsort)
    reverse_time = test_execution_time(reverse_sequence, heapsort)
    random_time = test_execution_time(random_sequence, heapsort)

    sorted_times.append(sorted_time)
    reverse_times.append(reverse_time)
    random_times.append(random_time)

# Plotando os gráficos
plt.plot(sequence_sizes, sorted_times, label='Crescente')
plt.plot(sequence_sizes, reverse_times, label='Decrescente')
plt.plot(sequence_sizes, random_times, label='Desordenada')

plt.xlabel('Tamanho da Sequência')
plt.ylabel('Tempo de Execução (segundos)')
plt.title('Desempenho do HeapSort em diferentes sequências')
plt.legend()
plt.show()
