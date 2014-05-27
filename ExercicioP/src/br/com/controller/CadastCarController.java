package br.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.Carro;
import br.com.service.CarService;

/**
 * Servlet implementation class CadastCarController
 */
public class CadastCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastCarController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("modelo") != null){ //Uma tentativa de impedir cadastros nulos.
			Carro car = new Carro();
			car.setModelo(request.getParameter("modelo"));
			car.setCor(request.getParameter("cor"));
			car.setAno(Integer.parseInt(request.getParameter("ano")));
			car.setMarca(request.getParameter("marca"));
			car.setMotor(request.getParameter("motor"));
			car.setNumeroPortas(Integer.parseInt(request.getParameter("numPortas")));
			CarService.cadastraCarro(car);
			request.setAttribute("cadastrado", "yes");
		}
		else
			request.setAttribute("cadastrado", "no");
		
		RequestDispatcher rd = request.getRequestDispatcher("cadastraCarro.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
