/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pretobranco;

import java.io.RandomAccessFile;

/**
 *
 * @author ramon
 * Todos os direitos não reservados.
 */
public class PretoBranco {

    /**
     * @param args the command line arguments
     */
    
    public static int[] lePixel(RandomAccessFile file) throws Exception
	{
                //Cada cor tem 1B (RGB e Alpha)
		int b1 = file.read(); 
		int b2 = file.read();
		int b3 = file.read();
		int b4 = file.read();
                int[] aux = new int[4];
                aux[0] = b1;
                aux[1] = b2;
                aux[2] = b3;
                aux[3] = b4;
                return aux;
	}
    
    public static void BMPPretoBrano(RandomAccessFile entrada, RandomAccessFile saida)throws Exception{
        byte[] header = new byte[54];
        entrada.readFully(header);
        saida.write(header); //COpia exatamente o mesmo header do arquivo origem para o arquivo de sa[ida.
        
        while(entrada.getFilePointer() < entrada.length()){
            //System.out.println(entrada.getFilePointer() +"---"+ entrada.length());
            int[] aux = lePixel(entrada);
            char averageValue = (char) ((char)(aux[0]+aux[1]+aux[2])/3);
            //Calcula a média entre RGB.
            saida.write(averageValue);
            saida.write(averageValue);
            saida.write(averageValue);
            saida.write(averageValue);
        }
    }
    public static void main(String[] args) {
        try{
            System.out.println("Iniciando execução.");
            RandomAccessFile entrada = new RandomAccessFile(args[0], "rw");
            RandomAccessFile saida = new RandomAccessFile(args[1], "rw");
            
            /*Método que faz um loop para ler 32B de cada vez, calcular média entre as 3 cores 
            e escrever no arquivo de saída.*/
            BMPPretoBrano(entrada, saida);
            
            entrada.close();
            saida.close();
            
            System.out.println("Fim de Execução.");
            
        }catch(Exception e){//Captura qualquer exceção.
            System.out.println("ERROR!");
            e.printStackTrace();
        }
    }
    
}
