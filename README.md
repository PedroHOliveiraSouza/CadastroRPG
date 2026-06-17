# 🗡️ Sistema de Cadastro de Personagens RPG
 
Sistema em console desenvolvido em Java para gerenciar personagens de RPG utilizando **Árvore Binária de Busca** como estrutura principal.
 
---
 
## 📁 Estrutura do Projeto
 
```
SistemaRPG/
├── Personagem.java     # Entidade principal com os atributos do personagem
├── No.java             # Nó da árvore (guarda um Personagem + ponteiros)
├── ArvoreBinaria.java  # Implementação completa da ABB
└── Main.java           # Menu e execução do sistema
```
 
---
 
## 🧱 Estrutura da Árvore
 
Os personagens são organizados pelo **nível**:
- Nível menor → vai para a **esquerda**
- Nível maior → vai para a **direita**
```
        Aragorn (50)
        /          \
   Gimli (40)    Gandalf (80)
   /                    \
Frodo (15)           Sauron (99)
```
 
---
 
## ⚙️ Funcionalidades
 
| # | Funcionalidade |
|---|---|
| 1 | Inserir personagem |
| 2 | Buscar personagem por nível |
| 3 | Remover personagem |
| 4 | Exibir em ordem crescente de nível |
| 5 | Exibir personagem mais forte (maior nível) |
| 6 | Exibir personagem mais fraco (menor nível) |
| 7 | Mostrar quantidade de personagens |
| 8 | Mostrar altura da árvore |
| 9 | Exibir em pré-ordem |
| 10 | Exibir em pós-ordem |
| 11 | Encerrar sistema |
 
---
 
## 🧩 Atributos do Personagem
 
- Nome
- Classe (ex: Guerreiro, Mago, Arqueiro)
- Nível ← chave de ordenação na ABB
- Pontos de vida
- Tipo de arma
  
---
 
## 📌 Operações implementadas na ABB
 
- **Inserção** — recursiva, organizada pelo nível
- **Busca** — recursiva, descarta metade da árvore a cada passo
- **Remoção** — recursiva, trata os 3 casos (folha, um filho, dois filhos)
- **Percurso em ordem** — exibe do menor para o maior nível
- **Percurso pré-ordem** — raiz → esquerda → direita
- **Percurso pós-ordem** — esquerda → direita → raiz
- **Altura** — recursiva, conta os níveis da árvore
- **Contagem** — conta todos os nós recursivamente
---
 
## 🚫 Restrições seguidas
 
Nenhuma estrutura pronta do Java foi utilizada:
 
- ❌ ArrayList / LinkedList / Vector
- ❌ Stack / Queue
- ❌ TreeMap / Collections
Toda a árvore foi implementada manualmente.
