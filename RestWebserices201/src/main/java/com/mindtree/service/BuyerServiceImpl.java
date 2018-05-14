package com.mindtree.service;

import java.util.ArrayList;

import com.mindtree.dao.ProductsShoppingDaoImpl;
import com.mindtree.entity.Product;

public class BuyerServiceImpl implements BuyerServiceInterface {

	@Override
	public ArrayList<Product> retriveProductsSpecificToCategory(String category) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductsShoppingDaoImpl productsShoppingObject = new ProductsShoppingDaoImpl();
		productList = productsShoppingObject.retrieveProductsSpecificToCategory(category);
		return productList;
	}

	@Override
	public ArrayList<Product> retriveProductsAccordingToRange(Double leastPrice, Double maxPrice) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductsShoppingDaoImpl productsShoppingObject = new ProductsShoppingDaoImpl();
		productList = productsShoppingObject.retrieveProductsSpecificToPriceRange(leastPrice, maxPrice);
		return productList;
	}

	@Override
	public String buyProducts(int productId, int stockNumber) {
		ProductsShoppingDaoImpl productsShoppingObject = new ProductsShoppingDaoImpl();
		String message = productsShoppingObject.buyProduct(productId, stockNumber);
		return message;
		
	}

}
