package xadrez.pecas;

import xadrez.JogoDeXadrez;
import xadrez.Peca;

import java.util.LinkedList;

public class Peao extends Peca {
    private boolean primeiroLance;

    public Peao(int xp, int yp, boolean branco, String tipo, LinkedList<Peca> ps) {
        super(xp, yp, branco, tipo, ps);
        this.primeiroLance = true;
    }

    public void validaPrimeiroLance(int mouseX, int mouseY) {
        if (JogoDeXadrez.getPeca(mouseX * 64, mouseY * 64) == null) { // Verifica se não existe peças no local
            movePeca(mouseX, mouseY);
            // TODO criar verificação para não deixar uma peça pular por cima da outra
        } else {
            setX(this.getColunaX() * 64);
            setY(this.getLinhaY() * 64);
            System.out.println("Jogada inválida!");
        }
    }

    public void validaMovimentoPeao(int mouseX, int mouseY) {
        if (JogoDeXadrez.getPeca(mouseX * 64, mouseY * 64) == null) { // Verifica se não existe peças no local
            movePeca(mouseX, mouseY);
        } else {
            jogadaInvalida();
        }
    }

    public void move(int mouseX, int mouseY) { // Regras de movimento do peão
        if (getColunaX() == mouseX && getLinhaY() == (mouseY + 2) && isBranco() && primeiroLance) { // Em seu primeiro lance o peão branco pode avançar duas casas na mesma coluna, desde que ambas estejam vazias
            validaPrimeiroLance(mouseX, mouseY);
            primeiroLance = false;
        } else if (getColunaX() == mouseX && getLinhaY() == (mouseY - 2) && !isBranco() && primeiroLance) { // Em seu primeiro lance o peão preto pode avançar duas casas na mesma coluna, desde que ambas estejam vazias
            validaPrimeiroLance(mouseX, mouseY);
            primeiroLance = false;
        } else if (getColunaX() == mouseX && getLinhaY() == (mouseY + 1) && isBranco()) { // O peão branco avança para uma casa vazia, imediatamente à sua frente na mesma coluna
            validaMovimentoPeao(mouseX, mouseY);
            primeiroLance = false;
        } else if (getColunaX() == mouseX && getLinhaY() == (mouseY - 1) && !isBranco()) { // O peão preto avança para uma casa vazia, imediatamente à sua frente na mesma coluna
            validaMovimentoPeao(mouseX, mouseY);
            primeiroLance = false;
        } else {
            jogadaInvalida();
        }
        // TODO adicionar jogada "En passant"
    }
}
