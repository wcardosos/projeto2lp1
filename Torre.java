/**
 * Classe que representa a peça Torre de um jogo de xadrez.
 * @author Wagner Cardoso &lt;wagnersilva@cc.ci.ufpb.br&gt;
 */

public class Torre extends Peca {
    
    private int movimentos;

    public Torre(Casa casa, Jogador jogador) {
        super(casa, jogador);
        movimentos = 0;
    }

    /**
     * Verifica se há peças entre a casa de origem da peça e
     * a casa para onde se deseja fazer o movimento.
     * @param tabuleiro para verificar as peças durante o caminho.
     * @param destino casa para onde se deseja fazer o movimento.
     * @return se há peças durante entre a casa de origem e a
     * casa de destino.
     */
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

    /**
     * Verifica se o movimento é válido de acordo com as regras
     * de movimentação da peça,
     */
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