package standard;

import java.util.ArrayList;
import processing.core.PApplet;

public class Main {
	public static void main(String[] args) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
                        
		TreeNode raiz = new TreeNode();
		raiz.setXaxis(10);
		raiz.setYaxis(10);
		Tree t = new Tree(raiz);
                list.add(raiz);
		
		TreeNode node = new TreeNode();
		node.setXaxis(6);
		node.setYaxis(7);
		Utilities.Insert(raiz, node);
                list.add(node);
		
		node = new TreeNode();
		node.setXaxis(12);
		node.setYaxis(14);
		Utilities.Insert(raiz, node);
                list.add(node);
		
		node = new TreeNode();
		node.setXaxis(12);
		node.setYaxis(13);
		Utilities.Insert(raiz, node);
                list.add(node);
		
		node = new TreeNode();
		node.setXaxis(18);
		node.setYaxis(21);
		Utilities.Insert(raiz, node);
                list.add(node);
		
		node = new TreeNode();
		node.setXaxis(24);
		node.setYaxis(28);
		Utilities.Insert(raiz, node);
                list.add(node);
		
		node = new TreeNode();
		node.setXaxis(30);
		node.setYaxis(35);
		Utilities.Insert(raiz, node);
                list.add(node);
		
		node = new TreeNode();
		node.setXaxis(50);
		node.setYaxis(27);
		Utilities.Insert(raiz, node);
                list.add(node);
		
		node = new TreeNode();
		node.setXaxis(16);
		node.setYaxis(15);
		Utilities.Insert(raiz, node);
                list.add(node);
                
                PApplet pa = new PApplet();
                
                pa.size(650, 650);
                
		ProcessingSketch proc = new ProcessingSketch();
                proc.insertNodesProcessing(list);
                
		//Utilities.printTree(t);
		
	}

}