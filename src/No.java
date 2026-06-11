public class No {

    Personagem personagem;
    No esquerda;
    No direita;

    public No(Personagem personagem) {
        this.personagem = personagem;
        this.esquerda = null;
        this.direita = null;
    }
}
