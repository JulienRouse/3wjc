package exercices.arbreBinaireDeRecherche;

//https://www.infres.telecom-paristech.fr/people/hudry/coursJava/exercices/abr.html

/**
 * Classe Noeud.
 * 
 * <p> Noeud pour un arbre binaire de recherche contenant un mot de type String. <p>
 * 
 * <p> L'arbre composé de ces Noeud sera destiné à contenir de mots provenant de textes. <p>
 * 
 * @author JulienRouse
 */
public class Noeud {
	private String mot;
	private int nbOcc;
	private Noeud gauche, droit;
	
	/**
	 * Constructeur d'un noeud prenand un String en paramètre.
	 * Le nombre d'occurrence est mis par defaut à 1 et les Noeud gauche et droit à null.
	 * @param mot Le mot contenu par le noeud.
	 */
	public Noeud(String mot){
		this.mot=mot;
		this.nbOcc=1;
		this.gauche=null;
		this.gauche=null;
	}
	
	/**
	 * Constructeur de Noeud, prenant un String et un int.
	 * Par défaut, gauche et droit sont initialisés à null.
	 * @param mot Le mot contenu par le noeud.
	 * @param nbOcc Le nombre d'occurence du mot dans la source.
	 */
	public Noeud(String mot, int nbOcc){
		this(mot);
		this.nbOcc=nbOcc;
	}

	public String toString(){
		return "{"+this.mot+", "+this.nbOcc+"}";
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public int getNbOcc() {
		return nbOcc;
	}

	public void setNbOcc(int nbOcc) {
		this.nbOcc = nbOcc;
	}


	public Noeud getGauche() {
		return gauche;
	}


	public void setGauche(Noeud gauche) {
		this.gauche = gauche;
	}


	public Noeud getDroit() {
		return droit;
	}

	public void setDroit(Noeud droit) {
		this.droit = droit;
	}

	public void incrementNbOcc() {
		this.nbOcc++;
	}
}
