public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    // ─────────────────────────────────────────────
    // ETAPA 2 – Inserção e Busca
    // ─────────────────────────────────────────────

    public void inserir(Personagem personagem) {
        raiz = inserirRecursivo(raiz, personagem);
    }

    private No inserirRecursivo(No no, Personagem personagem) {
        // Se chegou num espaço vazio, cria o nó aqui
        if (no == null) {
            return new No(personagem);
        }

        if (personagem.nivel < no.personagem.nivel) {
            // Nível menor → vai para a esquerda
            no.esquerda = inserirRecursivo(no.esquerda, personagem);
        } else if (personagem.nivel > no.personagem.nivel) {
            // Nível maior → vai para a direita
            no.direita = inserirRecursivo(no.direita, personagem);
        } else {
            // Nível igual já existe
            System.out.println("Já existe um personagem com o nível " + personagem.nivel + ". Insira um nível diferente.");
        }

        return no;
    }

    public Personagem buscarPorNivel(int nivel) {
        No resultado = buscarRecursivo(raiz, nivel);
        if (resultado == null) {
            return null;
        }
        return resultado.personagem;
    }

    private No buscarRecursivo(No no, int nivel) {
        if (no == null) {
            return null; // Não encontrado
        }

        if (nivel == no.personagem.nivel) {
            return no; // Encontrado
        }

        if (nivel < no.personagem.nivel) {
            return buscarRecursivo(no.esquerda, nivel);
        } else {
            return buscarRecursivo(no.direita, nivel);
        }
    }

    // ─────────────────────────────────────────────
    // ETAPA 3 – Percursos, Contagem e Altura
    // ─────────────────────────────────────────────

    // Em ordem: esquerda → raiz → direita  (crescente de nível)
    public void exibirEmOrdem() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }
        emOrdemRecursivo(raiz);
    }

    private void emOrdemRecursivo(No no) {
        if (no == null) {
            return;
        }
        emOrdemRecursivo(no.esquerda);
        no.personagem.exibir();
        emOrdemRecursivo(no.direita);
    }

    // Pré-ordem: raiz → esquerda → direita
    public void exibirPreOrdem() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }
        preOrdemRecursivo(raiz);
    }

    private void preOrdemRecursivo(No no) {
        if (no == null) {
            return;
        }
        no.personagem.exibir();
        preOrdemRecursivo(no.esquerda);
        preOrdemRecursivo(no.direita);
    }

    // Pós-ordem: esquerda → direita → raiz
    public void exibirPosOrdem() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }
        posOrdemRecursivo(raiz);
    }

    private void posOrdemRecursivo(No no) {
        if (no == null) {
            return;
        }
        posOrdemRecursivo(no.esquerda);
        posOrdemRecursivo(no.direita);
        no.personagem.exibir();
    }

    // Contagem de personagens
    public int contarPersonagens() {
        return contarRecursivo(raiz);
    }

    private int contarRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarRecursivo(no.esquerda) + contarRecursivo(no.direita);
    }

    // Altura da árvore
    public int calcularAltura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(No no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = alturaRecursiva(no.esquerda);
        int alturaDireita = alturaRecursiva(no.direita);

        // A altura é 1 (nó atual) + o maior dos dois lados
        if (alturaEsquerda > alturaDireita) {
            return 1 + alturaEsquerda;
        } else {
            return 1 + alturaDireita;
        }
    }

    // Personagem mais forte = maior nível = nó mais à direita
    public Personagem maisForte() {
        if (raiz == null) {
            return null;
        }
        No atual = raiz;
        while (atual.direita != null) {
            atual = atual.direita;
        }
        return atual.personagem;
    }

    // Personagem mais fraco = menor nível = nó mais à esquerda
    public Personagem maisFraco() {
        if (raiz == null) {
            return null;
        }
        No atual = raiz;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual.personagem;
    }

    // ─────────────────────────────────────────────
    // ETAPA 4 – Remoção
    // ─────────────────────────────────────────────

    public void remover(int nivel) {
        if (buscarPorNivel(nivel) == null) {
            System.out.println("Personagem com nível " + nivel + " não encontrado.");
            return;
        }
        raiz = removerRecursivo(raiz, nivel);
        System.out.println("Personagem removido com sucesso.");
    }

    private No removerRecursivo(No no, int nivel) {
        if (no == null) {
            return null;
        }

        if (nivel < no.personagem.nivel) {
            // Continua buscando na esquerda
            no.esquerda = removerRecursivo(no.esquerda, nivel);

        } else if (nivel > no.personagem.nivel) {
            // Continua buscando na direita
            no.direita = removerRecursivo(no.direita, nivel);

        } else {
            // Encontrou o nó para remover — três casos:

            // Caso 1: Nó folha (sem filhos)
            if (no.esquerda == null && no.direita == null) {
                return null;
            }

            // Caso 2: Nó com apenas um filho
            if (no.esquerda == null) {
                return no.direita;
            }
            if (no.direita == null) {
                return no.esquerda;
            }

            // Caso 3: Nó com dois filhos
            // Substitui pelo sucessor em ordem (menor nó da subárvore direita)
            No sucessor = encontrarMenor(no.direita);
            no.personagem = sucessor.personagem;
            no.direita = removerRecursivo(no.direita, sucessor.personagem.nivel);
        }

        return no;
    }

    // Encontra o menor nó de uma subárvore (usado na remoção com 2 filhos)
    private No encontrarMenor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }
}