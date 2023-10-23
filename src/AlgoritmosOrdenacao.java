import java.util.Arrays;
import java.util.Random;

public class AlgoritmosOrdenacao {

    public static void main(String[] args) {
        int[] numerosAleatorios = gerarNumerosAleatorios(10000);
        int[] numerosDecrescentes = gerarNumerosDecrescentes(10000);
        int[] numerosCrescentes = gerarNumerosCrescentes(10000);

        String[] algoritmos = {"MergeSort", "QuickSort", "BubbleSort", "InsertionSort", "SelectionSort"};

        int[][] cenarios = {numerosAleatorios, numerosDecrescentes, numerosCrescentes};

        for (int[] cenario : cenarios) {
            for (String algoritmo : algoritmos) {
                long tempoTotal = 0;
                for (int i = 0; i < 10; i++) {
                    int[] numerosCopia = Arrays.copyOf(cenario, cenario.length);
                    long tempoInicio = System.currentTimeMillis();
                    switch (algoritmo) {
                        case "MergeSort":
                            mergeSort(numerosCopia);
                            break;
                        case "QuickSort":
                            quickSort(numerosCopia, 0, numerosCopia.length - 1);
                            break;
                        case "BubbleSort":
                            bubbleSort(numerosCopia);
                            break;
                        case "InsertionSort":
                            insertionSort(numerosCopia);
                            break;
                        case "SelectionSort":
                            selectionSort(numerosCopia);
                            break;
                    }
                    long tempoFim = System.currentTimeMillis();
                    tempoTotal += (tempoFim - tempoInicio);
                }
                long tempoMedio = tempoTotal / 10;
                System.out.println("Tempo médio gasto pelo " + algoritmo + " neste cenário: " + tempoMedio + " milissegundos");
            }
        }
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int meio = array.length / 2;
        int[] metadeEsquerda = Arrays.copyOfRange(array, 0, meio);
        int[] metadeDireita = Arrays.copyOfRange(array, meio, array.length);
        mergeSort(metadeEsquerda);
        mergeSort(metadeDireita);
        merge(array, metadeEsquerda, metadeDireita);
    }

    private static void merge(int[] resultado, int[] metadeEsquerda, int[] metadeDireita) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < metadeEsquerda.length && j < metadeDireita.length) {
            if (metadeEsquerda[i] < metadeDireita[j]) {
                resultado[k++] = metadeEsquerda[i++];
            } else {
                resultado[k++] = metadeDireita[j++];
            }
        }
        while (i < metadeEsquerda.length) {
            resultado[k++] = metadeEsquerda[i++];
        }
        while (j < metadeDireita.length) {
            resultado[k++] = metadeDireita[j++];
        }
    }

    public static void quickSort(int[] array, int baixo, int alto) {
        if (baixo < alto) {
            int indiceParticao = particionar(array, baixo, alto);
            quickSort(array, baixo, indiceParticao - 1);
            quickSort(array, indiceParticao + 1, alto);
        }
    }

    private static int particionar(int[] array, int baixo, int alto) {
        int pivo = array[alto];
        int i = baixo - 1;
        for (int j = baixo; j < alto; j++) {
            if (array[j] <= pivo) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;
        return i + 1;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    trocou = true;
                }
            }
            n--;
        } while (trocou);
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int chave = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = chave;
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = array[indiceMenor];
            array[indiceMenor] = array[i];
            array[i] = temp;
        }
    }

    public static int[] gerarNumerosAleatorios(int tamanho) {
        int[] numeros = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            numeros[i] = random.nextInt(tamanho * 10); // Gera números aleatórios até 10 vezes o tamanho
        }
        return numeros;
    }

    public static int[] gerarNumerosDecrescentes(int tamanho) {
        int[] numeros = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            numeros[i] = tamanho - i;
        }
        return numeros;
    }

    public static int[] gerarNumerosCrescentes(int tamanho) {
        int[] numeros = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            numeros[i] = i + 1;
        }
        return numeros;
    }
}
