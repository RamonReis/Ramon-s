package br.com.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.factory.ConnectionFactory;
import br.com.service.CarService;

/**
 * Servlet implementation class DeletaCarro
 */
public class DeletaCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletaCarro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			CarService.deletaCarro(request.getParameter("idCarroDeletar"));
			request.setAttribute("deletado", "yes");
		} catch (Exception e){
			request.setAttribute("deletado", "yes");
			System.out.println("ERROR DeletaCarroController");
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("deletaCarro.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
