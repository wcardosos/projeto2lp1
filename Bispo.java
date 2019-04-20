public class Bispo extends Peca {

    public Bispo(Casa casa, char cor) {
        super(casa, cor);
    }

    public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
        boolean haPecas = false;
        int x, y;
        
        if(destino.getX() > casa.getX() && destino.getY() > casa.getY()) {
            x = casa.getX() + 1;
            y = casa.getY() + 1;

            while (x < destino.getX() && y < destino.getY()) {
                 if(tabuleiro.getCasa(x, y).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    x++;
                    y++;
                }
            }
        }
        else if(destino.getX() > casa.getX() && destino.getY() < casa.getY()){
            x = casa.getX() + 1;
            y = casa.getY() - 1;
            while (x < destino.getX() && y > destino.getY()) {
                 if(tabuleiro.getCasa(x, y).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    x++;
                    y--;
                }
            }
        }
        else if(destino.getX() < casa.getX() && destino.getY() < casa.getY()){
            x = casa.getX() - 1;
            y = casa.getY() - 1;
            while (x > destino.getX() && y > destino.getY()) {
                 if(tabuleiro.getCasa(x, y).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    x--;
                    y--;
                }
            }
        }
        else if(destino.getX() < casa.getX() && destino.getY() > casa.getY()){
            x = casa.getX() - 1;
            y = casa.getY() + 1;
            while (x > destino.getX() && y < destino.getY()) {
                 if(tabuleiro.getCasa(x, y).getPeca() != null) {
                       haPecas = true;
                       break;
                }
                else {
                    x--;
                    y++;
                }
            }
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