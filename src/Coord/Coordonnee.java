package Coord;

/* Un objet Coord represente les 2 coordoonees d'une grille
	 * rectangulaire. La premiere represente la colonne et la seconde
	 * la ligne.
	 * La premiere colonne est 'A', la suivante 'B' etc.
	 * La premiere ligne est 1, la suivante 2 etc.
*/

public class Coordonnee {
		public static final char COLONNE_MIN = 'A';  // pour que ce soit accessible partout
		public static final int LIGNE_MIN = 1;
		
		private int ligne, colonne; // positions des pieces sur la grille (00 pour A1, 10 pour B1, ...)
		
		/**
		 * Constructeur de la classe {@link Coordonnee} permettant de creer une nouvelle
		 * instance de cette classe a partir d'une chaine de caracteres representant
		 * les coordonnees d'un jeu d'echecs.
		 * 
		 * La chaine de caracteres doit avoir le format suivant : une lettre entre 'A'
		 * et 'H' suivie d'un chiffre entre 1 et 8.
		 * 
		 * @param s chaine de caracteres representant les coordonnees d'un jeu d'echecs
		 * @throws IllegalArgumentException si la chaine de caracteres n'a pas le format
		 * attendu ou si les coordonnees sont en dehors de la grille de jeu
		 */
		public Coordonnee(String s) {
		    // Verifie que la chaine de caracteres a bien une longueur de 2 caracteres
		    if (s.length() != 2) 
		        throw new IllegalArgumentException("Case incorrecte, il faut tapper 2 caracteres : "+s);
		    
		    // Recupere la colonne et la ligne de la chaine de caracteres
		    char colonne = s.charAt(0);
		    int ligne = s.charAt(1) - '0'; // convertie le char en nb (avec l'aide des codes ASCII)
		    // Verifie que la colonne est bien une lettre entre 'A' et 'H' et que la ligne
		    // est un chiffre entre 1 et 8
		    if (colonne < 'A' || colonne > 'H' || ligne < 1 || ligne > 8) 
		        throw new IllegalArgumentException("Case incorrecte, ca depasse la taille de la grille : "+s);
			this.ligne = ligne - LIGNE_MIN; // on veut enlever le 1 de trop 
			this.colonne = colonne - COLONNE_MIN;
		}
		public char getColonne() {
			return (char)(colonne + 'A');
		}
		
		public int getLigne() {
			return ligne +LIGNE_MIN;
		}
		
		// indice qui commence a 0
		public int getIColonne() {
			return colonne;
		}
		
		// indice qui commence a 0
		public int getILigne() {
			return ligne;
		}
		
		// ecart horizontal
		public int getDx(Coordonnee c) {
			return c.getIColonne() - this.getIColonne();
		}
		
		// ecart vertical
		public int getDy(Coordonnee c) {
			return c.getILigne() - this.getILigne();
		}
		
		@Override
		public String toString() {
			return ""+ getColonne()+getLigne();
		}

		@Override
		public int hashCode() { // c'est obligatoire c'est quand on a des maps : on veut trier les index (ici les coord) de la map
			final int prime = 31;
			int result = 1;
			result = prime * result + colonne;
			result = prime * result + ligne;
			return result;
		}

		@Override
		public boolean equals(Object obj) { // on teste est ce que les classes de mes objets sont les memes ...
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordonnee other = (Coordonnee) obj;
			if (colonne != other.colonne)
				return false;
			if (ligne != other.ligne)
				return false;
			return true;
		}
		
		public static boolean coordPossible(String coord) {
			String s= coord.toUpperCase(); // met toutes les coord en majuscule meme si on les a mise en minuscule
			// Vérifie que la chaîne a la bonne longueur : coord depart + espace+ coord arrivee  
			if (s.length() != 5) {
				return false;
			}
			// Vérifie que les deux premiers et les deux derniers caractères sont des lettres et des chiffres respectivement
			if (!Character.isLetter(s.charAt(0)) || !Character.isLetter(s.charAt(3)) || !Character.isDigit(s.charAt(1)) || !Character.isDigit(s.charAt(4))) {
				return false;
			}
			// Vérifie que les lettres sont compris entre 'A' et 'H'
			if (s.charAt(0) < 'A' || s.charAt(0) > 'H' || s.charAt(3) < 'A' || s.charAt(3) > 'H') {
				return false;
			}// Vérifie que les chiffres sont compris entre 1 et 8
			if (s.charAt(1) < '1' || s.charAt(1) > '8' || s.charAt(4) < '1' || s.charAt(4) > '8') {
				return false;
			}
			// Si toutes les vérifications ont réussi, la chaîne est une chaîne de déplacement de pion valide
				return true;
		}
}


