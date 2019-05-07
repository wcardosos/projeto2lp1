
/**
 * Classe que representa a peça Peão de um jogo de Xadrez.
 * @author Wagner Cardoso &lt;wagnersilva@cc.ci.ufpb.br&gt;
 */

public class Peao extends Peca {

	private int sentido;
	private int movimentos;
	private boolean captura;

	public Peao(Casa casa, Jogador jogador, int sentido) {
		super(casa, jogador);
		this.sentido = sentido;
		this.movimentos = 0;
		this.captura = false;
	}

	/**
     * Move uma peça para uma determinada casa.
     */
	public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
        verificarPromocao();
    }

    /**
     * Como o peão sempre irá mover apenas uma casa à sua frente, a verificação
     * de peças à sua frente já é feita pelo movimentoValido.
     */
	public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
		return false;
	}

	/**
     * Verifica se o movimento é válido de acordo com as regras de movimentação
     * da peça.
     * @param destino casa para se deseja fazer o movimento.
     * @return se o movimento é válido.
     */
	public boolean movimentoValido(Casa destino) {
		boolean movimentoValido = false;
		if (movimentos < 1 && destino.getX() == casa.getX() && (destino.getY() == casa.getY() + (2 * sentido)) && destino.getPeca() == null) {
			movimentos++;
			movimentoValido = true;
		}
		if(destino.getY() == casa.getY() + sentido) {
			if((destino.getX() == casa.getX() + 1 || destino.getX() == casa.getX() - 1) && destino.getPeca() != null) {
				if(destino.getPeca().getJogador() != jogador) {
					captura = true;
					movimentoValido = true;
				}
			}
			else if(destino.getX() == casa.getX()) {
				movimentoValido = true;
			}

		}

		return movimentoValido;
	}

	/**
     * Sobrescreve o método de captura.
     */
	public boolean captura(Casa destino) {
		if(captura) {
			captura = false;
			return !captura;
		}
		else {
			return captura;
		}
	}

	/**
     * Verifica se o peão será promovido.
     * Caso ele possa, promove-se para uma rainha.
     */
	public void verificarPromocao() {
		if(sentido == 1) {
			if(casa.getY() == 7) {
				Rainha rainha = new Rainha(casa, jogador);
				jogador.removerPeca(this);
				jogador.adicionarPeca(rainha);
			}
		}
		else if(sentido == -1) {
			if(casa.getY() == 0) {
				Rainha rainha = new Rainha(casa, jogador);
				jogador.removerPeca(this);
				jogador.adicionarPeca(rainha);
			}
		}
	}

	/**
     * @return se o peão já se movimentou.
     */
	public int getMovimentos() {
		return movimentos;
	}

	/**
     * @return o sentido que o peão se movimenta.
     */
	public int getSentido() {
		return sentido;
	}
}
