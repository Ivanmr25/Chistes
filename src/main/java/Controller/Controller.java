package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.Conexion;
import model.dao.DaoCategoria;
import model.dao.DaoChiste;
import model.entities.Categoria;
import model.entities.Chiste;




	/**
	 * Servlet implementation class Controller
	 */
	@WebServlet("/Controller")
	public class Controller extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Controller() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			/*
			 * Crear el singleton con
			 */
			 String marca;
			 
		
			 Connection con = (Connection)session.getAttribute("con");
			 if (con==null) {
				 con = Conexion.conecta();
				 session.setAttribute("con", con);
			 }
		
			String op = request.getParameter("op");
			RequestDispatcher dispatcher;
			if (op.equals("inicio")) {
				session.setAttribute("marca", "%");
				
				ArrayList<Chiste> bicis =  new DaoChiste().getChistes("%",con);
				ArrayList<Categoria> marcas =  new DaoCategoria().getCategorias(con);
				session.setAttribute("marcas", marcas);
				session.setAttribute("bicis", bicis);
				dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			} else if (op.equals("vamarca")) {
				marca = request.getParameter("marca");
				session.setAttribute("marca", marca);
				ArrayList<Chiste> bicis =  new DaoChiste().getChistes("%",con);
				session.setAttribute("bicis", bicis);
				dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}
			}
			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(request, response);
			}

}
