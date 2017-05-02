package exercices.eleve;

import static org.junit.Assert.*;

import org.junit.Test;

public class GroupeEleveTest {

	@Test
	public void testChercherEmptyList() {
		GroupeEleve ge = new GroupeEleve();
		assertNull(ge.chercher("John"));
		
	}
	
	@Test
	public void testChercherNotEmpty() {
		Eleve e1 = new Eleve("John");
		Eleve e2 = new Eleve("Ida");
		
		GroupeEleve ge = new GroupeEleve();
		ge.ajouterEleve(e1);
		ge.ajouterEleve(e2);
		
		assertEquals(e1, ge.chercher("John"));
		assertNull(ge.chercher("Donald"));
		assertEquals(e2, ge.chercher("Ida"));
	}

}
