import java.io.DataInput;
import java.io.IOException;
import java.nio.charset.Charset;

public class Endereco {
	
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String sigla;
	private String cep;
	byte logradouroB[] = new byte[72];
	byte bairroB[] = new byte[72];
	byte cidadeB[] = new byte[72];
	byte estadoB[] = new byte[72];
	byte siglaB[] = new byte[2];
	byte cepB[] = new byte[8];

	public void leEndereco(DataInput din) throws IOException
	{
		byte logradouro[] = new byte[72];
		this.logradouroB = logradouro;
		byte bairro[] = new byte[72];
		this.bairroB = bairro;
		byte cidade[] = new byte[72];
		this.cidadeB = cidade;
		byte estado[] = new byte[72];
		this.estadoB = estado;
		byte sigla[] = new byte[2];
		this.siglaB = sigla;
		byte cep[] = new byte[8];
		this.cepB = cep;
		
		din.readFully(logradouro);
		din.readFully(bairro);
		din.readFully(cidade);
		din.readFully(estado);
		din.readFully(sigla);
		din.readFully(cep);
		din.readByte(); // Ultimo espaco em branco 
		din.readByte(); // Quebra de linha
		
		// Definie a forma como caracteres especias estão codificados.
		Charset enc = Charset.forName("ISO-8859-1");
		
		this.logradouro = new String(logradouro,enc);
		this.bairro = new String(bairro,enc);
		this.cidade = new String(cidade,enc);
		this.estado = new String(estado,enc);
		this.sigla = new String(sigla,enc);
		this.cep = new String(cep,enc);
	}
	
	public byte[] getLogradouroB() {
		return logradouroB;
	}

	public void setLogradouroB(byte[] logradouroB) {
		this.logradouroB = logradouroB;
	}

	public byte[] getBairroB() {
		return bairroB;
	}

	public void setBairroB(byte[] bairroB) {
		this.bairroB = bairroB;
	}

	public byte[] getCidadeB() {
		return cidadeB;
	}

	public void setCidadeB(byte[] cidadeB) {
		this.cidadeB = cidadeB;
	}

	public byte[] getEstadoB() {
		return estadoB;
	}

	public void setEstadoB(byte[] estadoB) {
		this.estadoB = estadoB;
	}

	public byte[] getSiglaB() {
		return siglaB;
	}

	public void setSiglaB(byte[] siglaB) {
		this.siglaB = siglaB;
	}

	public byte[] getCepB() {
		return cepB;
	}

	public void setCepB(byte[] cepB) {
		this.cepB = cepB;
	}

	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}
			
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void getBytes(Endereco e){
	}
}
