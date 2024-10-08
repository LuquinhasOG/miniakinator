package org.miniakinator.jogo;

import org.miniakinator.util.ArvoreDecisao;
import org.miniakinator.util.IteradorArvoreDecisao;
import org.miniakinator.util.NoDecisao;

import java.util.Scanner;

public class MiniAkinator {
    private final ArvoreDecisao arvore;
    private final IteradorArvoreDecisao it;
    private final Scanner scanner = new Scanner(System.in);
    boolean reiniciar = false;
    boolean continuar = true;

    public MiniAkinator(String textoPergunta, String respostaAfirmativa, String respostaNegativa) {
        NoDecisao primeiraPergunta = new NoDecisao(textoPergunta);

        primeiraPergunta.set(new NoDecisao(respostaAfirmativa), true);
        primeiraPergunta.set(new NoDecisao(respostaNegativa), false);
        this.arvore = new ArvoreDecisao(primeiraPergunta);
        it = new IteradorArvoreDecisao(arvore);
    }

    public void comecar() {
        String decisao, resposta;

        // loop do jogo
        while (continuar) {
            // faz a pergunta
            System.out.print(it.get() + "[S/N]: ");
            decisao = scanner.nextLine();

            // se a resposta da perguta for sim, avance para o lado afirmativo da árvore de decisão
            // se não, vá para o lado negativo
            it.avancar(retornaDecisao(decisao));

            // verifica se o nó atual é uma folha da árvore de decisão
            // se for uma folha significa que é uma resposta
            // caso não, o programa ignora e segue para a próxima pergunta
            if (it.isFolha()) {
                // pergunta se a resposta é a que você deseja
                System.out.print("Você estava pensando em: " + it.get() + "?[S/N]: ");
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

                    NoDecisao respotaTemp = new NoDecisao(it.get());
                    NoDecisao novaResposta = new NoDecisao(animal);
                    NoDecisao novaPergunta = new NoDecisao(pergunta);

                    // o algoritmo de adicionar uma pergunta é:
                    // 1 - volte para a pergunta anterior
                    it.voltar();
                    // 2 - insira a nova pergunta para o caso da resposta "sim"
                    it.set(novaPergunta, retornaDecisao(decisao));
                    // 3 - avance para pergunta que adicionou
                    it.avancar(retornaDecisao(decisao));
                    // 4 - insira a nova resposta no caso verdadeiro, e a antiga no caso falso
                    it.set(novaResposta, true);
                    it.set(respotaTemp, false);
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
        System.out.print("\nDesenha continuar?[S/N]: ");
        if (!retornaDecisao(scanner.nextLine()))
            continuar = false;

        if (continuar) {
            System.out.println("\n\nVamos recomeçar o jogo");
        }

        reiniciar = false;
        it.voltarTudo();
    }
}
