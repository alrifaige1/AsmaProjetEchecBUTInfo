package Pieces;

import Coord.Coordonnee;
import Echecs.IPiece;

public class Dame extends Piece implements IPiece {
//	private final static int BLANC =0;
//	private final static int NOIR =1;
	private int couleur;
	private char symbole;
	
	public Dame(int couleur) {
		super('d', couleur);
	}
	
	@Override
	public boolean deplacementPossible(Coordonnee depart, Coordonnee arrivee) {
		if (depart.equals(arrivee))
			return false;
		int dx = depart.getDx(arrivee);
		int dy = depart.getDy(arrivee);
		return (dx == 0 || dy == 0 || Math.abs(dx) == Math.abs(dy)); // se deplacer d'une ou plusieurs cases
	}
}
