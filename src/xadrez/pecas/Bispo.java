package xadrez.pecas;

import xadrez.Peca;

import java.util.LinkedList;

public class Bispo extends Peca {
    public Bispo(int colunaX, int linhaY, boolean branco, String tipo, LinkedList<Peca> ps) {
        super(colunaX, linhaY, branco, tipo, ps);
    }

    public void move(int mouseX, int mouseY) { // Regras de movimento do bispo
        int deltaX = mouseX - getColunaX();
        int deltaY = mouseY - getLinhaY();
        // Ao comparar os deltas é possível saber se o movimento é em diagonal
        if (Math.abs(deltaX) == Math.abs(deltaY)) { // O bispo move-se a qualquer casa ao longo de uma diagonal que ocupa
            validaMovimento(mouseX, mouseY);
        } else {
            jogadaInvalida();
        }
        // TODO não permitir que o Bispo pule por cima de outra peça
    }
}
