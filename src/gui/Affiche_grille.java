package gui;

import Coord.Coordonnee;
import Echecs.Echiquier;

public class Affiche_grille {
	/**
	 *  Genere les entetes de colonne pour l'interface du jeu d'echecs.
	 *  le parametre nbCol est le nombre de colonnes a generer
	 *  return La chaine de caracteres contenant les entetes de colonne
	 **/
		public static String getColonnes(int nbCol) { // static : permet d'avoir acces dans toutes les classes sans faire d'instanciation different de public (obliger de faire l'instanciation)
			StringBuilder sb = new StringBuilder(" "); // instanciation du StringBuilder() 
			int i = 0;
			char c = 'A'; // tous les caracteres de l'alphabet

			while(i != nbCol) {
				++i;
				sb.append("  ").append(c).append("  |").append("");
				++c; // l'incrementation pour avoir tous les caractères de l'alphabet (on passe de A, puis B, .... H)
			}
			// Supprime le dernier caractere de la chaine (le "|")
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();

		}
	
		
	/** Genere les lignes de l'interface du jeu d'echecs.
	*	param nbLig Le nombre de lignes a generer
	*	param nbCol Le nombre de colonnes a generer
	*	return La chaine de caracteres contenant les lignes de l'interface
	**/
		 public static String getLignes(int nbLig, int nbCol, Echiquier e) {
			StringBuilder sblig = new StringBuilder();
			Coordonnee coord;
			 for(int j=nbLig; j!= 0; j--) {
				 sblig.append(j).append("  ");
				 for(char k='A'; k!= 'A' + nbCol; k++) {
					 coord = new Coordonnee(String.valueOf(k)+j);
					 if(!e.estVide(coord))  
						 sblig.append("  ").append(e.getPiece(coord)).append("  |");
					 else
						 sblig.append("     |");			 
				 }
				 sblig.append(" ").append(j).append("\n");
			 }
			 return sblig.toString();
		 }
		 
		 public static void afficher(int HAUTEUR,int LARGEUR, Echiquier e)  { 
			System.out.println("  "+ getColonnes(LARGEUR));
			System.out.print(getLignes(HAUTEUR,LARGEUR, e));
			System.out.println("  "+ getColonnes(LARGEUR));
		}
}
