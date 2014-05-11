/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HashCode;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author aluno
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    try{
        String arquivoDoCep = "cep.dat"; //Coloque nesta varável o nome do arquivo de cep com a extensão.
        String arquivoParaOHash = "hashTable.dat"; //Coloque nesta varável o nome do arquivo de hash que você desejar.
           
        System.out.println("Iniciando execução...");
        RandomAccessFile CepFile = new RandomAccessFile(arquivoDoCep,"rw");
        RandomAccessFile hashTableFile = new RandomAccessFile(arquivoParaOHash,"rw");
            
        RandomAccessFile hashTable = Utilities.createHashTable(arquivoParaOHash); //Comente esta linha para não gerar um arquivo de hash vazio
        /*
        A linha acima cria o arquivo de hash e o preenche com os valores padrões, caso um 
        arquivo com o mesmo nome já exista ele será deletado
        */
         
        /*No bloco abaixo, o método "geraHash" cria o hash code dos registro no arquivo de cep e 
        gera a hashtable. Comente caso não queira gerar novamente.
        */
        if (Utilities.geraHash(CepFile, hashTableFile) == true)
            System.out.println("Arquivo HashTable criado.");
           
        System.out.println("Posição do CEP 21221490 no arquivo original é: "+Utilities.findCEP(hashTable, "21221490"));
        System.out.println("End of Execution.");
        
    }catch(Exception e){
        System.out.println("ERROR!");
        System.out.println("Você está experenciando problemas jovem Padawan =/ .");
        e.printStackTrace();
        System.out.println(e.getCause());
     }

    }
}
