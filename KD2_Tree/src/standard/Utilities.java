package standard;

public class Utilities {
	
	public static void Insert(TreeNode raiz, TreeNode node){
		if(node.getHeight()%2==0){
			if(node.getXaxis() - raiz.getXaxis() > 0){
				if(raiz.getRight() != null){
					node.setHeight(node.getHeight()+1);
					Insert(raiz.getRight(),node);
				}
				else{
					raiz.setRight(node);
				}
			}
			else{
				if(raiz.getLeft() != null){
					node.setHeight(node.getHeight()+1);
					Insert(raiz.getLeft(),node);
				}
				else{
					raiz.setLeft(node);
				}
			}
		}
		else{
			if(node.getYaxis() - raiz.getYaxis() > 0){
				if(raiz.getRight() != null){
					node.setHeight(node.getHeight()+1);
					Insert(raiz.getRight(),node);
				}
				else{
					raiz.setRight(node);
				}
			}
			else{
				if(raiz.getLeft() != null){
					node.setHeight(node.getHeight()+1);
					Insert(raiz.getLeft(),node);
				}
				else{
					raiz.setLeft(node);
				}
			}
		}
	}
	
	private static void printR(TreeNode raiz){
		if(raiz.getLeft() != null){
			printR(raiz.getLeft());
			System.out.println("X: " + raiz.getXaxis() +" " + "Y: " + raiz.getYaxis());
		}
		
		if (raiz.getRight() != null){
			printR(raiz.getRight());
			//System.out.println("X: " + raiz.getXaxis() +" " + "Y: " + raiz.getYaxis());
		}
		else
			System.out.println("X: " + raiz.getXaxis() +" " + "Y: " + raiz.getYaxis());
	}
	
	public static void printTree(Tree T){
		printR(T.getRaiz().getLeft());
		System.out.println("X: " + T.getRaiz().getXaxis() +" " + "Y: " + T.getRaiz().getYaxis());
		printR(T.getRaiz().getRight());
	}
	
	
}
