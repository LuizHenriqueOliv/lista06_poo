import java.util.HashMap;
import java.util.Map;

class Usuario {
    private String email;
    private String nome;
    private String senha;

    public Usuario(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Usuario { nome='" + nome + "', email='" + email + "' }";
    }
}

public class Exercicio4 {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public boolean inserirUsuario(Usuario usuario) {
        String chaveEmail = usuario.getEmail().toLowerCase().trim();
        if (usuarios.containsKey(chaveEmail)) {
            System.out.println("Erro: Já existe um usuário cadastrado com o e-mail " + usuario.getEmail());
            return false;
        }
        usuarios.put(chaveEmail, usuario);
        System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso!");
        return true;
    }

    public void listarUsuarios() {
        System.out.println("\n--- Lista de Usuários ---");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Usuario u : usuarios.values()) {
            System.out.println(u);
        }
    }

    public boolean removerUsuario(String email) {
        String chaveEmail = email.toLowerCase().trim();
        Usuario removido = usuarios.remove(chaveEmail);
        if (removido != null) {
            System.out.println("Usuário " + removido.getNome() + " removido com sucesso!");
            return true;
        }
        System.out.println("Usuário com e-mail " + email + " não encontrado.");
        return false;
    }

    public static void main(String[] args) {
        Exercicio4 sistema = new Exercicio4();

        sistema.inserirUsuario(new Usuario("ana@email.com", "Ana Silva", "1234"));
        sistema.inserirUsuario(new Usuario("carlos@email.com", "Carlos Souza", "abcd"));
        // Tentativa de inserir e-mail duplicado
        sistema.inserirUsuario(new Usuario("ANA@email.com", "Ana Clone", "9999"));

        sistema.listarUsuarios();

        sistema.removerUsuario("carlos@email.com");
        sistema.listarUsuarios();
    }
}