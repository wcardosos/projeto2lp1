
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

        // Posicionamento Torre Branca
        casa = tabuleiro.getCasa(0,0);
        peca = new Torre(casa, 'b');
        casa = tabuleiro.getCasa(7,0);
        peca = new Torre(casa, 'b');

        // Posicionamento Torre Preta
        casa = tabuleiro.getCasa(0,7);
        peca = new Torre(casa, 'p');
        casa = tabuleiro.getCasa(7,7);
        peca = new Torre(casa, 'p');
        
        // Posicionamento Bispo Branco
        casa = tabuleiro.getCasa(2,0);
        peca = new Bispo(casa, 'b');        
        casa = tabuleiro.getCasa(5,0);
        peca = new Bispo(casa, 'b');
        
        // Posiciamento Bispo Preto
        casa = tabuleiro.getCasa(2,7);
        peca = new Bispo(casa, 'p');        
        casa = tabuleiro.getCasa(5,7);
        peca = new Bispo(casa, 'p');
        
        // Posicionamento Cavalo Branco
        casa = tabuleiro.getCasa(1,0);
        peca = new Cavalo(casa, 'b');
        casa = tabuleiro.getCasa(6,0);
        peca = new Cavalo(casa, 'b');
        
        // Posicionamento Cavalo Preto
        casa = tabuleiro.getCasa(1,7);
        peca = new Cavalo(casa, 'p');
        casa = tabuleiro.getCasa(6,7);
        peca = new Cavalo(casa, 'p');
        
        
        

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

