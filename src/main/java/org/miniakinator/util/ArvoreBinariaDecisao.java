package org.miniakinator.util;

// a estrutura do Tipo Abstrato de Dados de Árvore de Binária de Decisões que pensei é:
// variáveis:
//      raíz: referencia o início da árvore
//      atual: referencia o nó atual dentro da árvore
// operações:
//      get(): retorna o nó da posição atual
//      avancar(boolean): realiza o deslocamento do estado atual para o próximo estado, sendo o parametro para definir
//          se é o estado da resposta positiva ou da resposta negativa
//      voltar(): volta para o nó anterior
public class ArvoreBinariaDecisao {
    private NoDecisaoBinaria raiz, atual;

    public ArvoreBinariaDecisao(NoDecisaoBinaria raiz) {
        setRaiz(raiz);
    }

    public NoDecisaoBinaria getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NoDecisaoBinaria n) {
        this.raiz = n;
        this.atual = raiz.clone();
    }

    public NoDecisaoBinaria get() {
        return this.atual;
    }

    public void avancar(boolean decisao) {
        // se não for uma folha, avance
        if (!this.atual.isFolha()) {
            if (decisao) {
                this.atual = this.atual.getFilhoVerdadeiro();
            } else {
                this.atual = this.atual.getFilhoFalso();
            }
        }
    }

    public void voltar() {
        // se não for a raiz, retorne
        if (!atual.equals(raiz)) {
            this.atual = this.atual.getPai();
        }
    }

    public void voltarTudo() {
        this.atual = this.raiz.clone();
    }
}
