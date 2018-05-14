package com.mindtree.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mindtree.entity.Product;
import com.mindtree.service.BuyerServiceImpl;

@Path("client")
public class ClientResource {

	BuyerServiceImpl buyerObject= new BuyerServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{category}")
	public List<Product> getProductsSpecificToCategory(@PathParam("category") String category){
		List<Product> productList = new ArrayList<Product>();
		productList = buyerObject.retriveProductsSpecificToCategory(category);
		return productList;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Product> getProductsSpecificToRange(@QueryParam("min") Double leastPrice , @QueryParam("max") Double maxPrice ){
		List<Product> productList = new ArrayList<Product>();
		productList = buyerObject.retriveProductsAccordingToRange(leastPrice, maxPrice);
		return productList;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{productId}/{stockNumber}")
	public String buyProduct(@PathParam("productId") int productId , @PathParam("stockNumber") int stockNumber ) {
		String message = buyerObject.buyProducts(productId, stockNumber);
		return message;
	}
}
