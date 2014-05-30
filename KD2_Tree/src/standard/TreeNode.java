package standard;

/**
 * An object of this class is an element of the tree.
 * It's attributes are:
 * private double Xaxis;
 * private double Yaxis;
 * private int Height;
 * private TreeNode left (node's left branch);
 * private TreeNode right(node's right branch);
 * @author ramon
 */
public class TreeNode implements Comparable<TreeNode>{
	private double Xaxis;
	private double Yaxis;
	private int Height;
	private TreeNode left;
	private TreeNode right;
	
        /**
         * Constructor initializes all attributes of the object;
         */
	public TreeNode(){
            this.Xaxis = 0;
            this.Yaxis = 0;
            this.left=null;
            this.right=null;
            this.Height=0;
	}
	
        /**
         * Returns the point of the tree node in a double vector of length 2.
         * @return double[0]-Xaxis; double[1]-Yaxis.
         */
	public double[] getPoint(){
		double[] point = new double[2];
		point[0]=this.Xaxis;
		point[1]=this.Yaxis;
		return point;
	}
	
        /**
         * Sets the node's point.
         * @param x
         * @param y
         */
	public void setPoint(double x, double y){
		this.Xaxis = x;
		this.Yaxis = y;
	}
	
	public TreeNode getLeft() {
		return left;
	}
        
	public void setLeft(TreeNode left) {
		this.left = left;
	}
        
        /**
         * 
         * @return the height of the node.
         */
	public int getHeight() {
		return Height;
	}

	public void setHeight(int value) {
		this.Height = value;
	}

	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}

	public double getXaxis() {
		return Xaxis;
	}

	public void setXaxis(double xaxis) {
		Xaxis = xaxis;
	}

	public double getYaxis() {
		return Yaxis;
	}

	public void setYaxis(double yaxis) {
		Yaxis = yaxis;
	}
	
	@Override
	public int compareTo(TreeNode node) {
		if(this.getHeight()%2==0){
			return (int)(this.getXaxis() - node.getXaxis());
		}
		else{
			return (int) (this.getYaxis() - node.getYaxis());
		}
	}


	
	
}
