package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarroDAO;
import model.Carro;
import model.TipoCombustivel;

/**
 * Servlet implementation class ServletCarro
 */
@WebServlet("/ServletCarro")
public class ServletCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCarro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String action = request.getParameter("action");
		int id;
		Carro carro;
		CarroDAO dao = new CarroDAO();
		
		switch (action) {
		case "edit":
			id = Integer.parseInt(request.getParameter("id"));
			carro = dao.readId(id);
			request.setAttribute("carro", carro);
			request.getRequestDispatcher("formcarro.jsp");
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			response.sendRedirect("index.jsp");
			break;
		default:
			
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Carro carro = new Carro();
		CarroDAO dao = new CarroDAO();
		
		if(request.getParameter("id").isEmpty()){
			
			carro.setModelo(request.getParameter("modelo"));
			carro.setMarca(request.getParameter("marca"));
			carro.setTipoCombustivel(TipoCombustivel.valueOf(request.getParameter("tipocombustivel")));
			carro.setValor(Double.parseDouble(request.getParameter("valor")));

			dao.create(carro);
		} else {
			
			int id = Integer.parseInt(request.getParameter("id"));
			carro = dao.readId(id);
			carro.setModelo(request.getParameter("modelo"));
			carro.setMarca(request.getParameter("marca"));
			carro.setTipoCombustivel(TipoCombustivel.valueOf(request.getParameter("tipocombustivel")));
			carro.setValor(Double.parseDouble(request.getParameter("valor")));
			
			dao.update(carro);
		}

		response.sendRedirect("index.jsp");
	}

}
