package br.com.service;

import java.util.ArrayList;

import br.com.DAO.CarDAO;
import br.com.entity.Carro;

public class CarService {
	
	public static ArrayList<Carro> getListaCarros(){
		try{
			return CarDAO.getCarros();
		} catch (Exception e){
			System.out.println("Error CarService.getListaCarros");
			e.printStackTrace();
		}
		return null;
	}
	
	public static Carro getCarroID(String ID){
		try{
			return CarDAO.getCarroId(ID);
		} catch (Exception e){
			System.out.println("ERROR CarService.getCarroID");
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean cadastraCarro(Carro carro){
		try{
			CarDAO.cadastraCarro(carro);
			return true;
		} catch (Exception e){
			System.out.println("ERROR cadastraCarro");
			e.printStackTrace();
		}
		return false;
	}

	public static Boolean deletaCarro(String ID){
		try{
			CarDAO.deletaCarro(ID);
		} catch (Exception e){
			System.out.println("ERROR CarDAO.deletaCarro");
			e.printStackTrace();
		}
		return false;
	}
}
