package standard;
import java.util.ArrayList;
import processing.core.*;


public class ProcessingSketch extends PApplet{
	private static final long serialVersionUID = 1L;
        private ArrayList<TreeNode> list;
        private int counter;
        private final int screenWidth = 650;
        private final int screenHeight = 650;
        
        
        public void insertNodesProcessing(ArrayList<TreeNode> list){
            this.list = list;
            this.counter = 0;
            PApplet.main(new String[] { "--present", "standard.ProcessingSketch"});
        }
        
        
        
	public void setup() {
	    size(this.screenWidth, this.screenHeight);
	    background(0);
	  }
          
	public void draw() {
	    stroke(255);
            String aux = pmouseX+"-"+ pmouseY;
            
            if(mousePressed){
                if(this.counter%3==0) stroke(255, 0, 0);
                if(this.counter%3==1) stroke(0, 255, 0);
                if(this.counter%3==2) stroke(0, 0, 255);

                if(this.counter == 0){
                    line((float)list.get(counter).getXaxis(), 0, (float)list.get(counter).getXaxis(), this.screenHeight);
                }
                else{
                    if(this.counter % 2 == 0 && this.counter != 0){
                        if(list.get(counter-1).getYaxis() > list.get(counter).getYaxis()){
                            line((float)list.get(counter).getXaxis(), this.screenHeight, (float)list.get(counter).getXaxis(), (float)list.get(counter-1).getYaxis());
                            counter++;
                        }
                        else{
                            line((float)list.get(counter).getXaxis(), 0, (float)list.get(counter).getXaxis(), (float)list.get(counter-1).getYaxis());
                            counter++;
                        }
                    }
                    else{
                        if(list.get(counter-1).getXaxis() > list.get(counter).getXaxis()){
                            line(0, (float)list.get(counter).getYaxis(), (float)list.get(counter-1).getXaxis(), (float)list.get(counter).getYaxis());
                            counter++;
                        }
                        else{
                            line(this.screenWidth, (float)list.get(counter).getYaxis(), (float)list.get(counter-1).getXaxis(), (float)list.get(counter).getYaxis());
                            counter++;
                        }
                    }
            }
	}
     }
        
        /*public void mousePressed(){
            try{
                if(counter%3==0) stroke(255, 0, 0);
                if(counter%3==1) stroke(0, 255, 0);
                if(counter%3==2) stroke(0, 0, 255);

                if(this.counter == 0){
                    line((float)list.get(counter).getXaxis(), 0, (float)list.get(counter).getXaxis(), this.screenHeight);
                }
                else{
                    if(this.counter % 2 == 0 && this.counter != 0){
                        if(list.get(counter-1).getYaxis() > list.get(counter).getYaxis()){
                            line((float)list.get(counter).getXaxis(), this.screenHeight, (float)list.get(counter).getXaxis(), (float)list.get(counter-1).getYaxis());
                            counter++;
                        }
                        else{
                            line((float)list.get(counter).getXaxis(), 0, (float)list.get(counter).getXaxis(), (float)list.get(counter-1).getYaxis());
                            counter++;
                        }
                    }
                    else{
                        if(list.get(counter-1).getXaxis() > list.get(counter).getXaxis()){
                            line(0, (float)list.get(counter).getYaxis(), (float)list.get(counter-1).getXaxis(), (float)list.get(counter).getYaxis());
                            counter++;
                        }
                        else{
                            line(this.screenWidth, (float)list.get(counter).getYaxis(), (float)list.get(counter-1).getXaxis(), (float)list.get(counter).getYaxis());
                            counter++;
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }*/
        
        public void mouseReleased(){
            save("Teste.bmp");
        }
        
	//public static void main(String args[]) {
        //    PApplet.main(new String[] { "--present", "standard.ProcessingSketch"});
	//}
}
