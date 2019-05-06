public class Torre extends Peca {
    
    private int movimentos;

    public Torre(Casa casa, Jogador jogador) {
        super(casa, jogador);
        movimentos = 0;
    }

    public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
        boolean haPecas = false;
        
        if(destino.getX() == casa.getX() || destino.getY() == casa.getY()) {
           	if(destino.getX() == casa.getX()) {
           		if(destino.getY() > casa.getY()) {
           			for(int y = casa.getY() + 1; y < destino.getY(); y++) {
           				if(tabuleiro.getCasa(casa.getX(), y).getPeca() != null) {
           					haPecas = true;
           					break;
           				}
           			}
           		}
           		else {
           			for(int y = casa.getY() - 1; y > destino.getY(); y--) {
           				if(tabuleiro.getCasa(casa.getX(), y).getPeca() != null) {
            				haPecas = true;
            				break;
            			}
            		}
            	}
           	}
        	else if(destino.getY() == casa.getY()) {
         		if(destino.getX() > casa.getX()) {
          			for(int x = casa.getX() + 1; x < destino.getX(); x++) {
           				if(tabuleiro.getCasa(x, casa.getY()).getPeca() != null) {
           					haPecas = true;
           					break;
           				}
           			}
           		}
           		else {
          			for(int x = casa.getX() - 1; x > destino.getX(); x--) {
           				if(tabuleiro.getCasa(x, casa.getY()).getPeca() != null) {
           					haPecas = true;
           					break;
           				}
           			}
           		}
        	}
    	}
    	else {
    		haPecas = true;
    	}

    	return haPecas;
    
    }

    public boolean movimentoValido(Casa destino) {

        if(movimentos == 0) {
            movimentos++;
        }
        
		    if(casa.getX() == destino.getX() || casa.getY() == destino.getY()) {
		        return true;
		    }
		    else {
		        return false;
		    }
	 }

}