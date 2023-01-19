package Pieces;

import Coord.Coordonnee;
import Echecs.IPiece;

public class Piece {
	private char symbole = 'x'; // par defaut
	private final static int BLANC =0;
	private final static int NOIR =1;
	private int couleur = BLANC;
	
	public Piece(char symbole, int couleur) {
		this.symbole=symbole;
		this.couleur= couleur;
	}
	
	public char getSymbole() {
		if(couleur == BLANC)
			return symbole; // symbole en minuscule
		else
			return Character.toUpperCase(symbole); // mettre les symboles en majuscule
	}

	public int getCouleur() {
		return couleur;
	}
	
	@Override
	public String toString() {
		return ""+ this.getSymbole();
	}
}
