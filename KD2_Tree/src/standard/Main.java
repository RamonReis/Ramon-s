package standard;

public class Main {
	public static void main(String[] args) {
                     
                //Creating tree
		TreeNode raiz = new TreeNode();
		raiz.setXaxis(10);
		raiz.setYaxis(10);
		Tree t = new Tree(raiz);
		
                //Inserting nodes
		TreeNode node = new TreeNode();
		node.setXaxis(6);
		node.setYaxis(7);
		Utilities.Insert(raiz, node);
		
		node = new TreeNode();
		node.setXaxis(12);
		node.setYaxis(14);
		Utilities.Insert(raiz, node);
		
		node = new TreeNode();
		node.setXaxis(12);
		node.setYaxis(13);
		Utilities.Insert(raiz, node);
		
		node = new TreeNode();
		node.setXaxis(18);
		node.setYaxis(21);
		Utilities.Insert(raiz, node);
		
		node = new TreeNode();
		node.setXaxis(24);
		node.setYaxis(28);
		Utilities.Insert(raiz, node);
		
		node = new TreeNode();
		node.setXaxis(30);
		node.setYaxis(35);
		Utilities.Insert(raiz, node);
		
		node = new TreeNode();
		node.setXaxis(50);
		node.setYaxis(27);
		Utilities.Insert(raiz, node);
		
		node = new TreeNode();
		node.setXaxis(16);
		node.setYaxis(15);
		Utilities.Insert(raiz, node);
                
                
                //End of node insertion.
                try{
                    TreeNode aux = Utilities.searchNode(raiz, 1000,1000);
                    if(aux != null){
                        System.out.println("O nodo está presente na árvore na altura "+aux.getHeight());
                    }
                } catch (Exception e){
                    System.out.println("Nodo não encontrado.");
                }
		//Utilities.printTree(t);
		
	}

}