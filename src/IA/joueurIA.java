package IA;

import Echecs.Echiquier;
import Echecs.IPiece;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import Coord.Coordonnee;

public class joueurIA {
    private Echiquier ech;
    private Random rand;

    public joueurIA(Echiquier ech) {
        this.ech = ech;
        this.rand = new Random();
    }

    //si une coordonnee est fausse on change direct de piece
    public void jouer() {
        Coordonnee coordDepart = getPieceRandom(1);
        Coordonnee coordArrive;
        String coordLongue;
        coordArrive = new Coordonnee(getRandomCoord());
        coordLongue = coordDepart.toString() + " " +coordArrive.toString();
        if (Coordonnee.coordPossible(coordLongue)) {
            if (ech.getPiece(coordDepart) != null) {
                if (ech.getPiece(coordDepart).getCouleur() == 1) {
                    if (ech.verifieChemin(coordDepart, coordArrive)) {
                    	System.out.println("Jeu IA réussi");
                    	ech.deplacerPiece(coordDepart, coordArrive);
                    } else {
                    	jouer();
                    }
                } else {
                    jouer();
                }
            } else {
                jouer();
            }
        } else {
            jouer();
        }
    }
    
    public String getRandomCoord() { // on recupere les coord aleatoires qui existent deja qu'on ajoute au string builder
        StringBuilder coord = new StringBuilder();
        coord.append((char)(rand.nextInt(8) + 'A'));
        coord.append((rand.nextInt(8) + 1));
        return coord.toString();
    }
    
    public Coordonnee getPieceRandom(int joueur) { // on souhaite verifier et recupere les coord des pieces de la map (rois, dames....) du joueur IA qu'on met dans une liste
    	ArrayList<Coordonnee> coordJoueur = new ArrayList<>();
        for (Map.Entry<Coordonnee, IPiece> entry : ech.getPieces().entrySet()) { 
            if (entry.getValue().getCouleur() == joueur) {
                coordJoueur.add(entry.getKey());
            }
        }
        if (coordJoueur.isEmpty()) { 
            return null;
        }
        int indexAle = rand.nextInt(coordJoueur.size());
        return coordJoueur.get(indexAle);
    }

}
