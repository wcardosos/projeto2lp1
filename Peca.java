
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
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }

    public boolean limite(int pos) {
        if (pos < 0) {
            return false;
        } else if (pos > 7) {
            return false;
        } else {
            return true;
        }
    }

    public abstract boolean haPecas(Tabuleiro tabuleiro, Casa destino);
    public abstract boolean podeMover(Casa destino);
    public abstract boolean captura(Casa destino);

    public char getCor() {
        return cor;
    }
}
