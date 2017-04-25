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
	
	//construire
	@Test
	public void testConstruireArrayString() {
		String[] tabMots = { "dd", "bb", "aa", "zz", "dd", "bb", "zzz"};
		tree.construire(tabMots);
		StringBuilder sb = new StringBuilder();
		tree.BFT((i,n)->{
			sb.append(n);
		});
		assertThat(sb.toString(), is("{dd,2}{bb,2}{zz,1}{aa,1}{zzz,1}"));
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
	
	//BFT
	@Test
	public void testBFT(){
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
	
	//DFT pre-order
	@Test
	public void testDFTPreorder(){
		String[] tableauMots = {"c", "b", "d","a", "bb"};
		tree.construire(tableauMots);
		StringBuilder sb= new StringBuilder();
		tree.DFTPreorder((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		assertThat(sb.toString(), is("{c,1}\n-{b,1}\n--{a,1}\n--{bb,1}\n-{d,1}\n"));
	}
	
	//DFT in-order
	@Test
	public void testWithDFTInOrder(){
		String[] tableauMots = {"c", "b", "d","a", "bb"};
		tree.construire(tableauMots);
		StringBuilder sb= new StringBuilder();
		tree.DFTInOrder((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		assertThat(sb.toString(), is("--{a,1}\n-{b,1}\n--{bb,1}\n{c,1}\n-{d,1}\n"));
	}
	
	//DFT post-order
	@Test
	public void testWithDFTPostOrder(){
		String[] tableauMots = {"c", "b", "d","a", "bb"};
		tree.construire(tableauMots);
		StringBuilder sb= new StringBuilder();
		tree.DFTPostOrder((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		assertThat(sb.toString(), is("--{a,1}\n--{bb,1}\n-{b,1}\n-{d,1}\n{c,1}\n"));
	}
}
