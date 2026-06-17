public class Personagem {

    String nome;
    String classe;
    int nivel;
    int pontosDeVida;
    String tipoDeArma;

    public Personagem(String nome, String classe, int nivel, int pontosDeVida, String tipoDeArma) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.pontosDeVida = pontosDeVida;
        this.tipoDeArma = tipoDeArma;
    }

public void exibir() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║  Nome: " + nome);
        System.out.println("║  Classe: " + classe);
        System.out.println("║  Nível :" + nivel);
        System.out.println("║  Pontos de vida: " + pontosDeVida);
        System.out.println("║  Arma: " + tipoDeArma);
        System.out.println("╚══════════════════════════════╝");
    }
}
