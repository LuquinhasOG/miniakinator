package org.miniakinator;

import org.miniakinator.util.ArvoreBinariaDecisao;
import org.miniakinator.util.NoDecisaoBinaria;

import java.util.Scanner;

public class MiniAkinator {
    private final ArvoreBinariaDecisao arvore;
    private final Scanner scanner = new Scanner(System.in);
    boolean reiniciar = false;
    boolean continuar = true;

    public MiniAkinator(String textoPergunta, String respostaAfirmativa, String respostaNegativa) {
        NoDecisaoBinaria primeiraPergunta = new NoDecisaoBinaria(textoPergunta);

        primeiraPergunta.set(new NoDecisaoBinaria(respostaAfirmativa), true);
        primeiraPergunta.set(new NoDecisaoBinaria(respostaNegativa), false);
        this.arvore = new ArvoreBinariaDecisao(primeiraPergunta);
    }

    public void comecar() {
        String decisao, resposta;

        // loop do jogo
        while (continuar) {
            // faz a pergunta
            System.out.print(arvore.get().getInformacao() + "[S/N]: ");
            decisao = scanner.nextLine();

            // se a resposta da perguta for sim, avance para o lado afirmativo da árvore de decisão
            // se não, vá para o lado negativo
            if (retornaDecisao(decisao)) {
                arvore.avancar(true);
            } else {
                arvore.avancar(false);
            }

            // verifica se o nó atual é uma folha da árvore de decisão
            // se for uma folha significa que é uma resposta
            // caso não, o programa ignora e segue para a próxima pergunta
            if (arvore.get().isFolha()) {
                // pergunta se a resposta é a que você deseja
                System.out.print("Você estava pensando em: " + arvore.get().getInformacao() + "?[S/N]: ");
                resposta = scanner.nextLine();

                // se estiver correta o adivinho comemora e reinicia o jogo
                // caso contrário, realiza o processo de inserir novas respostas e perguntas
                if (retornaDecisao(resposta)) {
                    System.out.println("Acertei!");
                    reiniciar = true;
                } else {
                    System.out.print("Então no que você estava pensando?: ");
                    String animal = scanner.nextLine();

                    System.out.print("Que pergunta posso fazer para adivinhar?: ");
                    String pergunta = scanner.nextLine();

                    NoDecisaoBinaria respotaTemp = arvore.get();
                    NoDecisaoBinaria novaResposta = new NoDecisaoBinaria(animal);
                    NoDecisaoBinaria novaPergunta = new NoDecisaoBinaria(pergunta);

                    // o algoritmo de adicionar uma pergunta é:
                    // 1 - volte para a pergunta anterior
                    arvore.voltar();
                    // 2 - insira a nova pergunta para o caso da resposta "sim"
                    arvore.get().set(novaPergunta, retornaDecisao(decisao));
                    // 3 - avance para pergunta que adicionou
                    arvore.avancar(retornaDecisao(decisao));
                    // 4 - insira a nova resposta no caso verdadeiro, e a antiga no caso falso
                    arvore.get().set(novaResposta, true);
                    arvore.get().set(respotaTemp, false);
                    reiniciar = true;
                }
            }

            // reinicia o jogo se já tiver chegado no fim, se não continua para o próximo ciclo da repetição
            if (reiniciar) {
                this.reiniciarJogo();
            }
        }

        // encerra o jogo
        System.out.println("Jogo acabou!");
        scanner.close();
    }

    public boolean retornaDecisao(String decisao) {
        return (decisao.equalsIgnoreCase("S"));
    }

    public void reiniciarJogo() {
        System.out.println("\nDesenha continuar?[S/N]: ");
        if (!retornaDecisao(scanner.nextLine()))
            continuar = false;

        if (!continuar) {
            System.out.println("\n\nVamos recomeçar o jogo");
        }

        reiniciar = false;
        arvore.voltarTudo();
    }
}
