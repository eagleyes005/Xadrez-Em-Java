package xadrez.pecas;

import xadrez.Peca;

import java.util.LinkedList;

public class Rei extends Peca {

    public Rei(int colunaX, int linhaY, boolean branco, String tipo, LinkedList<Peca> ps) {
        super(colunaX, linhaY, branco, tipo, ps);
    }

    public void move(int mouseX, int mouseY) { // Regras de movimento do rei
        System.out.println("Coluna atual: " + getColunaX());
        System.out.println("Nova posição: " + mouseX);
        System.out.println("Linha atual: " + getLinhaY());
        System.out.println("Nova posição: " + mouseY);

        int deltaX = Math.abs(getColunaX() - mouseX);
        int deltaY = Math.abs(getLinhaY() - mouseY);

        System.out.println("Delta X: " + deltaX);
        System.out.println("Delta Y: " + deltaY);

        if (deltaX == 1 && deltaY == 1) {
            validaMovimento(mouseX, mouseY); // Verifica se o rei está se movendo apenas uma casa na diagonal
        } else if ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1)) { // Verifica se o rei está se movendo apenas uma casa na horizontal ou vertical
            validaMovimento(mouseX, mouseY);
            // TODO verificar se não há nenhuma peça atacando onde o rei irá se mover
        } else {
            jogadaInvalida();
        }
        // TODO adiocionar movimento "Roque"
    }
}
