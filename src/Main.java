import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Personagens iniciais para facilitar os testes
        arvore.inserir(new Personagem("Aragorn",  "Guerreiro", 50, 500, "Espada"));
        arvore.inserir(new Personagem("Gandalf",  "Mago",      80, 350, "Cajado"));
        arvore.inserir(new Personagem("Legolas",  "Arqueiro",  65, 420, "Arco"));
        arvore.inserir(new Personagem("Frodo",    "Hobbit",    15, 200, "Adaga"));
        arvore.inserir(new Personagem("Gimli",    "Anão",      40, 550, "Machado"));
        arvore.inserir(new Personagem("Sauron",   "Senhor",    99, 999, "Maça"));
        arvore.inserir(new Personagem("Saruman",  "Mago",      90, 600, "Cajado"));
        arvore.inserir(new Personagem("Boromir",  "Guerreiro", 35, 480, "Escudo"));

        int opcao;

        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║     SISTEMA DE PERSONAGENS RPG        ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Inserir personagem                ║");
            System.out.println("║  2. Buscar personagem por nível       ║");
            System.out.println("║  3. Remover personagem                ║");
            System.out.println("║  4. Exibir em ordem crescente         ║");
            System.out.println("║  5. Exibir personagem mais forte      ║");
            System.out.println("║  6. Exibir personagem mais fraco      ║");
            System.out.println("║  7. Quantidade de personagens         ║");
            System.out.println("║  8. Altura da árvore                  ║");
            System.out.println("║  9. Exibir em pré-ordem               ║");
            System.out.println("║ 10. Exibir em pós-ordem               ║");
            System.out.println("║ 11. Encerrar sistema                  ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Classe (ex: Guerreiro, Mago, Arqueiro): ");
                    String classe = scanner.nextLine();

                    System.out.print("Nível (1-99): ");
                    int nivel = scanner.nextInt();

                    System.out.print("Pontos de vida: ");
                    int pv = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Tipo de arma: ");
                    String arma = scanner.nextLine();

                    arvore.inserir(new Personagem(nome, classe, nivel, pv, arma));
                    System.out.println("Personagem inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nível a buscar: ");
                    int nivelBusca = scanner.nextInt();
                    Personagem encontrado = arvore.buscarPorNivel(nivelBusca);
                    if (encontrado != null) {
                        System.out.println("Personagem encontrado:");
                        encontrado.exibir();
                    } else {
                        System.out.println("Nenhum personagem com nível " + nivelBusca + " encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nível do personagem a remover: ");
                    int nivelRemover = scanner.nextInt();
                    arvore.remover(nivelRemover);
                    break;

                case 4:
                    System.out.println("\nPersonagens em ordem crescente de nível:");
                    arvore.exibirEmOrdem();
                    break;

                case 5:
                    Personagem forte = arvore.maisForte();
                    if (forte != null) {
                        System.out.println("\nPersonagem mais forte (maior nível):");
                        forte.exibir();
                    } else {
                        System.out.println("A árvore está vazia.");
                    }
                    break;

                case 6:
                    Personagem fraco = arvore.maisFraco();
                    if (fraco != null) {
                        System.out.println("\nPersonagem mais fraco (menor nível):");
                        fraco.exibir();
                    } else {
                        System.out.println("A árvore está vazia.");
                    }
                    break;

                case 7:
                    System.out.println("Total de personagens: " + arvore.contarPersonagens());
                    break;

                case 8:
                    System.out.println("Altura da árvore: " + arvore.calcularAltura());
                    break;

                case 9:
                    System.out.println("\nPersonagens em pré-ordem (raiz → esquerda → direita):");
                    arvore.exibirPreOrdem();
                    break;

                case 10:
                    System.out.println("\nPersonagens em pós-ordem (esquerda → direita → raiz):");
                    arvore.exibirPosOrdem();
                    break;

                case 11:
                    System.out.println("Sistema encerrado. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 11);

        scanner.close();
    }
}