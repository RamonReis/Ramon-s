import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;


public class Utilities {
	public static void divideEntrada(RandomAccessFile arg0) throws Exception{
		ArrayList<Endereco> array = new ArrayList<Endereco>();
		FileOutputStream saida = null;
		int k=0;
		long valorArqEntrBytes = arg0.length();
		long numeroRegistros = (valorArqEntrBytes/(298+2)); //298 - cada registro / 2 - 1 byte em branco + 1 byte quebra de linha
		int numeroRegArqSaida = (int)numeroRegistros/8;
		int contadorAux = numeroRegArqSaida;
		
		//System.out.println(f.length());
		while( arg0.getFilePointer() < arg0.length() ) // para Detectar EOF
		{
			//System.out.println(f.getFilePointer());
			contadorAux = numeroRegArqSaida;
			Endereco e = new Endereco();
			e.leEndereco(arg0);
			array.add(e);
			if(array.size()==numeroRegArqSaida){
				Collections.sort(array, new ComparadorDeEnderecos());
				
				for(int i=0; i<contadorAux; i++){
					if(i==0){
						saida = new FileOutputStream("saidaN0ID"+String.valueOf(k++)+".dat");
						if(numeroRegistros%2!=0) contadorAux++;//Se o numero total de registros do arquivo inicial for ímapr, o primeiro arquivo de saída terá um registro a mais.
						
					}
					DataOutputStream dout = new DataOutputStream(saida);
					dout.write(array.get(i).getLogradouroB());
					dout.write(array.get(i).getBairroB());
					dout.write(array.get(i).getCidadeB());
					dout.write(array.get(i).getEstadoB());
					dout.write(array.get(i).getSiglaB());
					dout.write(array.get(i).getCepB());
					dout.writeBytes("\n");
					/*
					dout.writeBytes(array.get(i).getLogradouro());
					dout.writeBytes(array.get(i).getBairro());
					dout.writeBytes(array.get(i).getCidade());
					dout.writeBytes(array.get(i).getEstado());
					dout.writeBytes(array.get(i).getSigla());
					dout.writeBytes(array.get(i).getCep());
					*/
				}
				array.clear();
			}
		}
		if(array.size() != 0){
			int l =0;
			saida = new FileOutputStream("saida"+String.valueOf(k++)+".dat");
			Collections.sort(array, new ComparadorDeEnderecos());
			while(l != array.size()){
				DataOutputStream dout = new DataOutputStream(saida);
				dout.write(array.get(l).getLogradouroB());
				dout.write(array.get(l).getBairroB());
				dout.write(array.get(l).getCidadeB());
				dout.write(array.get(l).getEstadoB());
				dout.write(array.get(l).getSiglaB());
				dout.write(array.get(l).getCepB());
				dout.writeByte(0);
				dout.writeBytes("\n");
				/*
				dout.writeBytes(array.get(l).getLogradouro());
				dout.writeBytes(array.get(l).getBairro());
				dout.writeBytes(array.get(l).getCidade());
				dout.writeBytes(array.get(l).getEstado());
				dout.writeBytes(array.get(l).getSigla());
				dout.writeBytes(array.get(l).getCep());
				*/
				l++;
			}
			array.clear();
		}
		else
			System.out.println("Error!");
		arg0.close();
	}
	
	public static void uneArquivos(RandomAccessFile arg0, RandomAccessFile arg1, FileOutputStream arg3) throws Exception{
		DataOutputStream dOut = new DataOutputStream(arg3);
		Endereco end0 = new Endereco();
		Endereco end1 = new Endereco();
		end0.leEndereco(arg0);
		end1.leEndereco(arg1);
		//System.out.println(end1.getCep());
		while( arg0.getFilePointer() < arg0.length() || arg1.getFilePointer() < arg1.length()){
			
			//System.out.println(Integer.parseInt(end0.getCep()));
			if(arg1.getFilePointer() == arg1.length() && arg0.getFilePointer() != arg0.length()){
				while(arg0.getFilePointer() < arg0.length()){
					end0.leEndereco(arg0);
					dOut.write(end0.getLogradouroB());
					dOut.write(end0.getBairroB());
					dOut.write(end0.getCidadeB());
					dOut.write(end0.getEstadoB());
					dOut.write(end0.getSiglaB());
					dOut.write(end0.getCepB());
					dOut.writeByte(0);
					dOut.writeBytes("\n");
				}
				break;
			}
			else if(arg0.getFilePointer() == arg0.length() && arg1.getFilePointer() != arg1.length()){
				while(arg1.getFilePointer() < arg1.length()){
					end1.leEndereco(arg1);
					dOut.write(end1.getLogradouroB());
					dOut.write(end1.getBairroB());
					dOut.write(end1.getCidadeB());
					dOut.write(end1.getEstadoB());
					dOut.write(end1.getSiglaB());
					dOut.write(end1.getCepB());
					dOut.writeByte(0);
					dOut.writeBytes("\n");
				}
				break;
			}
			else if(end0.getCep().compareTo(end1.getCep())<=0){
				dOut.write(end0.getLogradouroB());
				dOut.write(end0.getBairroB());
				dOut.write(end0.getCidadeB());
				dOut.write(end0.getEstadoB());
				dOut.write(end0.getSiglaB());
				dOut.write(end0.getCepB());
				dOut.writeByte(0);
				dOut.writeBytes("\n");
				end0.leEndereco(arg0);
			}
			else if(end0.getCep().compareTo(end1.getCep())>0){
				dOut.write(end1.getLogradouroB());
				dOut.write(end1.getBairroB());
				dOut.write(end1.getCidadeB());
				dOut.write(end1.getEstadoB());
				dOut.write(end1.getSiglaB());
				dOut.write(end1.getCepB());
				dOut.writeByte(0);
				dOut.writeBytes("\n");
				end1.leEndereco(arg1);
			}
			else
				System.out.println("Erro!");
		}
		arg3.close();
	}
}
