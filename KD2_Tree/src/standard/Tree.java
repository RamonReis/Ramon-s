package standard;
/**
 * This class represents the "tree object"
 * @author ramon
 */
public class Tree {
	TreeNode raiz;
	
        /**
         * This constructor creates the tree object and sets its tree root.
         * @param n 
         */
	public Tree(TreeNode n){
		this.raiz=n;
	}
	
        /**
         * @return tree's root.
         */
	public TreeNode getRaiz() {
		return raiz;
	}
        
        /**
         * Sets the given TreeNode as the tree's root.
         * @param raiz 
         */
	public void setRaiz(TreeNode raiz) {
		this.raiz = raiz;
	}
	
}
