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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Carro carro = new Carro();
		CarroDAO dao = new CarroDAO();
		
		carro.setModelo(request.getParameter("modelo"));
		carro.setMarca(request.getParameter("marca"));
		
		carro.setTipoCombustivel(TipoCombustivel.valueOf(request.getParameter("tipocombustivel")));
		
		carro.setValor(Double.parseDouble(request.getParameter("valor")));
		
		dao.create(carro);
		
		response.sendRedirect("index.jsp");
	}

}
