
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    private Jogador jogadorPecasBrancas;
    private Jogador jogadorPecasPretas;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        jogadorPecasBrancas = new Jogador();
        jogadorPecasPretas = new Jogador();
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
                        peca = new Torre(casa, jogadorPecasBrancas);
                        jogadorPecasBrancas.adicionarPeca(peca);
                    }
                    else if(x == 1 || x == 6) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Cavalo(casa, jogadorPecasBrancas);
                        jogadorPecasBrancas.adicionarPeca(peca);
                    }
                    else if(x == 2 || x == 5) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Bispo(casa, jogadorPecasBrancas);
                        jogadorPecasBrancas.adicionarPeca(peca);
                    }
                    else if(x == 3) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Rainha(casa, jogadorPecasBrancas);
                        jogadorPecasBrancas.adicionarPeca(peca);
                    }
                    else {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Rei(casa, jogadorPecasBrancas);
                        jogadorPecasBrancas.adicionarPeca(peca);
                    }
                }
                else if(y == 7) {
                    if(x == 0 || x ==7) {
                        casa = tabuleiro.getCasa(x, y);
                        peca = new Torre(casa, jogadorPecasPretas);
                        jogadorPecasPretas.adicionarPeca(peca);
                    }
                    else if(x == 1 || x == 6) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Cavalo(casa, jogadorPecasPretas);
                        jogadorPecasPretas.adicionarPeca(peca);
                    }
                    else if(x == 2 || x == 5) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Bispo(casa, jogadorPecasPretas);
                        jogadorPecasPretas.adicionarPeca(peca);
                    }
                    else if(x == 3) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Rainha(casa, jogadorPecasPretas);
                        jogadorPecasPretas.adicionarPeca(peca);
                    }
                    else {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Rei(casa, jogadorPecasPretas);
                        jogadorPecasPretas.adicionarPeca(peca);
                    }
                }
                else if(y == 1) {
                    casa = tabuleiro.getCasa(x,y);
                    peca = new Peao(casa, jogadorPecasBrancas, 1);
                    jogadorPecasBrancas.adicionarPeca(peca);
                }
                else if(y == 6) {
                    casa = tabuleiro.getCasa(x,y);
                    peca = new Peao(casa, jogadorPecasPretas, -1);
                    jogadorPecasPretas.adicionarPeca(peca);
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

        if(peca.movimentoValido(destino)) {
            if(!(peca.haPecas(tabuleiro, destino))) {
                if(peca.captura(destino)){
                    eliminarPeca(destino);
                    peca.mover(destino);
                }
                else if(peca.podeMover(destino)) {
                peca.mover(destino);
                }
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
    
    public Jogador getJogadorPecasBrancas() {
        return jogadorPecasBrancas;
    }
    
    public Jogador getJogadorPecasPretas() {
        return jogadorPecasPretas;
    }
}
