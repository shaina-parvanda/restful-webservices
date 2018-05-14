package com.mindtree.service;

import java.util.ArrayList;

import com.mindtree.entity.Product;

public interface BuyerServiceInterface {
	public ArrayList<Product> retriveProductsSpecificToCategory(String category);
	public ArrayList<Product> retriveProductsAccordingToRange(Double leastPrice , Double MaxPrice);
	public String buyProducts(int productId, int stockNumber);
}
