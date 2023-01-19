package ihm;
import java.util.Scanner;

import Coord.Coordonnee;
import Echecs.Echiquier;
import IA.joueurIA;
import Pieces.Roi;
import gui.Affiche_grille;


/** 
 * Classe principale qui gère l'affichage de l'interface du jeu d'échecs.
**/

public class Main {	 
	 /**
	  * Point d'entree de l'application.
	  * param args Les arguments de la ligne de commande
	  **/	
	public static void main(String[] args) {
		// on veut afficher " A B C D E F G H"
		final int LARGEUR =8;
		final int HAUTEUR =8;
		//Coordonnee A= new Coordonnee('A',2);
		System.out.println(" ************************** Bienvenue au jeu d'echecs ! **************************** \n\n");
		System.out.println(" ///////// Petit Rappel avant de jouer! /// Les coups s'ecrivent aux formats \"a1 b3\" \n\n");
		
		Echiquier ech = new Echiquier();
		ech.init_Echiquier();
		Affiche_grille.afficher(HAUTEUR,LARGEUR, ech);
		
		boolean jeu = true;
		int joueur_actuel=0;
		int tour=0;
		String choix;
		Scanner sc= new Scanner(System.in);
		final int BLANC =0;
		final int NOIR =1;
		Coordonnee coordDepart, coordArrivee=null;
		
		boolean iaMode = false;
		int choixMode = 0;
		joueurIA ia = new joueurIA(ech);
		System.out.println("Jouer contre l'ordinateur ou contre un adversaire humain ?\n1: Humain\n2 IA");
		choixMode = sc.nextInt();
		
		if(choixMode == 2)
			iaMode = true;
		
		while(jeu == true) {
			joueur_actuel = tour%2; // joueur blanc (joueur 0) fait des tours pairs
			System.out.println("Joueur " + (joueur_actuel));  
			if(joueur_actuel == 0 || (joueur_actuel == 1 && !iaMode)) {
				System.out.println(" Quel coup voulez vous jouer ?\n ");
				choix = sc.nextLine(); // pour ne pas vider la memoire et mettre la reponse du choix tapper dans choix
				if(abandon(choix)) {
					System.out.println("Joueur "+ (joueur_actuel) + " a abandonne, la partie est stoppee ! ");
					break;
				}
				if(Coordonnee.coordPossible(choix)) {
					coordDepart = new Coordonnee(choix.split(" ")[0].toUpperCase());
					coordArrivee = new Coordonnee(choix.split(" ")[1].toUpperCase());
					
					if(ech.getPiece(coordDepart) != null)
						if(ech.getPiece(coordDepart).getCouleur() == joueur_actuel)
							ech.deplacerPiece(coordDepart, coordArrivee); // affichage en majuscule
					else
						tour--;
				}
				else 
					tour--;
			} else {
				ia.jouer();
			}
			// affiche le plateau
			Affiche_grille.afficher(HAUTEUR,LARGEUR, ech);
			tour++;
		
			jeu=! ech.verifieFinJeu(); // est ce que 1 des rois a ete manges
		}
	}
	
	public static boolean abandon(String coord) {// abandonner la partie 
		if(coord.length() == 1) {
			if(coord.charAt(0)=='0')
				return true;
		}
		return false;
	}
}

