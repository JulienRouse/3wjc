package exercices.arbreBinaireDeRecherche;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Classe ABR
 *
 * Arbre binaire de recherche composé de Noeud.
 * Sert à stocker les mots d'un texte.
 *
 */
public class ABR {

	private Noeud racine;
	
	public ABR(){
		this.racine=null;
	}
	
	/**
	 * Crée un arbre à partir d'un fichier texte
	 * @param nomFichier Nom du fichier à partir duquel créer l'arbre binaire.
	 */
	public void construire(String nomFichier){
		Scanner sc = new Scanner(nomFichier);
		while(sc.hasNext())
			inserer(sc.next());
		sc.close();
	}
	
	/**
	 * Crée un arbre à partir d'un tableau de String.
	 * @param listeMot Tableau de String contenant les mots à inserer dans l'arbre.
	 */
	public void construire(String[] listeMot){
		for(String s : listeMot)
			inserer(s);
	}
	

	public void inserer(String mot) {
		this.racine = inserer(mot, this.racine);
	}

	/**
	 * Insertion d'un element dans l'arbre binaire.
	 * Plusieurs cas de figure:
	 * - Si l'arbre(ou sous arbre) est vide, on crée un noeud et on met le mot 
	 *   dans ce noeud, et on renvoie le noeud
	 * - Si l'arbre(ou sous arbre) n'est pas vide, on regarde si le mot que 
	 *   l'on veut insérer est plus petit, égal ou plus grand
	 *   ( selon une comparaison lexicographique). Si le mot est plus petit 
	 *   (respecitvement plus grand), on insere recursivement à gauche(respectivement
	 *    à droite) dans l'arbre. Si le mot est deja present dans le noeud,
	 *   on incremente le nombre d'occurrence.
	 *   
	 * @param mot Le mot à inserer dans l'arbre
	 * @param racine Le noeud étant la racine de l'arbre(ou sous arbre) dans lequel on insere mot
	 * @return Un noeud etant la
	 */
	private Noeud inserer(String mot, Noeud racine) {
		if(racine==null)
			return new Noeud(mot);
		else{
			int comparaisonEntreMots = mot.compareTo(racine.getMot());
			if(comparaisonEntreMots<0)
				racine.setGauche(inserer(mot,racine.getGauche()));
			if(comparaisonEntreMots>0)
				racine.setDroit(inserer(mot,racine.getDroit()));
			if(comparaisonEntreMots==0){
				racine.incrementNbOcc();
			}
		}
		return racine;
	}

	/**
	 * Renvoie true si l'arbre est vide, false sinon.
	 * @return true si l'arbre est vide, false sinon.
	 */
	public boolean estVide() {
		return this.racine==null;
	}
	// getter
	
	public Noeud getRacine(){
		return this.racine;
	}
	//differentes methodes pour traverser l'arbre:
    //   BFT 
	//   DFT with pre, post or in-order 
	/**
	 * Breadth First Traversal of the tree.
	 * Takes a lambda function as parameter to apply to every node of the tree.
	 * Example of use:
	 * 
	 * <tt>
	 * tree.BFT((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		</tt>
	 * This will print the tree in BFT order with <tt>i</tt> dash before every element, 
	 * <tt>i</tt> being the depth of the node in the tree. (The root is depth 0).
	 * @param f the lambda function to be applied to every node to the tree.
	 *        f takes an int and a Noeud as parameter.
	 */
	public void BFT(IInterface f){
		if(!estVide()){
			f.func(0, this.racine);
			BFT(0, f, this.racine);
		}
	}

	private void BFT(int depth, IInterface f, Noeud racine) {
		if(racine!=null){
			//on applique f sur les enfants
			if(racine.getGauche()!=null)
				f.func(depth+1, racine.getGauche());
			if(racine.getDroit()!=null)
				f.func(depth+1, racine.getDroit());
			
			//on appel recursivement sur les enfants
			BFT(depth+1, f, racine.getGauche());
			BFT(depth+1, f, racine.getDroit());
		}
	}

	/**
	 * Depth First Traversal of the tree with Preorder.
	 * Takes a lambda function as parameter to apply to every node of the tree.
	 * Example of use:
	 * 
	 * <tt>
	 * tree.DFTPreOrder((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		</tt>
	 * This will print the tree in DFT Preorder with <tt>i</tt> dash before every element, 
	 * <tt>i</tt> being the depth of the node in the tree. (The root is depth 0).
	 * @param f the lambda function to be applied to every node to the tree.
	 *        f takes an int and a Noeud as parameter.
	 */
	public void DFTPreOrder(IInterface f) {
		if(!estVide()){
			DFTPreOrder(0, f, this.racine);
		}
	}

	private void DFTPreOrder(int depth, IInterface f, Noeud racine) {
		if(racine!=null){
			f.func(depth, racine);
			DFTPreOrder(depth+1, f, racine.getGauche());
			DFTPreOrder(depth+1, f, racine.getDroit());	
		}
		
	}

	/**
	 * Depth First Traversal of the tree with Inorder.
	 * Takes a lambda function as parameter to apply to every node of the tree.
	 * Example of use:
	 * 
	 * <tt>
	 * tree.DFTInOrder((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		</tt>
	 * This will print the tree in DFT Inorder with <tt>i</tt> dash before every element, 
	 * <tt>i</tt> being the depth of the node in the tree. (The root is depth 0).
	 * @param f the lambda function to be applied to every node to the tree.
	 *        f takes an int and a Noeud as parameter.
	 */
	public void DFTInOrder(IInterface f) {
		if(!estVide()){
			DFTInOrder(0, f, this.racine);
		}
	}

	private void DFTInOrder(int depth, IInterface f, Noeud racine) {
		if(racine!=null){
			DFTInOrder(depth+1, f, racine.getGauche());
			f.func(depth, racine);	
			DFTInOrder(depth+1, f, racine.getDroit());	
		}
	}
	
	/**
	 * Depth First Traversal of the tree with Postorder.
	 * Takes a lambda function as parameter to apply to every node of the tree.
	 * Example of use:
	 * 
	 * <tt>
	 * tree.DFTPostOrder((i,n)->{
			for(int j=0;j<i;j++){
				sb.append("-");}
			sb.append(n);
			sb.append("\n");
			});
		</tt>
	 * This will print the tree in DFT Postorder with <tt>i</tt> dash before every element, 
	 * <tt>i</tt> being the depth of the node in the tree. (The root is depth 0).
	 * @param f the lambda function to be applied to every node to the tree.
	 *        f takes an int and a Noeud as parameter.
	 */
	public void DFTPostOrder(IInterface f) {
		if(!estVide()){
			DFTPostOrder(0, f, this.racine);
		}
	}

	private void DFTPostOrder(int depth, IInterface f, Noeud racine) {
		if(racine!=null){
			DFTPostOrder(depth+1, f, racine.getGauche());
			DFTPostOrder(depth+1, f, racine.getDroit());	
			f.func(depth, racine);	
		}
	}
	
	
	//use of traversal
	
	/**
	 * Print the tree with BFT traversal.
	 * Add N dash before node value, N being the depth of the node 
	 * @return a string representing the tree
	 */
	public String toStringBFT(){
		StringBuilder sb = new StringBuilder();
		BFT((depth, node)->{
			for(int j=0;j<depth;j++){
				sb.append("-");}
			sb.append(node);
			sb.append("\n");
		});
		return sb.toString();
	}
	
	/**
	 * Capitalize string contained in node at even depth.
	 * (use BFT here to traverse the tree but not really an important detail).
	 * 
	 * WARNING: Destructive method, may change values in the tree.
	 */
	public void capitalizeEvenDepthNodes(){
		BFT((depth,node)->{
			if(depth % 2 == 0)
				node.setMot(node.getMot().toUpperCase());
		});
	}
	
	
	//could be implemented better with stream? maybe
	/**
	 * Sum all words occurrence in the tree.
	 * 
	 * @return the sum of all the occurrences of words in the tree 
	 */
	public int sumAllWordOccurences(){
		List<Integer> listOcc = new ArrayList<Integer>();
		BFT((depth, node)->{
			listOcc.add(node.getNbOcc()); 
		});
		return listOcc.stream().reduce(0,Integer::sum);
	}
	
}
