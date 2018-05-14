package com.mindtree.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mindtree.entity.Product;

public class ProductsShoppingDaoImpl implements ProductsShoppingDaoInterface {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	/**
	 * Function to insert product details
	 */
	@Override
	public boolean addNewProduct(Product product) {
		Session session = sessionFactory.openSession();
		try
		{
		session.beginTransaction();
		session.saveOrUpdate(product);
		System.out.println("Product is inserted ");
		session.getTransaction().commit();
		return true;
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			System.out.println("Some database transaction error occured");
			return false;
		}
		finally{
			
			session.close();
		}
	}

	/**
	 * Function to update product details
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateDetailsOfProduct(int productId , Product product) {
		List<Product> productsList = null;
		Session session = sessionFactory.openSession();
		try
		{
			Transaction transaction=session.beginTransaction();
			Query queryResult =  session.createQuery("from PRODUCTS where productId= :productId");
			queryResult.setInteger("productId", productId);
			productsList = queryResult.list();
			if(productsList.size()>0)
			{
			String hql ="update PRODUCTS set productName = :name , price =:price, productCategory =:category , stockNumber = :stockNumber , remarks =:remarks where productId = :productId";
			Query query =session.createQuery(hql);
			query.setString("name", product.getProductName());
			query.setDouble("price", product.getPrice());
			query.setString("category", product.getProductCategory());
			query.setInteger("stockNumber", product.getStockNumber());
			query.setString("remarks", product.getRemarks());
			query.setInteger("productId",productId);
			query.executeUpdate();
			transaction.commit();
			System.out.println("Product is updated");
			return true;
			}
			else
			{
				return false;
			}
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Some database transaction error occured");
			return false;
			
		}
		finally{
			
			session.close();
		}
	}
	/**
	 * Function to retrieve product details
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Product> retrieveProducts() {
		List<Product> productsList = null;
		Session session = sessionFactory.openSession();
		try
		{
		session.beginTransaction();
		Query queryResult =  session.createQuery("from PRODUCTS");
		productsList = queryResult.list();
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			System.out.println("Some database transaction error occured");
		}
		finally
		{
			session.close();
		}
		return (ArrayList<Product>) productsList;
	}
	
	/**
	 * Function to retrieve product details according to specific category
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Product> retrieveProductsSpecificToCategory(String category) {
		List<Product> productsList = null;
		Session session = sessionFactory.openSession();
		try
		{
		session.beginTransaction();
		Query queryResult =  session.createQuery("from PRODUCTS where productCategory= :category");
		queryResult.setString("category", category);
		productsList = queryResult.list();
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			System.out.println("Some database transaction error occured");
		}
		finally
		{
			session.close();
		}
		return (ArrayList<Product>) productsList;
		
	}
	/**
	 * Function to retrieve product details according to price range
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Product> retrieveProductsSpecificToPriceRange(Double leastPrice , Double maxPrice) {
		List<Product> productsList = null;
		Session session = sessionFactory.openSession();
		try
		{
		session.beginTransaction();
		Query queryResult =  session.createQuery("from PRODUCTS where price BETWEEN :leastPrice AND :maxPrice");
		queryResult.setParameter("leastPrice", leastPrice);
		queryResult.setParameter("maxPrice", maxPrice);
		productsList = queryResult.list();
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			session.getTransaction().rollback();
			System.out.println("Some database transaction error occured");
		}
		finally
		{
			session.close();
		}
		return (ArrayList<Product>) productsList;
	}

	/**
	 * Function to delete product details
	 */
	@Override
	public boolean deleteProduct(int productId) {
		Session session = sessionFactory.openSession();
		try
		{
		session.beginTransaction();
		String hql ="delete from PRODUCTS where productId= :productId";
		Query query =session.createQuery(hql);
		query.setInteger("productId", productId);
		query.executeUpdate();
		session.getTransaction().commit();
		return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Some database transaction error occured");
			return false;
		}
		finally{
			session.close();
		}
		
	}

	/**
	 * Function to buy product 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String buyProduct(int productId, int stockNumber) {
		String message = null;
		Session session = sessionFactory.openSession();
		try
		{
		Transaction transaction=session.beginTransaction();
		Query queryResult =  session.createQuery("from PRODUCTS where productId= :productId");
		queryResult.setParameter("productId", productId);
		List<Product> products =  queryResult.list();
		if(products.size()>0)
		{
		Product product = products.get(0);
		int currentStock = product.getStockNumber();
		if(currentStock >= stockNumber )
			{	int leftStock = currentStock-stockNumber;
				Query query = session.createQuery("update PRODUCTS set stockNumber = :stockNumber where productId = :productId");
				query.setInteger("stockNumber", leftStock);
				query.setInteger("productId", productId);
				query.executeUpdate();
				transaction.commit();
				message = "Order is placed";
			}
		else
			{
			message = "Item out of stock";
			}
		}
		else
			{
			message ="Invalid product Id";
			}	
		}catch(HibernateException e)
		{
		session.getTransaction().rollback();
		System.out.println("Some database transaction error occured");
	}
	finally{
		session.close();
	}
		return message;
	}
	
}
