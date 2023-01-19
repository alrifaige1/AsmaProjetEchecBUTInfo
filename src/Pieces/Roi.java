package Pieces;

import Coord.Coordonnee;
import Echecs.IPiece;

public class Roi extends Piece implements IPiece{
//	private final static int BLANC =0;
//	private final static int NOIR =1;
	private int couleur;
	private char symbole;
	
	public Roi(int couleur) {
		super('r',couleur);
	}

	@Override
	public boolean deplacementPossible(Coordonnee depart, Coordonnee arrivee) {
		if (depart.equals(arrivee))
			return false;
		int dx = depart.getDx(arrivee);
		int dy = depart.getDy(arrivee);
		return Math.abs(dx) <=1 && Math.abs(dy) <=1; // se deplacer d'une case
	}
}
