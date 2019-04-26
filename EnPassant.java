	public boolean EnPassant(Tabuleiro tabuleiro, Casa destino){
		Peca pecaVerificacao;
		boolean EnPassant = false;
		int x;
		if(sentido == -1){
			int y = destino.getY() + 1;
			if((casa.getX() == 1 || casa.getX() == 6) && casa.getY() ==  3) {
				if((destino.getX() == 0 || destino.getX() == 7) && destino.getY() == 2){				        
					Peca checar = destino.getPeca();
					if(tabuleiro.getCasa(casa.getX(), y).getPeca() != null){
					    if(checar instanceof Peao){
							if(destino.getPeca().getJogador() != jogador) {
								EnPassant = true;
							    mover(destino);
								System.out.println("verEnPassant: " + EnPassant);
							}
						}
					}
				}
			}			
		}else if(sentido == 1){
			int y = destino.getY() - 1;
			if((casa.getX() == 1 || casa.getX() == 6) && casa.getY() ==  4) {
				if((destino.getX() == 0 || destino.getX() == 7) && destino.getY() == 5){
					Peca checar = destino.getPeca();
					if(tabuleiro.getCasa(destino.getX(), y).getPeca() != null){
					    if(checar instanceof Peao){
							if(destino.getPeca().getJogador() != jogador) {
								EnPassant = true;
								mover(destino);
								System.out.println("verEnPassant: " + EnPassant);
							}
					    }
					}
				}
			}
		    }                 
		System.out.println("verEnPassant: " + EnPassant);
		return EnPassant;
    }
