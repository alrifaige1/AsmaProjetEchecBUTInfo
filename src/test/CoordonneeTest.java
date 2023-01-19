package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Coord.Coordonnee;

class CoordonneeTest {
	@Test
	void test() {
		Coordonnee coordA1 = new Coordonnee("A1");
		
		assertEquals(0, coordA1.getIColonne()); // indice qui commence par 0 c'est A (voir l'instance de la coordA1)
		assertEquals(0, coordA1.getILigne()); // indice qui commence par 1 c'est 1 	
		assertEquals(1, coordA1.getLigne()); // ecart sur l'axe x
		assertEquals('A', coordA1.getColonne()); // ecart sur l'axe y
		assertEquals("A1", coordA1.toString()); // ecrire en 1 seul bloc
		
		Coordonnee coordH8 = new Coordonnee("H8");
		assertEquals('H', coordH8.getColonne());
		assertEquals(7, coordH8.getIColonne());
		assertEquals(8, coordH8.getLigne());
		assertEquals(7, coordH8.getILigne());
		assertEquals("H8", coordH8.toString());
		
		assertEquals(7, coordA1.getDx(coordH8));
		assertEquals(7, coordA1.getDy(coordH8));
		
		Coordonnee coordE4 = new Coordonnee("E4");
		assertEquals(-3, coordH8.getDx(coordE4));
		assertEquals(-4, coordH8.getDy(coordE4));
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			Coordonnee coordI9 = new Coordonnee("I9");
		});
	}
}
