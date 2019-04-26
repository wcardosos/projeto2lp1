
/**
 * Escreva a descrição da classe Jogador aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

import java.util.ArrayList;

public class Jogador
{
   private ArrayList<Peca> pecas;
   
   public Jogador() {
       pecas = new ArrayList();
   }
    
   public void adicionarPeca(Peca peca) {
      pecas.add(peca);
   }
    
   public void removerPeca(Peca peca) {
       pecas.remove(peca);
   }
    
   public ArrayList<Peca> getPecas() {
       return pecas;
   }
}
