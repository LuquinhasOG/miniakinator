package org.miniakinator;

public class Main {
    public static void main(String[] args) {
        // pode mudar a primeira pergunta e as respostas
        MiniAkinator mk = new MiniAkinator("A cidade que está pensando é uma capital?",
                "São Paulo",
                "Campinas");
        mk.comecar();

        // to do
        // criar sistema de salvar e carregar a árvore de decisões
    }
}