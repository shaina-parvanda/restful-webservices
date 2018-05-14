package com.mindtree.dao;

import java.util.ArrayList;

import com.mindtree.entity.Product;

public interface ProductsShoppingDaoInterface {

	public boolean addNewProduct(Product product);
	public ArrayList<Product> retrieveProducts();
	public boolean deleteProduct(int productId);
	public ArrayList<Product> retrieveProductsSpecificToCategory(String category);
	public ArrayList<Product> retrieveProductsSpecificToPriceRange(Double leastPrice , Double maxPrice);
	public String buyProduct(int productId, int stockNumber);
	boolean updateDetailsOfProduct(int productId ,Product product);
	
}
