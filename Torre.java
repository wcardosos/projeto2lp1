public class Torre extends Peca {

    public Torre(Casa casa, char cor) {
        super(casa, cor);
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
          			for(int x = casa.getX() + 1; x < destino.getY(); x++) {
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

    public boolean captura(Casa destino) {
    	if(destino.getPeca() != null && destino.getPeca().getCor() != cor) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean podeMover(Casa destino) {
    	if(destino.getPeca() == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}