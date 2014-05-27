package br.com.service;
import br.com.DAO.*;

public class UserService {
	public static Boolean login(String username, String password){
		return FakeUserDAO.logar(username, password);
	}
}
