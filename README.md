## Experimento de Análise de Algoritmos de Ordenação

### Introdução

Este experimento visa comparar o desempenho de cinco algoritmos de ordenação amplamente utilizados: MergeSort, QuickSort, BubbleSort, InsertionSort e SelectionSort. Cada algoritmo foi avaliado em três cenários distintos: números aleatórios, números decrescentes e números crescentes. A análise dos tempos de execução destes algoritmos em diferentes contextos oferece insights valiosos sobre suas eficiências relativas.

### Metodologia

#### Implementação dos Algoritmos de Ordenação:

- **MergeSort:** Algoritmo de ordenação por divisão e conquista que divide a lista em sublistas ordenadas e combina essas sublistas para obter a lista final ordenada.
- **QuickSort:** Algoritmo de ordenação por divisão e conquista que escolhe um elemento como pivô e organiza os outros elementos em torno dele.
- **BubbleSort:** Algoritmo de ordenação que compara elementos adjacentes e os troca se estiverem na ordem errada.
- **InsertionSort:** Algoritmo de ordenação que constrói uma sequência ordenada de elementos, um de cada vez, inserindo elementos não ordenados na posição correta.
- **SelectionSort:** Algoritmo de ordenação que seleciona repetidamente o menor (ou maior) elemento da lista não ordenada e o move para o início (ou final) da lista ordenada.

#### Geração de Dados:

- Três conjuntos de dados foram gerados, cada um com 10.000 elementos: números aleatórios, números decrescentes e números crescentes.

#### Avaliação de Desempenho:

- Cada algoritmo foi executado 10 vezes para cada cenário.
- O tempo de execução foi medido usando `System.currentTimeMillis()`.
- Para cada cenário, o tempo médio de execução foi calculado a partir das 10 execuções.

### Resultados Obtidos

#### Números Aleatórios:
- **MergeSort:** 1 ms
- **QuickSort:** 0 ms
- **BubbleSort:** 64 ms
- **InsertionSort:** 7 ms
- **SelectionSort:** 17 ms

#### Números Decrescentes:
- **MergeSort:** 0 ms
- **QuickSort:** 19 ms
- **BubbleSort:** 60 ms
- **InsertionSort:** 7 ms
- **SelectionSort:** 17 ms

#### Números Crescentes:
- **MergeSort:** 0 ms
- **QuickSort:** 26 ms
- **BubbleSort:** 0 ms
- **InsertionSort:** 0 ms
- **SelectionSort:** 16 ms

### Discussão e Conclusões

- O **QuickSort** demonstrou ser o algoritmo mais eficiente em uma variedade de cenários, com tempo de execução próximo a 0 ms em muitos casos.
- O **BubbleSort** mostrou-se o menos eficiente, especialmente em conjuntos de dados aleatórios, onde seu tempo de execução foi significativamente maior.
- O **SelectionSort** surpreendeu ao superar o **QuickSort** em cenários de dados crescentes, mostrando que em certos contextos, algoritmos aparentemente simples podem se destacar.
- A escolha do algoritmo de ordenação deve ser feita considerando o contexto específico em que será aplicado, pois cada algoritmo tem seus pontos fortes e fracos.

Este experimento proporcionou uma visão detalhada da eficiência dos algoritmos de ordenação em diferentes situações, contribuindo para uma compreensão mais profunda de suas complexidades e aplicações na ciência da computação.
