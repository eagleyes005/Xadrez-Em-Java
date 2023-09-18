package xadrez.pecas;

import xadrez.Peca;

import java.util.LinkedList;

public class Cavalo extends Peca {
    public Cavalo(int colunaX, int linhaY, boolean branco, String tipo, LinkedList<Peca> ps) {
        super(colunaX, linhaY, branco, tipo, ps);
    }

    public void move(int mouseX, int mouseY) { // Regras de movimento do cavalo
        int deltaX = Math.abs(getColunaX() - mouseX);
        int deltaY = Math.abs(getLinhaY() - mouseY);

        if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1)) { //O cavalo move-se para a casa mais próxima em relação à qual ocupa, mas não na mesma coluna, fileira ou diagonal.
            validaMovimento(mouseX, mouseY); // TODO modificar para conseguir matar outros cavalos também
        } else {
            jogadaInvalida();
        }
    }
}
