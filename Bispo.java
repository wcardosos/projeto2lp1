public class Bispo extends Peca {

    public Bispo(Casa casa, Jogador jogador) {
        super(casa, jogador);
    }

    public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
        boolean haPecas = false;
        int casaX, casaY;
        
        if(destino.getX() > casa.getX() && destino.getY() > casa.getY()) {
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

    public boolean movimentoValido(Casa destino) {
        int deltaX = Math.abs(destino.getX() - casa.getX());
        int deltaY = Math.abs(destino.getY() - casa.getY());

        if(deltaX == deltaY) {
            return true;
        }
        else {
            return false;
        }
    }

}