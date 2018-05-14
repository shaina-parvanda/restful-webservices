package com.mindtree.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.mindtree.entity.Product;

/**
 * Servlet implementation class RetrieveProductsAccordingToRange
 */
public class RetrieveProductsAccordingToRange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveProductsAccordingToRange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		String minRange = request.getParameter("MinRange");
		String maxRange = request.getParameter("MaxRange");
		String resourceURL ="http://localhost:8080/RestWebserices201/webapi/client/";
		GenericType<List<Product>> list = new GenericType<List<Product>>(){};
		List<Product> productList= client.target(resourceURL).queryParam("min",minRange).queryParam("max",maxRange).request(MediaType.APPLICATION_JSON).header("Authorization", "Basic YWRtaW46YWRtaW4=").get(list);
		if(productList.size() != 0)
		{
			request.setAttribute("showList", true);
			request.setAttribute("productList",productList );
		}
		else
		{
			request.setAttribute("error", true);
			request.setAttribute("errorMessage", "No product is present in given range");
		}
		ServletContext context= getServletContext();
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/retrieveProductsOnRange.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
