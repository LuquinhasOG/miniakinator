package org.miniakinator.util;

/* Árvore de Decisão:
 * Apresenta apenas o nó da raíz. As operações para navegar sobre os dados se encontram na classe IteradorArvoreDecisao
 */
public class ArvoreDecisao {
    private NoDecisao raiz;

    public ArvoreDecisao(NoDecisao raiz) {
        setRaiz(raiz);
    }

    public NoDecisao getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NoDecisao n) {
        this.raiz = n;
    }
}
