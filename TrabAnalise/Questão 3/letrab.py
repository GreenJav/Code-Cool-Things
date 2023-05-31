def counting_sort(arr, exp):
    n = len(arr)
    count = [0] * 10
    output = [0] * n

    # Conta a ocorrência de cada dígito no exp-ésimo lugar
    for i in range(n):
        index = int(arr[i][exp])
        count[index] += 1

    # Calcula as posições finais dos dígitos
    for i in range(1, 10):
        count[i] += count[i - 1]

    # Constrói a sequência ordenada com base nos dígitos
    for i in range(n - 1, -1, -1):
        index = int(arr[i][exp])
        output[count[index] - 1] = arr[i]
        count[index] -= 1

    # Atualiza a sequência original com a sequência ordenada
    for i in range(n):
        arr[i] = output[i]

def radix_sort(arr):
    max_length = len(max(arr, key=len))

    # Adiciona zeros à esquerda para tornar todos os CEPs do mesmo tamanho
    for i in range(len(arr)):
        arr[i] = arr[i].zfill(max_length)

    # Ordena por cada dígito, do menos significativo ao mais significativo
    for exp in range(max_length - 1, -1, -1):
        counting_sort(arr, exp)

    return arr

# Exemplo de uso com CEPs de Belém-PA
ceps = [
    '66000-000', '66000-001', '66000-002', '66000-100',
    '66000-101', '66000-200', '66000-201', '66000-300',
    '66000-400', '66000-500', '66000-501', '66001-000',
    '66001-001', '66001-100', '66001-101', '66001-200'
]

sorted_ceps = radix_sort(ceps)
print(sorted_ceps)




######adicionalcomparativo#################
import time
import random
import matplotlib.pyplot as plt

# Geração de dados aleatórios para diferentes tamanhos de sequência
sequence_sizes = [1000, 5000, 10000, 20000, 50000]
execution_times = []

for size in sequence_sizes:
    ceps = random.choices(range(10000000), k=size)  # Gera CEPs aleatórios com base nos números entre 0 e 9999999

    start_time = time.time()
    radix_sort(ceps)
    end_time = time.time()
    execution_time = end
###########################################