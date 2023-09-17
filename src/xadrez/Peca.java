package xadrez;

import java.util.LinkedList;

public abstract class Peca {
    private int colunaX;
    private int linhaY;
    private int x;
    private int y;
    private boolean branco;
    private String tipo;
    private LinkedList<Peca> ps; // Lista de peças compartilhada por todas as instâncias de Peca

    public Peca(int colunaX, int linhaY, boolean branco, String tipo, LinkedList<Peca> ps) { // Construtor padrão das peças
        this.colunaX = colunaX;
        this.linhaY = linhaY;
        this.x = colunaX * 64;
        this.y = linhaY * 64;
        this.branco = branco;
        this.tipo = tipo;
        this.ps = ps;
        ps.add(this);
    }

    public void move(int xp, int yp) { //Método para mover uma peça
        /*if (JogoDeXadrez.getPeca(xp * 64, yp * 64) != null) {
            if (JogoDeXadrez.getPeca(xp * 64, yp * 64).branco != branco) {

                JogoDeXadrez.getPeca(xp * 64, yp * 64).matar();

            } else {
                x = this.xp * 64;
                y = this.yp * 64;
                return;
            }
        }
        this.xp = xp;
        this.yp = yp;
        this.x = xp * 64;
        this.y = yp * 64;*/
    }

    public void validaMovimento(int mouseX, int mouseY) {
        if (JogoDeXadrez.getPeca(mouseX * 64, mouseY * 64) != null) { // Verifica se existe uma peça no local
            if (JogoDeXadrez.getPeca(mouseX * 64, mouseY * 64).isBranco() != isBranco()) { //Verifica se são de cores diferentes
                JogoDeXadrez.getPeca(mouseX * 64, mouseY * 64).mataPeca();
                movePeca(mouseX, mouseY);
            } else {
                resetaMovimento();
            }
        } else {
            movePeca(mouseX, mouseY);
        }
    }

    public void movePeca(int mouseX, int mouseY) {
        this.setColunaX(mouseX);
        this.setLinhaY(mouseY);
        this.setX(mouseX * 64);
        this.setY(mouseY * 64);
    }

    public void resetaMovimento() {
        setX(this.getColunaX() * 64);
        setY(this.getLinhaY() * 64);
    }

    public void mataPeca() {
        ps.remove(this);
    } // Método para eliminar a peça que estiver no mesmo local da peça movida

    // Métodos Getter
    public int getColunaX() {
        return colunaX;
    }

    public int getLinhaY() {
        return linhaY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isBranco() {
        return branco;
    }

    public String getTipo() {
        return tipo;
    }

    public LinkedList<Peca> getPs() {
        return ps;
    }

    // Métodos Setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColunaX(int colunaX) {
        this.colunaX = colunaX;
    }

    public void setLinhaY(int linhaY) {
        this.linhaY = linhaY;
    }
}
