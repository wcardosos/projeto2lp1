
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public abstract class Peca {

    protected Casa casa;
    protected Jogador jogador;

    public Peca(Casa casa, Jogador jogador) {
        this.casa = casa;
        this.jogador = jogador;
        casa.colocarPeca(this);
    }

    public abstract boolean haPecas(Tabuleiro tabuleiro, Casa destino);
    public abstract boolean movimentoValido(Casa destino);
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }

    public boolean podeMover(Casa destino) {
        if(destino.getPeca() == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean captura(Casa destino) {
        if(destino.getPeca() != null && destino.getPeca().getJogador() != jogador) {
            return true;
        }
        else {
            return false;
        }
    }

    public Jogador getJogador() {
        return jogador;
    }
}
