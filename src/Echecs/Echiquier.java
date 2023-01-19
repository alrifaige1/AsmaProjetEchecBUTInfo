package Echecs;

import java.util.HashMap;

import Coord.Coordonnee;
import Pieces.Dame;
import Pieces.Roi;

/**
 * Classe representant un echiquier.
 */

public class Echiquier {
	// La HashMap qui stockera les pieces de l'échiquier
	private HashMap<Coordonnee, IPiece> pieces; // mes pieces ont une coordonnee qui est la cle de la piece
	private int nbPieces = 0;
	/**
	* Constructeur par defaut de la classe Echiquier.
	* Initialise la HashMap des pieces.
	*/
	public Echiquier() {
		this.pieces = new HashMap<>();
	}
  
	public void init_Echiquier() {	
	//		//Place tous les pions basiques
	//		for(int i=0; i!=largeur; i++) {
	//			//Deuxieme ligne du bas
	//			placer_Piece(chars.get(i), 2, new Piece(0)); // pions 
	//			//Deuxieme ligne du haut
	//			placer_Piece(chars.get(i), largeur -1, new Piece(1));
	//		}
			
		ajouterPiece(new Coordonnee("E1"), new Roi(0)); // rois
	    ajouterPiece(new Coordonnee("E8"), new Roi(1));
	
		ajouterPiece(new Coordonnee("D1"), new Dame(0)); // dames
		ajouterPiece(new Coordonnee("D8"), new Dame(1));
//		
//		placer_Piece('b', 1, new Cavalier(0)); // cavaliers
//		placer_Piece('b', 8, new Cavalier(1));
//		
//		placer_Piece('g', 1, new Cavalier(0)); // cavaliers
//		placer_Piece('g', 8, new Cavalier(1));
//		
//		placer_Piece('c', 1, new Fou(0)); // fous
//		placer_Piece('c', 8, new Fou(1));
//		
//		placer_Piece('f', 1, new Fou(0)); // fous
//		placer_Piece('f', 8, new Fou(1));
//		
//		placer_Piece('a', 1, new Tour(0)); // tour
//		placer_Piece('a', 8, new Tour(1));
//		
//		placer_Piece('h', 1, new Tour(0)); // tour
//		placer_Piece('h', 8, new Tour(1));
	}

	/**
	* Ajoute une piece a l'echiquier.
    * @param coord  Les coordonnees ou ajouter la piece.
    * @param symbole La piece a ajouter.
    */
	public void ajouterPiece(Coordonnee coord, IPiece symbole) {
		if (this.estVide(coord)) {
			this.pieces.put(coord, symbole);
			++nbPieces;
		}
		else 
				System.out.println("Impossible d'ajouter une piece a cette coordonnee : une piece est deja presente.");
	}

	/**
	* Retire une piece de l'echiquier.
    * @param coord  Les coordonnees de la piece a retirer.
    */
	public void retirerPiece(Coordonnee coord) {
		if (!this.estVide(coord)) {
			this.pieces.remove(coord);
			--nbPieces;
		}
		else 
      System.out.println("Impossible de retirer une piece de cette coordonnee : aucune piece n'est presente.");
	}

	/**
	* Déplace une piece sur l'echiquier.
	* @param coordDepart  Les coordonnees de la piece a deplacer.
	* @param coordArrivee  Les coordonnées où déplacer la pièce.
	*/
	public void deplacerPiece(Coordonnee coordDepart, Coordonnee coordArrivee) {
		if (!this.estVide(coordDepart)) {
			if (this.pieces.get(coordDepart).deplacementPossible(coordDepart, coordArrivee)) { //si on respecte le type de deplacement de la piece
				if(!this.estVide(coordArrivee)) {
					this.retirerPiece(coordArrivee);
					System.out.println("Attaque: la piece est mange ! ");
				}
				IPiece symbole = this.pieces.get(coordDepart); // on recupere la coord de depart qu'on stocke dans symbole 
				this.retirerPiece(coordDepart); // puis qu'on retire
				this.ajouterPiece(coordArrivee, symbole);
			} 
			else
				System.out.println("La piece ne peut pas faire ce deplacement ! ");
	    }
		else 
			System.out.println("Impossible de deplacer la piece : aucune piece n'est presente a la coordonnee de depart.");
	}
	
	public boolean verifieChemin(Coordonnee coordDepart, Coordonnee coordArrivee) {
		if (!this.estVide(coordDepart)) {
			if (this.pieces.get(coordDepart).deplacementPossible(coordDepart, coordArrivee)) { //si on respecte le type de deplacement de la piece
				return true;
			} 
	    }
		return false;
	}

	/**
	  Vérifie si une case de l'échiquier est vide.
	  @param coord Les coordonnées de la case à vérifier.
	  @return true si la case est vide, false sinon.
	*/
	public boolean estVide(Coordonnee coord) {
		return !this.pieces.containsKey(coord);
	}
	
	/**
	  Recupere et retourne la piece sur une case de l'échiquier.
	  @param coord Les coordonnées de la case à vérifier.
	  @return la piece sur la case.
	*/
	
	public IPiece getPiece(Coordonnee coord) {
		return this.pieces.get(coord);
	}
	
	public HashMap<Coordonnee, IPiece> getPieces() { // on retourne la map de toutes mes pieces (de la grille) 
		return this.pieces;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public int verifieVictoire() {
		// On verifie si les roi des joueurs 0 et 1 sont present sur l'echiquier  
		boolean roi0Present = false;
		boolean roi1Present = false;
		
		// On parcourt toutes les pieces de l'echiquier  
		for(IPiece piece : pieces.values()) {	// Si la piece est un roi de couleur 0, cela signifie que le roi du joueur 0 est present sur l'echiquier    
			if (piece instanceof Roi && piece.getCouleur() == 0)
				roi0Present = true;
				// Si la piece est un roi de couleur 1, cela signifie que le roi du joueur 1 est present sur l'echiquier    
		    if (piece instanceof Roi && piece.getCouleur() == 1)
		      roi1Present = true;
		}
		 // Si aucun des deux rois n'est présent sur l'échiquier, cela signifie que l'un des joueurs a gagné
		 if (!roi0Present && !roi1Present)
		     return -1;
		    // Si le roi du joueur 0 n'est pas présent sur l'échiquier, cela signifie que le joueur 1 a gagné
		 if (!roi0Present) 
		     return 1;
		    // Si le roi du joueur 1 n'est pas présent sur l'échiquier, cela signifie que le joueur 0 a gagné
		 if (!roi1Present) 
		    return 0;
		 // Si les deux rois sont présents sur l'échiquier, cela signifie que personne n'a gagné
		 return -1;  
	}
	
	public boolean verifieFinJeu() {
		switch(verifieVictoire()) {
		case -1:
			return false;
		case 0:
			System.out.println("Joueur Blanc a gagne");
			return true;
		case 1:
			System.out.println("Joueur Noir a gagne");
			return true;
		default:
			return false;
		}
	}
}