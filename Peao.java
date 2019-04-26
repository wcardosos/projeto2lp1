public class Peao extends Peca {

	private int sentido; // Sentido -> cima, baixo ; Direcao -> vertical, horizontal
	private int movimentos; 
	private boolean promocao;
	private boolean captura;

	public Peao(Casa casa, Jogador jogador, int sentido) {
		super(casa, jogador);
		this.sentido = sentido;
		this.movimentos = 0;
		this.promocao = false;
		this.captura = false;
	}

	public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
        verificarPromocao();
    }

	public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
		return false;
	}

	public boolean movimentoValido(Casa destino) {
		boolean movimentoValido = false;
		if (movimentos < 1) {
			if(destino.getX() == casa.getX() && (destino.getY() == casa.getY() + sentido || destino.getY() == casa.getY() + (2 * sentido))) {
				movimentos++;
				movimentoValido = true;
				mover(destino);
			}

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

	public boolean captura(Casa destino) {
		if(captura) {
			captura = false;
			return !captura;
		}
		else {
			return captura;
		}
	}

	public void verificarPromocao() {
		if(sentido == 1) {
			if(casa.getY() == 7) {
				promocao = true;
			}
		}
		else if(sentido == -1) {
			if(casa.getY() == 0) {
				promocao = true;
			}
		}
	}

	public int getMovimentos() {
		return movimentos;
	}
}
