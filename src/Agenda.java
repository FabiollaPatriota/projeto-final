import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contato> contatos;

    // Construtor
    public Agenda() {
        contatos = new ArrayList<>();
    }

    // Adicionar Contato
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    // Adicionar ou Atualizar Contato com Telefone
    public void adicionarOuAtualizarContato(String nome, String telefone) {
        // Verificar se o número de telefone já está associado a outro contato
        for (Contato contato : contatos) {
            if (contato.getTelefones().contains(telefone)) {
                System.out.println("O número de telefone já está associado a outro contato.");
                return;
            }
        }

        // Verificar se o contato já existe
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                contato.adicionarTelefone(telefone);
                System.out.println("Telefone adicionado/atualizado para o contato: " + contato.getNome());
                return;
            }
        }

        // Se o contato não existir, criar um novo
        Contato novoContato = new Contato(nome);
        novoContato.adicionarTelefone(telefone);
        adicionarContato(novoContato);
        System.out.println("Novo contato criado: " + novoContato);
    }

    // Exibir Contatos
    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("Contatos na agenda:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    // Remover Contato
    public void removerContato(int id) {
        Iterator<Contato> iterator = contatos.iterator();
        while (iterator.hasNext()) {
            Contato contato = iterator.next();
            if (contato.getId() == id) {
                iterator.remove();
                System.out.println("Contato removido: " + contato);
                return;
            }
        }
        System.out.println("Contato não encontrado com o ID: " + id);
    }

    // Menu de Operações
    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("\nMenu de Operações:");
            System.out.println("1 - Adicionar/Atualizar Contato");
            System.out.println("2 - Exibir Contatos");
            System.out.println("3 - Remover Contato");
            System.out.println("4 - Sair");

            System.out.print("Escolha a operação (1-4): ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    System.out.print("Nome do contato: ");
                    String nomeContato = scanner.nextLine();
                    System.out.print("Número de telefone: ");
                    String telefoneContato = scanner.nextLine();
                    adicionarOuAtualizarContato(nomeContato, telefoneContato);
                    break;
                case 2:
                    exibirContatos();
                    break;
                case 3:
                    System.out.print("ID do contato a ser removido: ");
                    int idContato = scanner.nextInt();
                    removerContato(idContato);
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        } while (escolha != 4);
    }
}
