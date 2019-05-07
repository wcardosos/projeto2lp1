
/**
 * Classe abstrata que representa uma Peça do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 * @author Wagner Cardoso &lt;wagnersilva@cc.ci.ufpb.br&gt;
 * @author Daniel
 */

public abstract class Peca {

    protected Casa casa;
    protected Jogador jogador;

    public Peca(Casa casa, Jogador jogador) {
        this.casa = casa;
        this.jogador = jogador;
        casa.colocarPeca(this);
    }

    /**
     * Método abstrato para verificar se há peças entre a casa da peça
     * e sua casa de destino.
     */
    public abstract boolean haPecas(Tabuleiro tabuleiro, Casa destino);

    /**
     * Método abstrato para verificar se um movimento é válido de acordo
     * com as regras de movimentação de uma determinada peça.
     */
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

    /**
     * Verifica se a peça pode ser movida para a casa de destino.
     * @param destino casa para onde quer se mover a peca.
     * @return se a peça pode ser movida para a casa de destino.
     */
    public boolean podeMover(Casa destino) {
        if(destino.getPeca() == null) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Verifica se a peça pode capturar uma peça adversária.
     * @param destino casa onde será verificada a eliminação.
     * @return se a peça pode realizar uma captura.
     */
    public boolean captura(Casa destino) {
        if(destino.getPeca() != null && destino.getPeca().getJogador() != jogador) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return casa onde a peça está.
     */
    public Casa getCasa() {
        return casa;
    }

    /**
     * @return jogador ao qual a peça está vinculada.
     */
    public Jogador getJogador() {
        return jogador;
    }
}
