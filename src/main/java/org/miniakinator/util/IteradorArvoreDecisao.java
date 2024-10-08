package org.miniakinator.util;

import java.util.ArrayList;

public class IteradorArvoreDecisao {
    private NoDecisao atual;

    public IteradorArvoreDecisao(ArvoreDecisao arvore) {
        setInicio(arvore.getRaiz());
    }

    public String get() {
        return atual.getInformacao();
    }

    public void set(NoDecisao n, boolean decisao) {
        atual.set(n, decisao);
    }

    public void avancar(boolean decisao) {
        // se não for uma folha, avance
        if (decisao) {
            this.atual = this.atual.getFilhoVerdadeiro();
        } else {
            this.atual = this.atual.getFilhoFalso();
        }
    }

    public void voltar() {
        // se não for a raiz, volte
        if (!isRaiz()) {
            this.atual = this.atual.getPai();
        }
    }

    public void voltarTudo() {
        while (!isRaiz()) {
            voltar();
        }
    }

    public void setInicio(NoDecisao inicio) {
        atual = inicio;
    }

    public boolean isFolha() {
        return atual.isFolha();
    }

    public boolean isRaiz() {
        return atual.isRaiz();
    }
}
