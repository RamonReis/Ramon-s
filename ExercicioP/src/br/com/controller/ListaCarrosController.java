package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entity.Carro;
import br.com.service.CarService;

/**
 * Servlet implementation class ListaCarrosController
 */
public class ListaCarrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCarrosController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			ArrayList<Carro> lista = CarService.getListaCarros();
			request.setAttribute("lista", lista);
			RequestDispatcher rd = request.getRequestDispatcher("listaCarros.jsp");
			rd.forward(request, response);
		} catch (Exception e){
			System.out.println("ERROR ListaCarrosController");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
