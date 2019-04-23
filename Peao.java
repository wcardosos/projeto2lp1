public class Peao extends Peca {

	private int direcao;
	private int movimentos;
	private boolean promocao;
	private boolean captura;

	public Peao(Casa casa, char cor, int direcao) {
		super(casa, cor);
		this.direcao = direcao;
		this.movimentos = 0;
		this.promocao = false;
		this.captura = false;
	}

	public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
		return false;
	}

	public boolean movimentoValido(Casa destino) {
		boolean movimentoValido = false;
		if (movimentos < 1) {
			if(destino.getX() == casa.getX() && (destino.getY() == casa.getY() + direcao || destino.getY() == casa.getY() + (2 * direcao))) {
				movimentos++;
				movimentoValido = true;
			}

		}
		if(destino.getY() == casa.getY() + direcao) {
			if((destino.getX() == casa.getX() + 1 || destino.getX() == casa.getX() - 1) && destino.getPeca() != null) {
				if(destino.getPeca().getCor() != cor) {
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

	public int getMovimentos() {
		return movimentos;
	}
}