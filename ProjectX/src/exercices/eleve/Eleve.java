package exercices.eleve;

import java.util.*;

/**
 * 
 * Classe Eleve
 * 
 * Source exercice: https://www.infres.telecom-paristech.fr/people/hudry/coursJava/exercices/eleve.html
 * 
 * @author JulienRouse
 */
public class Eleve {
	private String nom;
	private List<Integer> listNotes;
	private double moyenne;
	
	/**
	 * Constructeur d'un eleve avec seulement son nom
	 * 
	 * @param nom le nom de l'eleve.
	 */
	public Eleve(String nom){
		this.nom = nom;
		this.listNotes = new ArrayList<Integer>();
		this.moyenne = 0;
	}

	public String getNom() {
		return nom;
	}

	public List<Integer> getListNotes() {
		return listNotes;
	}

	public double getMoyenne() {
		return moyenne;
	}
	
	/*
	 * Calcul de la moyenne en utilisant stream()
	 * Meilleur moyen => ne pas utiliser stream mais juste un calcul de moyenne direct.
	 * 
	 */
	private double calc_moyenne(){
		OptionalDouble od =  this.listNotes
				.stream()
				.mapToDouble(a -> a)
				.average();
		if (od.isPresent())
			return od.getAsDouble();
		else
			return 0.;
	}
	
	/**
	 * Ajoute une note à l'élève et met à jour la moyenne.
	 * Si note>20 alors note=20 et si note<0 alors note=0. 
	 * 
	 * @param note la note à ajouter à l'élève
	 */
	public void ajouterNote(int note){
		int noteApresVerification;
		if (note<0)
			noteApresVerification = 0;
		else if (note>20)
			noteApresVerification = 20;
		else
			noteApresVerification = note;
		
		this.listNotes.add(noteApresVerification);
		this.moyenne = calc_moyenne();
	}
	
	@Override
	public String toString(){
		return this.getNom() + "(" + this.getMoyenne() + ")";
	}
	
}
