import java.util.Comparator;


public class ComparadorDeEnderecos implements Comparator<Endereco> {
	@Override
	public int compare(Endereco arg0, Endereco arg1) {
		if(Integer.parseInt(arg0.getCep()) < Integer.parseInt(arg1.getCep()))
			return -1;
		else if(Integer.parseInt(arg0.getCep()) > Integer.parseInt(arg1.getCep()))
			return 1;
		return 0;
	}

}
