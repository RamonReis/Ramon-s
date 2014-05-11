package standard;

public class TreeNode implements Comparable<TreeNode>{
	private double Xaxis;
	private double Yaxis;
	private int Height;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(){
		this.left=null;
		this.right=null;
		this.Height=0;
	}
	
	public double[] getPoint(){
		double[] point = new double[2];
		point[0]=this.Xaxis;
		point[1]=this.Yaxis;
		return point;
	}
	
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
