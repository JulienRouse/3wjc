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
	public GroupeEleve(){
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
	
	/**
	 * Cherche et return l'eleve si il est dans la liste, null sinon.
	 * 
	 * @param nom Le nom de l'eleve à chercher
	 * @return un Eleve si le nom est dans la liste ou null sinon.
	 */
	public Eleve chercher(String nom){
		 for(Eleve eleve : this.listEleve)
			 if (eleve.getNom().equals(nom))
				 return eleve;
		 return null;
	}
	
	/**
	 * 
	 */
	public void lister(){
		for(Eleve eleve : this.listEleve)
			System.out.println(eleve.toString());
	}
	
}
