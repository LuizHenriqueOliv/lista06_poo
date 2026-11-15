import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercicio6 {
    public static void main(String[] args) {
        // 1. Dada uma lista de inteiros, remover todos os elementos menores que 0
        List<Integer> numeros = Arrays.asList(-10, 5, -3, 0, 8, -1, 12, 4);
        List<Integer> naoNegativos = numeros.stream()
                .filter(n -> n >= 0)
                .collect(Collectors.toList());

        System.out.println("1. Números >= 0: " + naoNegativos);

        // 2. Dada uma lista de Strings, exibir todos os que iniciam com a letra P
        List<String> palavras = Arrays.asList("Python", "Java", "Programação", "Pilha", "Código", "pedra");
        System.out.print("2. Palavras que iniciam com 'P': ");
        palavras.stream()
                .filter(s -> s != null && s.toUpperCase().startsWith("P"))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 3. Dado um parágrafo de texto, adicionar todas as palavras em um conjunto e exibir as únicas
        String paragrafo = "Java é uma linguagem poderosa. Estudar Java e estruturas de dados torna a programação mais eficiente.";

        // Remove pontuação básica e divide pelos espaços em branco
        Set<String> palavrasUnicas = Arrays.stream(paragrafo.toLowerCase().replaceAll("[^a-záéíóúâêôãõç\\s]", "").split("\\s+"))
                .filter(palavra -> !palavra.isEmpty())
                .collect(Collectors.toSet());

        System.out.println("3. Palavras únicas no parágrafo (" + palavrasUnicas.size() + "):");
        System.out.println(palavrasUnicas);
    }
}