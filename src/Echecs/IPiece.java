package Echecs;

import Coord.Coordonnee;

public interface IPiece {
	public int getCouleur();  // 0 blanc et 1 noir
	public char getSymbole();
	public boolean deplacementPossible(Coordonnee depart, Coordonnee arrivee);
}
