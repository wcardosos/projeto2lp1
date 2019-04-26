public class Cavalo extends Peca
{

    public Cavalo(Casa casa, Jogador jogador) {
        super(casa, jogador);
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
        
        if(destino.getX() == casa.getX() + 2 && destino.getY() == casa.getY() + 1) {
            return true;
        }
        else if(destino.getX() == casa.getX() + 1 && destino.getY() == casa.getY() + 2){
            return true;
        }
        else if(destino.getX() == casa.getX() - 1 && destino.getY() == casa.getY() + 2){
            return true;
        }
        else if(destino.getX() == casa.getX() - 2 && destino.getY() == casa.getY() + 1){
            return true;
        }
        else if(destino.getX() == casa.getX() - 2 && destino.getY() == casa.getY() - 1){
            return true;
        }
        else if(destino.getX() == casa.getX() - 1 && destino.getY() == casa.getY() - 2){
            return true;
        }
        else if(destino.getX() == casa.getX() + 1 && destino.getY() == casa.getY() - 2){
            return true;
        }
        else if(destino.getX() == casa.getX() + 2 && destino.getY() == casa.getY() - 1){
            return true;
        }
        
        else {
            return false;
        }
    }

}