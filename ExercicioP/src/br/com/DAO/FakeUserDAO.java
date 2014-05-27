package br.com.DAO;

public class FakeUserDAO {
	
	public static Boolean logar(String username, String password){
		try{ // Neste "sistema" há apenas um usuário.
			if(username.compareTo("Ramon")==0 && password.compareTo("12345")==0){
				return true;
			}
			else{
				return false;
			}
				
		} catch (Exception e){
			
		}
		return false;
	}
}
