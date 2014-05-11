import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.lang.Math;

public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception 
	{
		//Os argumentos deste aplicativo são: arquivoEntrada, numeroDivisoes
		try{
			int numeroDiv = Integer.parseInt(args[1]);
			if(numeroDiv % 2 != 0){
				System.out.print("Número de divisões deve ser par"
						+ "Execução abortada.");
				System.exit(0);
			}
			int altura=1;
			RandomAccessFile f = new RandomAccessFile(args[0], "r");
			long valorArqEntrBytes = f.length();
			double numeroRegistros = (valorArqEntrBytes/(298+2)); //298 - cada registro / 2 - 1 byte em branco + 1 byte quebra de linha
			//if(numeroRegistros%2!=0) {System.out.println("O número de registros é ímpar: "+String.valueOf(numeroRegistros));}
			int numeroRegArqSaida = (int)numeroRegistros/numeroDiv;
			System.out.print("Cada arquivo gerado nesta primeira etapa terá "+String.valueOf(numeroRegArqSaida)+" registros");
			//Utilities.divideEntrada(f);
			f.close();
			int log = (int)(Math.log10(numeroDiv)/Math.log10(2));
			System.out.println(log);
			int k=0;
			for(int i=0; i<3; i++){
				while(k<numeroDiv){
					RandomAccessFile r0 = new RandomAccessFile("saidaN"+String.valueOf(i)+"ID"+String.valueOf(k)+".dat", "r");
					RandomAccessFile r1 = new RandomAccessFile("saidaN"+String.valueOf(i)+"ID"+String.valueOf(k+1)+".dat", "r");
					FileOutputStream saida = new FileOutputStream("saidaN"+String.valueOf(altura)+"ID"+String.valueOf(k)+".dat");
					Utilities.uneArquivos(r0, r1,saida);
				}
				altura++;
				numeroDiv = numeroDiv/2;
			}
			System.out.println("Fim de Execução");
			
		}catch(Exception e){
			System.out.println("ERROR!");
			System.out.println(e.getLocalizedMessage());
			System.out.print(e.getMessage());
		}
	}
		
		
}



