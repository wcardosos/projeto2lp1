/**
 * Classe que representa a peça Rainha de um jogo de xadrez.
 * @author Wagner Cardoso &lt;wagnersilva@cc.ci.ufpb.br&gt;
 */

public class Rainha extends Peca {

	public Rainha(Casa casa, Jogador jogador) {
		super(casa, jogador);
	}

  /**
   * Verifica se há peças entre a casa de origem e o destino.
   * Usa-se o mesmo raciocínio das verificações existentes nas
   * classes Bispo e Torre.
   * @param tabuleiro para verificação das casas até o destino.
   * @param destino casa para onde se deseja fazer o movimento.
   * @return se há peças no caminho da casa de origem até o destino.
   */
	public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
		boolean haPecas = false;
    int casaX, casaY;

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
		
		else if(destino.getX() > casa.getX() && destino.getY() > casa.getY()) {
            casaX = casa.getX() + 1;
            casaY = casa.getY() + 1;

            while (casaX < destino.getX() && casaY < destino.getY()) {
                 if(tabuleiro.getCasa(casaX, casaY).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    casaX++;
                    casaY++;
                }
            }
        }
        else if(destino.getX() > casa.getX() && destino.getY() < casa.getY()){
            casaX = casa.getX() + 1;
            casaY = casa.getY() - 1;
            while (casaX < destino.getX() && casaY > destino.getY()) {
                 if(tabuleiro.getCasa(casaX, casaY).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    casaX++;
                    casaY--;
                }
            }
        }
        else if(destino.getX() < casa.getX() && destino.getY() < casa.getY()){
            casaX = casa.getX() - 1;
            casaY = casa.getY() - 1;
            while (casaX > destino.getX() && casaY > destino.getY()) {
                 if(tabuleiro.getCasa(casaX, casaY).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    casaX--;
                    casaY--;
                }
            }
        }
        else if(destino.getX() < casa.getX() && destino.getY() > casa.getY()){
            casaX = casa.getX() - 1;
            casaY = casa.getY() + 1;
            while (casaX > destino.getX() && casaY < destino.getY()) {
                 if(tabuleiro.getCasa(casaX, casaY).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    casaX--;
                    casaY++;
                }
            }
        }

        else {
        	haPecas = true;
        }

        return haPecas;
	}

  /**
   * @return se o movimento é válido de acordo com as regras de 
   * movimentação da peça.
   */
	public boolean movimentoValido(Casa destino) {
		int deltaX = Math.abs(destino.getX() - casa.getX());
    int deltaY = Math.abs(destino.getY() - casa.getY());

    if(casa.getX() == destino.getX() || casa.getY() == destino.getY() || deltaX == deltaY) {
			return true;
		}
		else {
			return false;
		}
	}
	
}