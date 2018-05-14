package com.mindtree.service;

import java.util.ArrayList;

import com.mindtree.dao.ProductsShoppingDaoImpl;
import com.mindtree.entity.Product;

public class SellerServiceImpl implements SellerServiceInterface {

	@Override
	public String insertProduct(Product product) {
		ProductsShoppingDaoImpl productsShoppingObject = new ProductsShoppingDaoImpl();
		if(productsShoppingObject.addNewProduct(product))
		{
			return "Product added successfully";
		}
		else
		{
			return "Couldn't save the product";
		}
	}

	@Override
	public String updateProductDetails(int  productId, Product product) {
		ProductsShoppingDaoImpl productsShoppingObject = new ProductsShoppingDaoImpl();
		if(productsShoppingObject.updateDetailsOfProduct(productId, product))
		{
			return "Product details Updated";
		}
		else
		{
			return "Couldn't update the product details.Prdouct Id doesnt match in database";
		}
	}

	@Override
	public ArrayList<Product> retrieveProductDetails() {
		ArrayList<Product> productList;
		ProductsShoppingDaoImpl productsShoppingObject = new ProductsShoppingDaoImpl();
		productList = productsShoppingObject.retrieveProducts();
		return productList;
	}

	@Override
	public String deleteProduct(int productId) {
		ProductsShoppingDaoImpl productsShoppingObject = new ProductsShoppingDaoImpl();
		if(productsShoppingObject.deleteProduct(productId))
		{
			return "Product deleted";
		}
		else
		{
			return "Product couldn't be deleted";
		}
	}

}
