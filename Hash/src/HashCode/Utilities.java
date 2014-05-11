/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HashCode;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author ramon
 */
public class Utilities {
    public static RandomAccessFile createHashTable(String hashFileName){
        try{
            File f = new File(hashFileName);
            if(f.exists()){
                f.delete();
            }
            
            RandomAccessFile hashFile = new RandomAccessFile(hashFileName, "rw");
            for (int i = 0; i < 910003; i++) {
                    hashFile.writeInt(0); // Valor padrão de CER vazio
                    hashFile.writeInt(-1); // Valor padrão de posição, no arquivo original, vazio
                    hashFile.writeInt(-1); // Valor padrão para "ponteiro" vazio
            }
            return hashFile;
        } catch(Exception e){
            System.out.println("Hash filen not created.");
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean geraHash(RandomAccessFile originalFile, RandomAccessFile hashTable){
        try{
            hashTable.seek(0);
            long HashTableSize = hashTable.length(); //Guarda o tamanho da tabela de Hash sem contar a lista auxiliar

            byte[] array = new byte[8];
            System.out.println("Iniciando leitura do arquivo de CEPs.");
            int counter = 1;
            while(originalFile.getFilePointer() < originalFile.length()){
                originalFile.skipBytes(72*4);
                originalFile.skipBytes(2);
                originalFile.readFully(array);
                originalFile.skipBytes(2);
                
                int CEPNumber = Integer.parseInt(new String(array));
                Integer HashCode = CEPNumber % 910003;
                hashTable.seek(12*HashCode); //Direciona o FilePointer até a posição do novo registro na Hashtable
                long FilePointerHT = hashTable.getFilePointer();
                
                if(hashTable.readInt()== 0)
                {
                    hashTable.seek(FilePointerHT);
                    hashTable.writeInt(CEPNumber);
                    hashTable.writeInt(counter);
                    hashTable.write(-1);
                    //HashTable.skipBytes(4);
                }
                else
                {
                    hashTable.skipBytes(4);
                    long aux = hashTable.getFilePointer();
                    if(hashTable.readInt() == -1) {
                        long positionOfNewData = hashTable.length();
                        hashTable.seek(positionOfNewData);
                        hashTable.writeInt(CEPNumber);
                        hashTable.writeInt(counter);
                        hashTable.writeInt(-1);
                        hashTable.seek(aux);
                        hashTable.writeInt((int)positionOfNewData/12);
                    }
                    else {
                        hashTable.seek(aux);
                        int positionOfExistingdata = hashTable.readInt();
                        long positionOfNewData = hashTable.length(); 
                        hashTable.seek(positionOfNewData);
                        hashTable.writeInt(CEPNumber);
                        hashTable.writeInt(counter);
                        hashTable.writeInt(positionOfExistingdata);
                        hashTable.seek(aux);
                        hashTable.writeInt((int)positionOfNewData/12);
                    }
                }
                counter++;
            }
            return true;
        } catch(Exception e){
            System.out.println("Hash code Não foi gerado.");
            e.printStackTrace();;
            return false;
        }
        
    }
    
    public static int findCEP(RandomAccessFile HashTable, String CEP){
        try{
            int CEPNumber = Integer.parseInt(CEP);
            Integer HashCode = CEPNumber % 910003;
            HashTable.seek(HashCode*12);
            
            if(HashTable.readInt() == CEPNumber){
                return HashTable.readInt();
            }
            else{
                int positionInOriginalFile = HashTable.readInt();
                int verifier = HashTable.readInt(); //verifier armazena o "ponteiro" de cada registro.
                System.out.println(CEP);
                System.out.println(positionInOriginalFile);
                System.out.println(verifier);
                while(verifier != -1){
                    HashTable.seek(verifier*12);
                    int aux = HashTable.readInt();
                    int counter = HashTable.readInt();
                    verifier = HashTable.readInt();
                    if(aux == CEPNumber){
                        return counter; // Valor com a posição do registro de CEP no arquivo original
                    }
                }
                System.out.println("CEP não encontrado!");
                return 0;
            }
            
        }catch(Exception e){
            System.err.println("ERROR!");
            e.printStackTrace();
            System.out.println(e.getCause());
            return 0;
        }
    }
}
