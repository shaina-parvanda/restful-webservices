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
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import com.mindtree.entity.Product;

/**
 * Servlet implementation class InsertNewProduct
 */
public class InsertNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		Product product = new Product();
		product.setProductName(request.getParameter("ProductName"));
		product.setPrice(Double.parseDouble(request.getParameter("Price")));
		product.setProductCategory(request.getParameter("Category"));
		product.setStockNumber(Integer.parseInt(request.getParameter("Quantity")));
		product.setRemarks(request.getParameter("Remarks"));
		String resourceURL ="http://localhost:8080/RestWebserices201/webapi/seller";
		String message = client.target(resourceURL).request(MediaType.TEXT_PLAIN).header("Authorization", "Basic YWRtaW46YWRtaW4=").put(Entity.entity(product, 
		         MediaType.APPLICATION_XML), 
		         String.class);
		request.setAttribute("message", message);
		ServletContext context= getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/insertProduct.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
