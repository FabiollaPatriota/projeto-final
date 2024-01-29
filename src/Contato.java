import java.util.ArrayList;
import java.util.List;

public class Contato {
    private static int proximoID = 1; // ID único para cada contato
    private int id;
    private String nome;
    private List<String> telefones;

    // Construtor
    public Contato(String nome) {
        this.id = proximoID++;
        this.nome = nome;
        this.telefones = new ArrayList<>();
    }

    // Adicionar telefone
    public void adicionarTelefone(String telefone) {
        if (!telefones.contains(telefone)) {
            telefones.add(telefone);
        } else {
            System.out.println("O número de telefone já está associado a outro contato.");
        }
    }

    // Remover telefone
    public void removerTelefone(String telefone) {
        telefones.remove(telefone);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Telefones: " + telefones;
    }
}
