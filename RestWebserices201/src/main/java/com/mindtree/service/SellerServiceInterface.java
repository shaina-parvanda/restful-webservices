package com.mindtree.service;

import java.util.ArrayList;

import com.mindtree.entity.Product;

public interface SellerServiceInterface {
	public String insertProduct(Product product);
	public ArrayList<Product> retrieveProductDetails();
	public String deleteProduct(int productId);
	public String updateProductDetails(int productId ,Product product);
}
