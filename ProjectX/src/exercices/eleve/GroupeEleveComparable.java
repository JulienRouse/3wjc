package exercices.eleve;

import java.util.ArrayList;
import java.util.Collections;


/**
 * https://www.infres.telecom-paristech.fr/people/hudry/coursJava/exercices/groupeElevesComparables.html
 * @author JulienRouse
 *
 */
public class GroupeEleveComparable extends GroupeEleve {

	private ArrayList<EleveComparable> listEleve = new ArrayList<EleveComparable>();
	
	public GroupeEleveComparable(){
		super();
		this.listEleve = new ArrayList<EleveComparable>();
	}
	
	public Eleve meilleur(){
		return Collections.max(this.listEleve);
	}
	
	/**
	 * Trie listEleve de maniere destructive
	 */
	public void trier(){
		Collections.sort(this.listEleve);
	}
	
}
