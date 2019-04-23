
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public abstract class Peca {

    protected Casa casa;
    protected char cor;

    public Peca(Casa casa, char cor) {
        this.casa = casa;
        this.cor = cor;
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
        if(destino.getPeca() != null && destino.getPeca().getCor() != cor) {
            return true;
        }
        else {
            return false;
        }
    }

    public char getCor() {
        return cor;
    }
}
