package org.miniakinator.util;


// aqui está definido a classe do Nó de Decisão Binária, parte essencial do funcionamento da árvore
// um nó armazena a referência do nó pai, e dos dois nós filho
public class NoDecisaoBinaria {
    private NoDecisaoBinaria filhoVerdadeiro, filhoFalso, pai;
    private String informacao;

    public NoDecisaoBinaria(String informacao) {
        this.informacao = informacao;
    }
    public NoDecisaoBinaria(String informacao, NoDecisaoBinaria pai, NoDecisaoBinaria filhoVerdadeiro, NoDecisaoBinaria filhoFalso) {
        this.informacao = informacao;
        this.filhoVerdadeiro = filhoVerdadeiro;
        this.filhoFalso = filhoFalso;
        this.pai = pai;
    }
    public void set(NoDecisaoBinaria n, boolean decisao) {
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

    public NoDecisaoBinaria getFilhoVerdadeiro() {
        return filhoVerdadeiro;
    }

    public NoDecisaoBinaria getFilhoFalso() {
        return filhoFalso;
    }

    public NoDecisaoBinaria getPai() {
        return pai;
    }

    public void setPai(NoDecisaoBinaria pai) {
        this.pai = pai;
    }

    public boolean isFolha() {
        return (filhoVerdadeiro == null) && (filhoFalso == null);
    }

    public NoDecisaoBinaria clone() {
        return new NoDecisaoBinaria(getInformacao(), getPai(), getFilhoVerdadeiro(), getFilhoFalso());
    }
}
