package xadrez;

import xadrez.pecas.Peao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

public class JogoDeXadrez {
    // TODO adicionar intercalação de jogadas
    public static LinkedList<Peca> ps = new LinkedList<>(); // Instância da lista linkada de peças
    public static Peca pecaSelecionada = null; // Variável de peça selecionada para uso nas jogadas

    public static void main(String[] args) throws IOException {

        // Faz a leitura da imagem das peças
        BufferedImage imagemPecas = ImageIO.read(JogoDeXadrez.class.getResource("/assets/pecas.png"));
        Image arrayImagens[] = new Image[12]; // Cria um array para receber todas as imagens das peças separadas
        int i = 0;
        // Loops para cortar a imagem maior em 12 imagens menores e salvar no array
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                arrayImagens[i] = imagemPecas.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                i++;
            }
        }

        // Instanciação das peças pretas
        //Peca pTorre = new Peca(0, 0, false, "Torre", ps);
        //Peca pCavalo = new Peca(1, 0, false, "Cavalo", ps);
        //Peca pBispo = new Peca(2, 0, false, "Bispo", ps);
        //Peca pRainha = new Peca(3, 0, false, "Rainha", ps);
        //Peca pRei = new Peca(4, 0, false, "Rei", ps);
        //Peca pBispo2 = new Peca(5, 0, false, "Bispo", ps);
        //Peca pCavalo2 = new Peca(6, 0, false, "Cavalo", ps);
        //Peca pTorre2 = new Peca(7, 0, false, "Torre", ps);
        //Peca pPeao1 = new Peca(1, 1, false, "Peao", ps);
        //Peca pPeao2 = new Peca(2, 1, false, "Peao", ps);
        //Peca pPeao3 = new Peca(3, 1, false, "Peao", ps);
        //Peca pPeao4 = new Peca(4, 1, false, "Peao", ps);
        //Peca pPeao5 = new Peca(5, 1, false, "Peao", ps);
        //Peca pPeao6 = new Peca(6, 1, false, "Peao", ps);
        //Peca pPeao7 = new Peca(7, 1, false, "Peao", ps);
        //Peca pPeao8 = new Peca(0, 1, false, "Peao", ps);

        // Instanciação das peças brancas
        //Peca bTorre = new Peca(0, 7, true, "Torre", ps);
        //Peca bCavalo = new Peca(1, 7, true, "Cavalo", ps);
        //Peca bBispo = new Peca(2, 7, true, "Bispo", ps);
        //Peca bRainha = new Peca(3, 7, true, "Rainha", ps);
        //Peca bRei = new Peca(4, 7, true, "Rei", ps);
        //Peca bBispo2 = new Peca(5, 7, true, "Bispo", ps);
        //Peca bCavalo2 = new Peca(6, 7, true, "Cavalo", ps);
        //Peca bTorre2 = new Peca(7, 7, true, "Torre", ps);
        //Peca bPeao1 = new Peca(1, 6, true, "Peao", ps);
        //Peca bPeao2 = new Peca(2, 6, true, "Peao", ps);
        //Peca bPeao3 = new Peca(3, 6, true, "Peao", ps);
        //Peca bPeao4 = new Peca(4, 6, true, "Peao", ps);
        //Peca bPeao5 = new Peca(5, 6, true, "Peao", ps);
        //Peca bPeao6 = new Peca(6, 6, true, "Peao", ps);
        //Peca bPeao7 = new Peca(7, 6, true, "Peao", ps);
        //Peca bPeao8 = new Peca(0, 6, true, "Peao", ps);

        Peao bPeao1 = new Peao(1, 6, true, "Peao", ps);
        Peao pPeao1 = new Peao(1, 1, false, "Peao", ps);

        JFrame quadro = new JFrame(); // Instância da tela do jogo
        quadro.setBounds(10, 10, 512, 512); // Posição e área da tela do jogo
        quadro.setUndecorated(true); // Remove as bordas do jogo


        JPanel painel = new JPanel() { // Instância do painél do jogo
            @Override
            public void paint(Graphics g) {
                boolean branco = true;
                // Loop para criar uma matriz que será os quadrados do tabuleiro
                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (branco) {
                            g.setColor(Color.white); // Define a cor
                        } else {
                            g.setColor(Color.darkGray); // Define a cor
                        }
                        g.fillRect(x * 64, y * 64, 64, 64); // Preenche o campo com branco ou preto
                        branco = !branco; // Inverte o valor do boolean branco para seu oposto
                    }
                    branco = !branco;
                }

                int matrizX = 0, matrizY = 0; // Número para imprimir no tabuleiro
                Font fonte = new Font("Arial", Font.PLAIN, 20);
                // Loop para imprimir o número da coluna
                for (int y = 1; y < 9; y++) {
                    for (int x = 0; x < 8; x++) {
                        g.setFont(fonte);
                        g.setColor(Color.red);
                        g.drawString(Integer.toString(matrizX), (x*64) + 16, (y * 64) - 16);
                        matrizX++;
                    }
                    matrizX = 0;
                }

                // Loop para imprimir o número da coluna
                for (int y = 1; y < 9; y++) {
                    for (int x = 0; x < 8; x++) {
                        g.setFont(fonte);
                        g.setColor(Color.red);
                        g.drawString(Integer.toString(matrizY), (x*64) + 32, (y * 64) - 16);
                    }
                    matrizY++;
                }


                // Loop for para definir o local em que cada peça será impressa a partir do tipo dela
                for (Peca p : ps) {
                    int i = 0;
                    if (p.getTipo().equalsIgnoreCase("Rei")) {
                        i = 0;
                    }
                    if (p.getTipo().equalsIgnoreCase("Rainha")) {
                        i = 1;
                    }
                    if (p.getTipo().equalsIgnoreCase("Bispo")) {
                        i = 2;
                    }
                    if (p.getTipo().equalsIgnoreCase("Cavalo")) {
                        i = 3;
                    }
                    if (p.getTipo().equalsIgnoreCase("Torre")) {
                        i = 4;
                    }
                    if (p.getTipo().equalsIgnoreCase("Peao")) {
                        i = 5;
                    }
                    if (!p.isBranco()) {
                        i += 6; // Se a peça tiver o atributo branco diferente de true então a mesma será impressa do outro lado do tabuleiro
                    }
                    g.drawImage(arrayImagens[i], p.getX(), p.getY(), this); // Desenha a imagem a partir do índice
                }
            }
        };
        
        quadro.add(painel); // Adiciona o painel ao quadro
        
        quadro.addMouseMotionListener(new MouseMotionListener() { // Escuta eventos de movimento do mouse
            @Override
            public void mouseDragged(MouseEvent e) { // Quando o mouse é arrastado
                if(pecaSelecionada != null) {
                    pecaSelecionada.setX(e.getX() - 32);
                    pecaSelecionada.setY(e.getY() - 32);
                    quadro.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) { // Evento não utilizado por enquanto

            }
        });
        quadro.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { // Evento não utilizado por enquanto

            }

            @Override
            public void mousePressed(MouseEvent e) { // Quando preciona o mouse a peça é selecionada
                pecaSelecionada = getPeca(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) { // Quando solta o botão do mouse a peça é colocada no local do mouse
                try {
                    pecaSelecionada.move(e.getX()/64, e.getY()/64);
                    quadro.repaint();
                } catch (NullPointerException exception) {
                    System.out.println("Não é possível fazer este movimento!");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) { // Evento não utilizado por enquanto

            }

            @Override
            public void mouseExited(MouseEvent e) { // Evento não utilizado por enquanto

            }
        });
        quadro.setDefaultCloseOperation(3); // Operação para encerrar a aplicação é quando a tela é fechada
        quadro.setVisible(true); //Visibilidade do quadro
    }

    public static Peca getPeca(int x, int y) {
        int xp = x / 64;
        int yp = y / 64;
        for (Peca p: ps) {
            if (p.getColunaX() == xp && p.getLinhaY() == yp) {
                return p;
            }
        }
        return null;
    }
}
