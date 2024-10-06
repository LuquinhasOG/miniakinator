package org.miniakinator;

public class Main {
    public static void main(String[] args) {
        // pode mudar a primeira pergunta e as respostas
        MiniAkinator mk = new MiniAkinator("O animal é doméstico?", "Cachorro", "Onça");
        mk.comecar();

        // to do
        // criar sistema de salvar e carregar a árvore de decisões
    }
}