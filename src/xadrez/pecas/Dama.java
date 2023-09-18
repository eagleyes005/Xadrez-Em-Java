package xadrez.pecas;

import xadrez.Peca;

import java.util.LinkedList;

public class Dama extends Peca {
    public Dama(int colunaX, int linhaY, boolean branco, String tipo, LinkedList<Peca> ps) {
        super(colunaX, linhaY, branco, tipo, ps);
    }

    public void move(int mouseX, int mouseY) { // Regras de movimento da dama
        int deltaX = mouseX - getColunaX();
        int deltaY = mouseY - getLinhaY();
        // Ao comparar os deltas é possível saber se o movimento é em diagonal
        if (Math.abs(deltaX) == Math.abs(deltaY)) { // A dama move-se para qualquer casa ao longo da diagonal que ocupa
            validaMovimento(mouseX, mouseY);
        } else if ((deltaX != 0 && deltaY == 0) || (deltaX == 0 && deltaY != 0)) { // A dama move-se para qualquer casa ao longo da coluna ou linha que ocupa
            validaMovimento(mouseX, mouseY);
        } else {
            jogadaInvalida();
        }
        // TODO não permitir que a Dama pule por cima de outra peça
    }
}
