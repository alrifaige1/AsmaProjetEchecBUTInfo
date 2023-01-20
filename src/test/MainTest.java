package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Echecs.Echiquier;
import gui.Affiche_grille;

class MainTest {
//	private static  int HAUTEUR = 8;
//	private static  int LARGEUR = 8;
	
	@Test
	void test() {

		String echiquierCible= "   a   b   c   d   e   f   g   h \n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "8 |t| |c| |f| |r| |d| |f| |c| |t| 8\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "7 |p| |p| |p| |p| |p| |p| |p| |p| 7\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "6 | | | | | | | | | | | | | | | | 6\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "5 | | | | | | | | | | | | | | | | 5\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "4 | | | | | | | | | | | | | | | | 4\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "3 | | | | | | | | | | | | | | | | 3\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "2 |P| |P| |P| |P| |P| |P| |P| |P| 2\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "1 |T| |C| |F| |R| |D| |F| |C| |T| 1\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "   a   b   c   d   e   f   g   h \n";
		
		Echiquier echiquierTest= new Echiquier();
		echiquierTest.init_Echiquier();
		
//		assertEquals(Affiche_grille.afficher(HAUTEUR,LARGEUR, echiquierTest));
		
		String echiquierCible1= "   a   b   c   d   e   f   g   h \n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "8 |t| |c| |f| |r| |d| |f| |c| |t| 8\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "7 |p| |p| | | |p| |p| |p| |p| |p| 7\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "6 | | | | |p| | | | | | | | | | | 6\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "5 | | | | | | | | | | | | | | | | 5\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "4 | | | | | | | | | | | | | | | | 4\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "3 | | | | | | | | | | | | | | | | 3\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "2 |P| |P| |P| |P| |P| |P| |P| |P| 2\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "1 |T| |C| |F| |R| |D| |F| |C| |T| 1\n"
				+ "  --- --- --- --- --- --- --- ---\n"
				+ "   a   b   c   d   e   f   g   h \n";
		
		echiquierTest.init_Echiquier();
		
		echiquierTest.verifieFinJeu();
		
	}

}
