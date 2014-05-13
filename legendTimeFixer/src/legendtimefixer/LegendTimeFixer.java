/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package legendtimefixer;

import java.io.RandomAccessFile;

/**
 *
 * @author Ramon
 * Todos os direitos reservados (ou não).
 */
public class LegendTimeFixer {
    /*
     * args[0] - NOME DO ARQUIVO DE LEGENDA
     * args[1] - TEMPO DE ALTERAÇÃO NAS LEGENDAS + OU -.
     * args[2] - horas de variação.
     * args[3] - minutos de variação.
     * args[4] - segundos de variação
     * args[5] - milésimos de variação
     */
    public static void main(String[] args) {
        try{
            RandomAccessFile legendFile = new RandomAccessFile(args[0], "rw");
            while(legendFile.getFilePointer() < legendFile.length()){
                long auxFilePointer = legendFile.getFilePointer();
                Byte[] aux = Utilities.readLine(legendFile);
                byte[] aux2 = new byte[aux.length];
                for (int i = 0; i < aux.length; i++) {
                    aux2[i] = (byte)aux[i]; //Transforma cada elemento Byte de aux para byte em aux2
                }
                String aux3 = new String(aux2,"US-ASCII"); // vetor aux2 de bytes para String em aux3
                
                if(aux3.length() == 29 && aux3.charAt(15) == 62){ //condição que satisfaz uma linha de tempos da leganda.
                    legTimes legT = new legTimes(); //Cria o objeto que armazenará os tempo e fará cálculos de conserto.
                    legT.acquireTimes(aux3); //passa para o objeto legT os tempos de cada legenda.
                    if(args[1].charAt(0) == 43){//43: '+' / 45: '-'
                        legT.fixTimeForward(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]));
                        legT.printTimes();
                    }
                }
                else
                    System.out.println(aux3); //Printa linha
            }
            legendFile.close();
        }
        catch(Exception e){
            System.out.println("Execution failed.");
            e.printStackTrace();
        }
        
    }
}
