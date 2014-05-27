package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.entity.Carro;
import br.com.factory.ConnectionFactory;

public class CarDAO {
	public static ArrayList<Carro> getCarros() throws SQLException{ //Retorn ArrayList dos carros no banco de dados.
		Connection connect = new ConnectionFactory().getConnection();
		ArrayList<Carro> listaCarros = new ArrayList<Carro>();
		String sqlCommand = "select * from tb_carro";
		try{
			
			try{
				PreparedStatement stat = connect.prepareStatement(sqlCommand);
				ResultSet result = stat.executeQuery();
				while(result.next()){
					Carro car = new Carro(); //cria o objeto carro e faz o set dos atributos diretamente dos atributos de "result".
					car.setId(result.getInt("id"));
					car.setModelo(result.getString("modelo"));
					car.setCor(result.getString("cor"));
					car.setAno(result.getInt("ano"));
					car.setMarca(result.getString("marca"));
					car.setMotor(result.getString("motor"));
					car.setNumeroPortas(result.getInt("numeroPortas"));
					listaCarros.add(car);
				}
				stat.close();
				
			} catch (Exception e){
				System.out.println("Error CarDAO");
				e.printStackTrace();
				
			} finally{
				connect.close();
			}
			
		} catch (Exception e){
			System.out.println("Error CarDAO.getCarros");
			e.printStackTrace();
		}
		return listaCarros;
	}
	
	public static Carro getCarroId(String ID) throws SQLException{
		Connection connect = ConnectionFactory.getConnection();
		String sqlCommand = "select * from tb_carro where id=?";
		try{
			PreparedStatement stat = connect.prepareStatement(sqlCommand);
			stat.setInt(1, (int)Integer.parseInt(ID));
			ResultSet results = stat.executeQuery();
			results.next();
			//Cria um objeto carro e define os atributos
			Carro car = new Carro();
			car.setId(results.getInt("id"));
			car.setModelo(results.getString("modelo"));
			car.setCor(results.getString("cor"));
			car.setAno(results.getInt("ano"));
			car.setMarca(results.getString("marca"));
			car.setMotor(results.getString("motor"));
			car.setNumeroPortas(results.getInt("numeroPortas"));
			stat.close();
			return car;
			
		} catch (Exception e){
			System.out.println("ERROR CarDao.getCarroID");
			e.printStackTrace();
		} finally{
			connect.close();
		}
		return null;
	}

	public static void cadastraCarro(Carro carro) throws SQLException{
		Connection connect = ConnectionFactory.getConnection();
		String sqlCommand = "insert into tb_carro" + "(modelo,cor,ano,marca,motor,numeroPortas)" + "values(?,?,?,?,?,?)";
		
		try{
			PreparedStatement stat = connect.prepareStatement(sqlCommand);
			stat.setString(1, carro.getModelo().trim());
			stat.setString(2, carro.getCor().trim());
			stat.setInt(3, carro.getAno());
			stat.setString(4, carro.getMarca().trim());
			stat.setString(5, carro.getMotor().trim());
			stat.setInt(6, carro.getNumeroPortas());
			
			stat.execute();
			stat.close();
			
		} catch (Exception e){
			System.out.println("ERROR CarDAO.cadastraCarro");
			e.printStackTrace();
		} finally{
			connect.close();
		}
	}

	public static void deletaCarro(String ID) throws SQLException{
		Connection connect = ConnectionFactory.getConnection();
		String sqlCommand = "delete from tb_carro where id=?";
		
		try{
			PreparedStatement stat = connect.prepareStatement(sqlCommand);
			stat.setInt(1, Integer.parseInt(ID));
			stat.execute();
			stat.close();
			
		} catch (Exception e){
			System.out.println("ERROR CarDAO.deletaCarro");
			e.printStackTrace();
		} finally{
			connect.close();
		}
	}
}
