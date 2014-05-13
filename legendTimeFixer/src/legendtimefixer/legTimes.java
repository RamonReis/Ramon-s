/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package legendtimefixer;

/**
 *
 * @author Ramon
 */
public class legTimes {
    private int hourI;
    private int minutesI;
    private int secondsI;
    private int milisecI;
    
    private int hourF;
    private int minutesF;
    private int secondsF;
    private int milisecF;
    
    public void acquireTimes(String s){
        try{
            this.hourI = Integer.parseInt(s.substring(0,2));
            this.minutesI = Integer.parseInt(s.substring(3,5));
            this.secondsI = Integer.parseInt(s.substring(6,8));
            this.milisecI = Integer.parseInt(s.substring(9,12));
            
            this.hourF = Integer.parseInt(s.substring(17,19));
            this.minutesF = Integer.parseInt(s.substring(20,22));
            this.secondsF = Integer.parseInt(s.substring(23,25));
            this.milisecF = Integer.parseInt(s.substring(26,29));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void printTimes(){
        System.out.println(this.hourI+":"+this.minutesI+":"+this.secondsI+","+this.milisecI+" --> "+this.hourF+":"+this.minutesF+":"+this.secondsF+","+this.milisecF);
    }
    
    public void fixTimeBackwards(int hours, int minutes, int seconds, int milisseconds){
        this.hourI = this.hourI-hours;
        this.hourF = this.hourF - hours;
        
        this.minutesI = this.minutesI-minutes;
        if(this.minutesI <0){
            this.hourI = this.hourI-1;
            this.minutesI = 60 + this.minutesI;
        }
        this.minutesF = this.minutesF - minutes;
            if(this.minutesF <0){
            this.hourF = this.hourF-1;
            this.minutesF = 60 + this.minutesF;
        }
        this.secondsI = this.secondsI-seconds;
        if(this.secondsI < 0){
            this.milisecI = this.minutesI-1;
            this.secondsI = 60 +this.secondsI;
        }
        this.secondsF = this.secondsF - seconds;
        if(this.secondsF < 0){
            this.milisecF = this.minutesF-1;
            this.secondsF = 60 +this.secondsF;
        }
        this.milisecI = this.milisecI-milisseconds;
        if(this.milisecI <0){
            this.secondsI = this.secondsI-1;
            this.milisecI = this.milisecI + 1000;
        }
        this.milisecF = this.milisecF - milisseconds;
        if(this.milisecF <0){
            this.secondsF = this.secondsF-1;
            this.milisecF = this.milisecF + 1000;
        }
    }
    
    public void fixTimeForward(int hours, int minutes, int seconds, int milisseconds){
        this.hourI = this.hourI+hours;
        this.hourF = this.hourF + hours;
        this.minutesI = this.minutesI+minutes;
        if(this.minutesI >60) {
            this.minutesI = this.minutesI%60;
            this.hourI= this.hourI+1;
        }
        this.minutesF = this.minutesF + minutes;
        if(this.minutesF >60) {
            this.minutesF = this.minutesF%60;
            this.hourF= this.hourF+1;
        }
        this.secondsI = this.secondsI+seconds;
        if(this.secondsI > 60){
            this.secondsI = this.secondsI%60;
            this.minutesI = this.minutesI+1;
        }
        this.secondsF = this.secondsF + seconds;
        if(this.secondsF > 60){
            this.secondsF = this.secondsF%60;
            this.minutesF = this.minutesF+1;
        }
        this.milisecI = this.milisecI+milisseconds;
        if(this.milisecI > 1000){
            this.milisecI = this.milisecI % 1000;
            this.secondsI = this.secondsI+1;
        }
        this.milisecF = this.milisecF + milisseconds;
        if(this.milisecF > 1000){
            this.milisecF = this.milisecF % 1000;
            this.secondsF = this.secondsF+1;
        }
    }
       
    
}
