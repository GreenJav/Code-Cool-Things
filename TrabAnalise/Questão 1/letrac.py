import time
import random
import matplotlib.pyplot as plt

def quicksort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[len(arr) // 2]
        lesser = [x for x in arr if x < pivot]
        equal = [x for x in arr if x == pivot]
        greater = [x for x in arr if x > pivot]
        return quicksort(lesser) + equal + quicksort(greater)

def generate_sequence(size):
    return random.sample(range(1, size+1), size)

def test_execution_time(sequence):
    start_time = time.time()
    quicksort(sequence)
    end_time = time.time()
    return end_time - start_time

# Teste de tempo de execução com sequências ordenadas de forma crescente, decrescente e desordenadas
sequence_sizes = [100, 1000, 10000, 100000]
sorted_times = []
reverse_times = []
random_times = []

for size in sequence_sizes:
    sorted_sequence = list(range(1, size+1))
    reverse_sequence = list(range(size, 0, -1))
    random_sequence = generate_sequence(size)

    sorted_time = test_execution_time(sorted_sequence)
    reverse_time = test_execution_time(reverse_sequence)
    random_time = test_execution_time(random_sequence)

    sorted_times.append(sorted_time)
    reverse_times.append(reverse_time)
    random_times.append(random_time)

# Plotando os gráficos
plt.plot(sequence_sizes, sorted_times, label='Ordenado (crescente)')
plt.plot(sequence_sizes, reverse_times, label='Ordenado (decrescente)')
plt.plot(sequence_sizes, random_times, label='Desordenado')

plt.xlabel('Tamanho da Sequência')
plt.ylabel('Tempo de Execução (segundos)')
plt.title('Tempo de Execução do Quicksort')
plt.legend()
plt.show()
