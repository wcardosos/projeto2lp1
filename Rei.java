public class Rei extends Peca {

	public Rei(Casa casa, Jogador jogador) {
		super(casa, jogador);
	}

	public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
		return false;
	}

	public boolean movimentoValido(Casa destino) {
		boolean movimentoValido = false;
		if(destino.getX() == casa.getX() && (destino.getY() == casa.getY() + 1 || destino.getY() == casa.getY() - 1)) {
			movimentoValido = true;
		}
		else if(destino.getY() == casa.getY() && (destino.getX() == casa.getX() + 1 || destino.getX() == casa.getX() - 1)) {
			movimentoValido = true;
		}
		else if(destino.getY() == casa.getY() + 1 || destino.getY() == casa.getY() - 1) {
			if(destino.getX() == casa.getX() + 1 || destino.getX() == casa.getX() - 1) {
				movimentoValido = true;
			}
		}

		return movimentoValido;
	}
}