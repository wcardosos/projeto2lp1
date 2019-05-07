
/**
* Classe que representa um jogador de xadrez.
* 
* @author Wagner Cardoso &lt;wagnersilva@cc.ci.ufpb.br&gt;
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

	/**
	 * Adiciona uma peca à lista de peças.
	 */
	public void adicionarPeca(Peca peca) {
		pecas.add(peca);
	}

	/**
	 * Remove uma peça da lista de peças.
	 */
	public void removerPeca(Peca peca) {
		pecas.remove(peca);
	}

	/**
	 * Verifica se o rei do jogador está em xeque.
	 */
	public void xeque() {
		reiEmXeque = rei.getXeque();
	}

	/**
	 * Verifica se o rei do jogador sofreu um xeque mate.
	 */
	public void xequeMate() {
		xequeMate = rei.getXequeMate();
	}

	/**
	 * @return lista de peças do jogador.
	 */
	public ArrayList<Peca> getPecas() {
		return pecas;
	}

	/**
	 * Define o rei do jogador.
	 */
	public void setRei(Rei rei) {
		this.rei = rei;
	}

	/**
	 * @return rei do jogador.
	 */
	public Rei getRei() {
		return rei;
	}

	/**
	 * @return se o rei está em xeque.
	 */
	public boolean getReiEmXeque() {
		xeque(); // Veririca antes se o rei está em xeque.
		return reiEmXeque;
	}

}
