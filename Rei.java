public class Rei extends Peca {

	public Rei(Casa casa, Jogador jogador) {
		super(casa, jogador);
	}

	public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {

		if(xequeRei(tabuleiro, destino)) {
			return true;
		}
		if(xequeTorre(tabuleiro, destino)) {
			return true;
		}

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

	public boolean xequeRei(Tabuleiro tabuleiro, Casa destino) {
		Peca pecaVerificacao;
		boolean reiEncontrado = false;
		int x;
		int y = destino.getY() + 1;

		while(y >= destino.getY() - 1) {
			if(y < 0) {
				break;
			}
			else if(y > 7) {
				y--;
				continue;
			}

			x = destino.getX() + 1;
			while(x >= destino.getX() - 1) {
				if(x < 0) {
					break;
					
				}
				else if(x > 7) {
					x--;
					continue;

				}
				
				if(y == destino.getY() && x == destino.getX()) {
					x--;
				}
				else if(tabuleiro.getCasa(x,y).getPeca() != null) {
					pecaVerificacao = tabuleiro.getCasa(x,y).getPeca();
					if(pecaVerificacao.getJogador() == jogador) {
						x--;
					}
					else if(pecaVerificacao instanceof Rei) {
						reiEncontrado = true;
						break;
					}
				}

				x--;
			}

			if(reiEncontrado) {
				break;
			}
			else {
				y--;
			}
		}

		return reiEncontrado;
	}

	public boolean xequeTorre(Tabuleiro tabuleiro, Casa destino) {
		Peca pecaVerificacao;

		for(int y = destino.getY() + 1; y <= 7; y++) {
			pecaVerificacao = tabuleiro.getCasa(destino.getX(), y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Torre) {
					return true;
				}
				else {
					break;
				}
				
			}
		}

		for(int y = destino.getY() - 1; y >= 0; y--) {
			pecaVerificacao = tabuleiro.getCasa(destino.getX(), y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Torre) {
					return true;
				}
				else {
					break;
				}
				
			}
		}

		for(int x = destino.getX() + 1; x <= 7; x++) {
			pecaVerificacao = tabuleiro.getCasa(x, destino.getY()).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Torre) {
					return true;
				}
				else {
					break;
				}
				
			}
		}

		for(int x = destino.getX() - 1; x >= 0; x--) {
			pecaVerificacao = tabuleiro.getCasa(x, destino.getY()).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Torre) {
					return true;
				}
				else {
					break;
				}
				
			}
		}

		return false;
	}
}