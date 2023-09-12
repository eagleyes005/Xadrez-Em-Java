package xadrez;

import java.util.LinkedList;

public class Peca {
    private int xp;
    private int yp;
    private int x;
    private int y;
    private boolean branco;
    private String tipo;
    private LinkedList<Peca> ps; // Lista de peças compartilhada por todas as instâncias de Peca

    public Peca(int xp, int yp, boolean branco, String tipo, LinkedList<Peca> ps) { // Construtor padrão das peças
        this.xp = xp;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;
        this.branco = branco;
        this.tipo = tipo;
        this.ps = ps;
        ps.add(this);
    }

    public void move (int xp, int yp) { //Método para mover uma peça
        if(JogoDeXadrez.getPeca(xp*64, yp*64)!=null){
            if(JogoDeXadrez.getPeca(xp*64, yp*64).branco!=branco){
                JogoDeXadrez.getPeca(xp*64, yp*64).matar();

            }else{
                x=this.xp*64;
                y=this.yp*64;
                return;
            }
        }
        this.xp = xp;
        this.yp = yp;
        this.x = xp * 64;
        this.y = yp * 64;
    }

    public void matar() {
        ps.remove(this);
    } // Método para eliminar a peça que estiver no mesmo local da peça movida

    // Métodos Getter
    public int getXp() {
        return xp;
    }

    public int getYp() {
        return yp;
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
}
