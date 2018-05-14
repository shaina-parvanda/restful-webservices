package com.mindtree.client;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mindtree.entity.Product;
import com.mindtree.service.SellerServiceImpl;

/**
 * Root resource (exposed at "seller" path)
 */
@Path("seller")
public class SellerResource {
	SellerServiceImpl sellerObject = new SellerServiceImpl();
	
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public ArrayList<Product> getProducts() {
        ArrayList<Product> productList = new ArrayList<Product>();
        productList =  sellerObject.retrieveProductDetails();
        return productList;
    }
    
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_XML)
    public String insertProduct(Product product){
		String message = sellerObject.insertProduct(product);
		return message;
    	}
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/{productId}")
    public String updateProduct(@PathParam("productId") int productId, Product product){
    	String message = sellerObject.updateProductDetails(productId, product);
		return message;
    }
    
   @DELETE
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.APPLICATION_XML)
   @Path("/{productId}")
   public String deleteProduct(@PathParam("productId") int productId){
	   String message = sellerObject.deleteProduct(productId);
	   return message;
   }
 
}
