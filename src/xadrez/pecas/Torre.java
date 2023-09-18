package xadrez.pecas;

import xadrez.Peca;

import java.util.LinkedList;

public class Torre extends Peca {
    public Torre(int colunaX, int linhaY, boolean branco, String tipo, LinkedList<Peca> ps) {
        super(colunaX, linhaY, branco, tipo, ps);
    }

    public void move(int mouseX, int mouseY) { // Regras de movimento da torre
        int deltaX = mouseX - getColunaX();
        int deltaY = mouseY - getLinhaY();
        // Ao comparar os deltas é possível saber se o movimento é em diagonal
        if ((deltaX != 0 && deltaY == 0) || (deltaX == 0 && deltaY != 0)) { // A torre move-se para qualquer casa ao longo da coluna ou linha que ocupa
            validaMovimento(mouseX, mouseY);
        } else {
            jogadaInvalida();
        }
        // TODO não permitir que a Torre pule por cima de outra peça
    }
}
