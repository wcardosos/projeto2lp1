
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        Casa casa;
        Peca peca;
        
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                if(y == 0) {
                    if(x == 0 || x ==7) {
                        casa = tabuleiro.getCasa(x, y);
                        peca = new Torre(casa, 'b');
                    }
                    else if(x == 1 || x == 6) {
                        /* PEÇA CAVALO BRANCO
                        casa = tabuleiro.getCasa(x,y);
                        */
                    }
                    else if(x == 2 || x == 5) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Bispo(casa, 'b');
                    }
                    else if(x == 3) {
                        /* RAINHA BRANCA
                        casa = tabuleiro.getCasa(x,y);
                        */
                    }
                    else {
                        /* REI BRANCO
                        casa = tabuleiro.getCasa(x,y);
                        */
                    }
                }
                else if(y == 7) {
                    if(x == 0 || x ==7) {
                        casa = tabuleiro.getCasa(x, y);
                        peca = new Torre(casa, 'p');
                    }
                    else if(x == 1 || x == 6) {
                        /* PEÇA CAVALO PRETO
                        casa = tabuleiro.getCasa(x,y);
                        */
                    }
                    else if(x == 2 || x == 5) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Bispo(casa, 'p');
                    }
                    else if(x == 3) {
                        /* RAINHA PRETA
                        casa = tabuleiro.getCasa(x,y);
                        */
                    }
                    else {
                        /* REI PRETO
                        casa = tabuleiro.getCasa(x,y);
                        */
                    }
                }
                else if(y == 1) {
                    /* PEÃO BRANCO
                    casa = tabuleiro.getCasa(x,y);
                    */
                }
                else if(y == 6) {
                    /* PEÃO PRETO
                    casa = tabuleiro.getCasa(x,y);
                    */
                }
            }
        }
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();

        if(!(peca.haPecas(tabuleiro, destino))) {
            if(peca.captura(destino)) {
                eliminarPeca(destino);
                peca.mover(destino);
            }
            else if(peca.podeMover(destino)) {
                peca.mover(destino);
            }
        }
    }

    public void eliminarPeca(Casa casa) {
        casa.removerPeca();
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
