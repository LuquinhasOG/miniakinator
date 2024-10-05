# Projeto de Mini Akinator
O projeto se baseia em um jogo de perguntas inspirado no jogo
Akinator.

No Akinator uma inteligência artifical tenta adivinhar
no que o usúario está pensando através de perguntas que podem
ser respondidas com "sim", "provalvelmente sim", "não sei",
"provavelmente não" e "não".
Este projeto é similar, com a diferênça que as opções de respostas
são "sim" e "não", e o programa não apresenta uma base de
conhecimentos prévios, assim o jogador deve fornecê-los conforme
joga.

### Como funciona o algoritmo
O algoritmo de adivinhação funciona com uma árvore binária de
decisões, onde a raíz e os galhos representam perguntas, e as
folhas as respostas.

Conforme o usuario responde as perguntas o programa vai navegando
para o próximo nível de profundidade da árvore, e quando atingir
uma folha pergunta se esta representa o que o jogador está pensando,
caso esteja certo o adivinho comemora e o jogo reinicia, mas se
estiver errado o jogo pergunta qual seria a resposta correta e uma
pergunta apropriada para adicionar na árvore, para que no próximo
jogo o algoritmo esteja treinado para adivinhar e o jogo reinicia.

obs: No estado atual do programa ele não salva os dados, ou seja,
quando encerrar o jogo, todos os dados serão perdidos.

### To do
- adicionar sistema de salvar e recuperar dados.