import java.util.ArrayDeque;
import java.util.Deque;

public class Exercicio5 {
    private Deque<String> historicoPaginas = new ArrayDeque<>();

    public void acessarPagina(String tituloPagina) {
        historicoPaginas.push(tituloPagina);
        System.out.println("Acessando: " + tituloPagina);
    }

    public void voltarPagina() {
        if (historicoPaginas.size() <= 1) {
            System.out.println("Não há página anterior para retornar.");
            return;
        }
        String paginaFechada = historicoPaginas.pop();
        System.out.println("Saindo de '" + paginaFechada + "' -> Voltando para: " + historicoPaginas.peek());
    }

    public void exibirPaginaAtual() {
        if (historicoPaginas.isEmpty()) {
            System.out.println("Nenhuma página aberta no momento.");
        } else {
            System.out.println("Página atual: " + historicoPaginas.peek());
        }
    }

    public static void main(String[] args) {
        Exercicio5 navegador = new Exercicio5();

        navegador.acessarPagina("Google - Pesquisa");
        navegador.acessarPagina("Documentação Oficial Java");
        navegador.acessarPagina("Java Collections Framework - Oracle");

        System.out.println();
        navegador.exibirPaginaAtual();

        System.out.println();
        navegador.voltarPagina();
        navegador.voltarPagina();
        navegador.voltarPagina();
    }
}