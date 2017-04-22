package exercices.eleve;

import static org.junit.Assert.*;

import org.junit.Test;

public class EleveTest {

	@Test
	public void testAjouterNote() {
		Eleve e = new Eleve("Julien");
		e.ajouterNote(-10);
		e.ajouterNote(40);
		e.ajouterNote(10);
		assertEquals(10., e.getMoyenne(), 0.0); //Troisième parametre est un delta pour l'imprecision des doubles
	}

}
