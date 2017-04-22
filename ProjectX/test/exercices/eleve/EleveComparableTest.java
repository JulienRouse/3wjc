package exercices.eleve;

import static org.junit.Assert.*;

import org.junit.Test;

public class EleveComparableTest {

	@Test
	public void testCompareTo() {
		Eleve e = new Eleve("John");
		e.ajouterNote(10);
		
		EleveComparable ec = new EleveComparable("Edmond");
		
		ec.ajouterNote(8);
		assertTrue(ec.compareTo(e)==-1);
		
		ec.ajouterNote(12);
		assertTrue(ec.compareTo(e)==0);
	
		ec.ajouterNote(15);
		assertTrue(ec.compareTo(e)==1);
	}

}
