package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Coord.Coordonnee;
import Echecs.Echiquier;
import Pieces.Dame;
import Pieces.Roi;

class EchiquierTest {
	private static final int BLANC = 0;

	@Test
	void test() {
		Coordonnee e6 = new Coordonnee("E6");
		Coordonnee e1 = new Coordonnee("E1");
		Coordonnee e8 = new Coordonnee("E8");
		Coordonnee a7 = new Coordonnee("A7");
		Roi rbB = new Roi(0);
		Roi rbN = new Roi(1);
		Dame dB = new Dame(0);
		
		Echiquier e = new Echiquier();
		assertEquals(0, e.getNbPieces());
		e.ajouterPiece(e8, rbN);
		e.ajouterPiece(e1, rbB);
		assertEquals(2, e.getNbPieces());
		assertEquals(null, e.getPiece(e6));
		
		assertThrows(IllegalArgumentException.class, () -> {
			e.ajouterPiece(new Coordonnee("I3"), rbB);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			e.ajouterPiece(new Coordonnee("A0"), dB); 
		});
		assertThrows(IllegalArgumentException.class, () -> {
			e.ajouterPiece(new Coordonnee("C08"), dB); 
		});
		assertThrows(IllegalArgumentException.class, () -> {
			e.ajouterPiece(new Coordonnee("C"), dB); 
		});
	}
}
