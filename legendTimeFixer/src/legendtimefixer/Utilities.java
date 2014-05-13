/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package legendtimefixer;

import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Ramon
 */
public class Utilities {
    public static Byte[] readLine(RandomAccessFile file){
        try{
            byte aux = file.readByte();
            ArrayList<Byte> arrayl = new ArrayList<Byte>();
            
            while(aux != 13){
                arrayl.add(aux);
                aux = file.readByte();
            }
            file.readByte();//Lê o byte de começo de linha da próxima linha.
            Byte[] array = new Byte[arrayl.size()];
            return arrayl.toArray(array);
            
        }
        catch(Exception e){
            System.out.println("ERROR readLine");
            e.printStackTrace();
            return null;
        }
    }
}
