package exercices.eleve;

public class EleveComparable extends Eleve implements Comparable<Eleve> {

	public EleveComparable(String nom) {
		super(nom);
	}

	//on compare les élèves par rapport à leurs moyennes ici.
	//on aurait pu choisir l'ordre alphabétique ou un mix des deux également.
	@Override
	public int compareTo(Eleve e) {
		if(this.getMoyenne()<e.getMoyenne())
			return -1;
		else if (this.getMoyenne()>e.getMoyenne())
			return 1;
		else
			return 0;
	}
}
