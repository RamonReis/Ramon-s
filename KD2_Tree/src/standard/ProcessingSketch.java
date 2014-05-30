package standard;
import java.util.ArrayList;
import processing.core.*;


public class ProcessingSketch extends PApplet{
    /**
     * This class draws the visual representation of the KD2_Tree
     */
    private int counter;
	private static final long serialVersionUID = 1L;
        
	public void setup() {
	    size(650, 650);
	    background(0);
	  }
          
	public void draw() {
            ArrayList<TreeNode> list=null;
	    stroke(255,0,0);
            String aux = pmouseX+"-"+ pmouseY;
            if(mousePressed == true){
                //line(mouseX, mouseY, pmouseX, pmouseY); É o paint!
                
                line(330, 0, 330, 650);
                stroke(0,255,0);
                line(0, 196, 330, 196);
                stroke(0,0,255);
                line(330, 392, 650, 392);
                stroke(200, 200, 200);
                line(396, 0, 396, 392);
                stroke(30, 136, 222);
                line(594, 650, 594, 392);
            }
            
        }
        
	public static void main(String args[]) {
            PApplet.main(new String[] { "--present", "standard.ProcessingSketch"});
	}
}
