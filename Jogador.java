
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
	private Rei rei;
	private boolean reiEmXeque;
	private boolean xequeMate;

	public Jogador() {
		pecas = new ArrayList();
		rei = null;
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

	public void setRei(Rei rei) {
		this.rei = rei;
	}

	public Rei getRei() {
		return rei;
	}

	public void xeque() {
		reiEmXeque = rei.getXeque();
	}

	public void xequeMate() {
		xequeMate = rei.getXequeMate();
	}

	public boolean getReiEmXeque() {
		xeque();
		return reiEmXeque;
	}

}
