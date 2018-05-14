package com.mindtree.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class BuyProduct
 */
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		String productId = request.getParameter("ProductId");
		String stockNumber  = request.getParameter("Quantity");
		String resourceURL ="http://localhost:8080/RestWebserices201/webapi/client/";
		String message = client.target(resourceURL).path(productId+"/"+stockNumber).request(MediaType.TEXT_PLAIN).header("Authorization", "Basic YWRtaW46YWRtaW4=").get(String.class);
		request.setAttribute("message", message);
		ServletContext context= getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/buy.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
