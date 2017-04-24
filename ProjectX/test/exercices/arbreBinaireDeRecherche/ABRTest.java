package exercices.arbreBinaireDeRecherche;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
import org.junit.Test;

public class ABRTest {

	ABR tree ;
	
	@Before
	public void setup(){
		tree = new ABR();
	}
	
	@Ignore
	@Test
	public void testConstruire() {
		
	}

	//inserer
	@Test
	public void testInsererIntoEMptyTree() {
		tree.inserer("john");
		assertThat(tree.getRacine(),notNullValue());
		assertThat(tree.getRacine().getMot(), is("john"));
	}
	
	@Test
	public void testInsererTwoElements() {
		tree.inserer("a");
		tree.inserer("b");
		assertThat(tree.getRacine(), notNullValue());
		assertThat(tree.getRacine().getDroit().getMot(), is("b"));
		
	}

	@Test
	public void testBFTWithFourElements(){
		String[] tableauMots = {"c", "b", "d","a"};
		tree.construire(tableauMots);
		StringBuilder sb= new StringBuilder();
		tree.BFT((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		assertThat(sb.toString(), is("{c,1}\n-{b,1}\n-{d,1}\n--{a,1}\n"));
	}
	
}
