package exercices.eleve;

import java.util.*;

/**
 * Exercices tiré du site https://www.infres.telecom-paristech.fr/people/hudry/coursJava/exercices/groupeEleves.html
 * 
 * @author JulienRouse
 *
 */
public class GroupeEleve {

	private ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
	
	/**
	 * Empty/private constructor
	 */
	private GroupeEleve(){
	}
	
	public int nombre(){
		return listEleve.size();
	}

	public ArrayList<Eleve> getListe(){
		return listEleve;
	}
	
	public void ajouterEleve(Eleve eleve){
		this.listEleve.add(eleve);
	}
	
	public Eleve chercher(String nom){
		 for(Eleve eleve : this.listEleve)
			 if (eleve.getNom().equals(nom))
				 return eleve;
		 return null;
	}
	
	public void lister(){
		for(Eleve eleve : this.listEleve)
			System.out.println(eleve.toString());
	}
	
}
