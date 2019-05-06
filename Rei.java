public class Rei extends Peca {

	private int movimentos;
	private boolean xeque;
	private boolean xequeMate;

	public Rei(Casa casa, Jogador jogador) {
		super(casa, jogador);
		movimentos = 0;
		xeque = false;
		xequeMate = false;
	}

	public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {

		if(xequeRei(tabuleiro, destino)) {
			return true;
		}
		if(xequeTorre(tabuleiro, destino)) {
			return true;
		}
		if(xequeBispo(tabuleiro, destino)) {
			return true;
		}
		if(xequeRainha(tabuleiro, destino)) {
			return true;
		}
		if(xequeCavalo(tabuleiro, destino)) {
			return true;
		}
		if(xequePeao(tabuleiro, destino)) {
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

		if(movimentos == 0) {
			movimentos++;
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
				if(pecaVerificacao instanceof Torre && pecaVerificacao.getJogador() != jogador) {
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
				if(pecaVerificacao instanceof Torre && pecaVerificacao.getJogador() != jogador) {
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
				if(pecaVerificacao instanceof Torre && pecaVerificacao.getJogador() != jogador) {
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
				if(pecaVerificacao instanceof Torre && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
				
			}
		}

		return false;
	}

	public boolean xequeBispo(Tabuleiro tabuleiro, Casa destino) {
		int aux;
		Peca pecaVerificacao;

		aux = destino.getX() + 1;
		for(int y = destino.getY() + 1; y <= 7 && aux <= 7; y++, aux++) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Bispo && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}

		aux = destino.getX() + 1;
		for(int y = destino.getY() - 1; y >= 0 && aux <= 7; y--, aux++) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Bispo && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}
		

		aux = destino.getX() - 1;
		for(int y = destino.getY() + 1; y <= 7 && aux >= 0; y++, aux--) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Bispo && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}

		aux = destino.getX() - 1;
		for(int y = destino.getY() - 1; y >= 0 && aux >= 0; y--, aux--) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Bispo && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}

		return false;
	}

	public boolean xequeRainha(Tabuleiro tabuleiro, Casa destino) {
		int aux;
		Peca pecaVerificacao;

		for(int y = destino.getY() + 1; y <= 7; y++) {
			pecaVerificacao = tabuleiro.getCasa(destino.getX(), y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
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
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
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
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
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
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
				
			}
		}

		aux = destino.getX() + 1;
		for(int y = destino.getY() + 1; y <= 7 && aux <= 7; y++, aux++) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}

		aux = destino.getX() + 1;
		for(int y = destino.getY() - 1; y >= 0 && aux <= 7; y--, aux++) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}
		

		aux = destino.getX() - 1;
		for(int y = destino.getY() + 1; y <= 7 && aux >= 0; y++, aux--) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}

		aux = destino.getX() - 1;
		for(int y = destino.getY() - 1; y >= 0 && aux >= 0; y--, aux--) {
			pecaVerificacao = tabuleiro.getCasa(aux, y).getPeca();
			if(pecaVerificacao != null) {
				if(pecaVerificacao instanceof Rainha && pecaVerificacao.getJogador() != jogador) {
					return true;
				}
				else {
					break;
				}
			}
		}

		return false;
	}

	public boolean xequeCavalo(Tabuleiro tabuleiro, Casa destino) {
		Peca pecaVerificacao;

		for(int y = destino.getY() + 2; y >= destino.getY() - 2; y -= 4) {
			for(int x = destino.getX() + 1; x >= destino.getX() - 1; x -= 2) {
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					pecaVerificacao = tabuleiro.getCasa(x,y).getPeca();
					if(pecaVerificacao != null) {
						if(pecaVerificacao instanceof Cavalo && pecaVerificacao.getJogador() != jogador) {
							return true;
						}
					}
				}
			}
		}

		for(int y = destino.getY() + 1; y >= destino.getY() - 1; y -= 2) {
			for(int x = destino.getX() + 2; x >= destino.getX() - 2; x -= 4) {
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					pecaVerificacao = tabuleiro.getCasa(x,y).getPeca();
					if(pecaVerificacao != null) {
						if(pecaVerificacao.getJogador() != jogador) {
							if(pecaVerificacao instanceof Cavalo) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}
	public boolean xequePeao(Tabuleiro tabuleiro, Casa destino) {
		Peca pecaVerificacao;
		Peao peao;

		for(int y = destino.getY() + 1; y >= destino.getY() - 1; y -= 2) {
			for(int x = destino.getX() + 1; x >= destino.getX() - 1; x -= 2) {
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					pecaVerificacao = tabuleiro.getCasa(x,y).getPeca();
					if(pecaVerificacao != null) {
						if(pecaVerificacao.getJogador() != jogador) {
							if(pecaVerificacao instanceof Peao) {
								peao = (Peao) pecaVerificacao;
								if(peao.getCasa().getY() + peao.getSentido() == destino.getY()){
									return true;
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

	public void verificaXeque(Tabuleiro tabuleiro) {
		xeque = haPecas(tabuleiro, casa);
	}

	public boolean verificaXequeMate(Tabuleiro tabuleiro) {
		boolean xequeMate = true;
		for(int y = casa.getY() + 1; y >= casa.getY() - 1; y--) {
			for(int x = casa.getX() + 1; x >= casa.getX() - 1; x--) {
				if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
					if(x == casa.getX() && y == casa.getY()) {
						continue;
					}

					if(!haPecas(tabuleiro, tabuleiro.getCasa(x,y))) {
						xequeMate = false;
					}
				}
			}

			if(!xequeMate) {
				break;
			}
		}

		return xequeMate;
	}


	public boolean getXeque() {
		return xeque;
	}

	public boolean getXequeMate() {
		return xequeMate;
	}
}