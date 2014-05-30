package standard;
/**
 * Class containing static methods to insert and print an tree.
 * @author Ramon
 */
public class Utilities {
	
    /**
     * This method inserts a tree node in a tree. It's parameters are the tree object(raiz) and the node
     * to be inserted(node) in the tree. The node will be placed in a position of the tree according to
     * its axis values.
     * @param raiz
     * @param ToBeInserted 
     */
    
	public static void Insert(TreeNode raiz, TreeNode ToBeInserted){
		if(ToBeInserted.getHeight()%2==0){
			if(ToBeInserted.getXaxis() - raiz.getXaxis() > 0){
				if(raiz.getRight() != null){
					ToBeInserted.setHeight(ToBeInserted.getHeight()+1);
					Insert(raiz.getRight(),ToBeInserted);
				}
				else{   
                                        ToBeInserted.setHeight(raiz.getHeight()+1);
					raiz.setRight(ToBeInserted);
                                        
				}
			}
			else{
				if(raiz.getLeft() != null){
					ToBeInserted.setHeight(ToBeInserted.getHeight()+1);
					Insert(raiz.getLeft(),ToBeInserted);
				}
				else{
                                        ToBeInserted.setHeight(raiz.getHeight()+1);
					raiz.setLeft(ToBeInserted);
				}
			}
		}
		else{
			if(ToBeInserted.getYaxis() - raiz.getYaxis() > 0){
				if(raiz.getRight() != null){
					ToBeInserted.setHeight(ToBeInserted.getHeight()+1);
					Insert(raiz.getRight(),ToBeInserted);
				}
				else{
					raiz.setRight(ToBeInserted);
                                        ToBeInserted.setHeight(raiz.getHeight()+1);
				}
			}
			else{
				if(raiz.getLeft() != null){
					ToBeInserted.setHeight(ToBeInserted.getHeight()+1);
					Insert(raiz.getLeft(),ToBeInserted);
				}
				else{
					raiz.setLeft(ToBeInserted);
                                        ToBeInserted.setHeight(raiz.getHeight()+1);
				}
			}
		}
	}
	
        /**
         * This methos return a TreeNode if the node being searched is found or 'null' if it's not.
         * @param raiz
         * @param xValue
         * @param YValue
         * @return 
         */
        public static TreeNode searchNode(TreeNode raiz, int xValue, int YValue) throws Exception{
            int heigth=0;
            while(raiz != null){
                if(heigth%2==0){
                    if(raiz.getXaxis()==xValue && raiz.getYaxis()==YValue)
                        return raiz;
                    if(xValue - raiz.getXaxis() <=0){
                        heigth++;
                        raiz = raiz.getLeft();
                    }
                    else{
                        heigth++;
                        raiz=raiz.getRight();
                    }  
                }
                else{
                    if(raiz.getXaxis()==xValue && raiz.getYaxis()==YValue)
                        return raiz;
                    if(YValue - raiz.getYaxis() <=0){
                        raiz = raiz.getLeft();
                        heigth++;
                    }
                    else{
                        raiz=raiz.getRight();
                        heigth++;
                    }
                }
            }
            throw new Exception();
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
        
	/**
         * Prints the tree's node's points from the left to the right. It's parameter is the tree object T.
         * @param T 
         */
	public static void printTree(Tree T){
		printR(T.getRaiz().getLeft());
		System.out.println("X: " + T.getRaiz().getXaxis() +" " + "Y: " + T.getRaiz().getYaxis());
		printR(T.getRaiz().getRight());
	}
	
	
}
