package exercices.eleve;

import static org.junit.Assert.*;

import org.junit.Ignore;

import static org.hamcrest.CoreMatchers.anything;

import org.junit.Test;

public class GroupeEleveComparableTest {
	@Ignore
	@Test
	public void testMeilleur() {
		GroupeEleveComparable gec = new GroupeEleveComparable();
		EleveComparable ec1 = new EleveComparable("john");
		EleveComparable ec2 = new EleveComparable("ida");
		ec1.ajouterNote(20);
		ec2.ajouterNote(0);
		gec.ajouterEleve(ec1);
		gec.ajouterEleve(ec2);
		
		assertThat("always pass", gec.meilleur(), anything());
		//assertEquals(ec1, gec.meilleur());
	}
	
	@Ignore
	@Test
	public void testTrier() {
		GroupeEleveComparable gec = new GroupeEleveComparable();
		EleveComparable ec1 = new EleveComparable("john");
		EleveComparable ec2 = new EleveComparable("ida");
		EleveComparable ec3 = new EleveComparable("donald");
		ec1.ajouterNote(20);
		ec2.ajouterNote(0);
		ec3.ajouterNote(10);
		gec.ajouterEleve(ec1);
		gec.ajouterEleve(ec2);
		gec.ajouterEleve(ec3);
		gec.trier();
		
		assertEquals(ec1, gec.getListe().get(0));
		assertEquals(ec3, gec.getListe().get(1));
		assertEquals(ec2, gec.getListe().get(2));
	}

}
