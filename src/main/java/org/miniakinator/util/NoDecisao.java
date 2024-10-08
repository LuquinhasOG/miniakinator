package org.miniakinator.util;


// aqui está definido a classe do Nó de Decisão Binária, parte essencial do funcionamento da árvore
// um nó armazena a referência do nó pai, e dos dois nós filho
public class NoDecisao {
    private NoDecisao filhoVerdadeiro, filhoFalso, pai;
    private String informacao;

    public NoDecisao(String informacao) {
        this.informacao = informacao;
    }
    public NoDecisao(String informacao, NoDecisao pai, NoDecisao filhoVerdadeiro, NoDecisao filhoFalso) {
        this.informacao = informacao;
        this.filhoVerdadeiro = filhoVerdadeiro;
        this.filhoFalso = filhoFalso;
        this.pai = pai;
    }
    public void set(NoDecisao n, boolean decisao) {
        n.setPai(this);

        if (decisao) {
            this.filhoVerdadeiro = n;
        } else {
            this.filhoFalso = n;
        }
    }
    public String getInformacao() {
        return this.informacao;
    }

    public NoDecisao getFilhoVerdadeiro() {
        return filhoVerdadeiro;
    }

    public NoDecisao getFilhoFalso() {
        return filhoFalso;
    }

    public NoDecisao getPai() {
        return pai;
    }

    public void setPai(NoDecisao pai) {
        this.pai = pai;
    }

    public boolean isFolha() {
        return (filhoVerdadeiro == null) && (filhoFalso == null);
    }

    public boolean isRaiz() {
        return pai == null;
    }
}
