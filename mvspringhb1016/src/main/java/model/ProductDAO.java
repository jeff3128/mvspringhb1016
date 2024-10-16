package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDAO{

	private List<Product> products;
	
	void  from_mvDB(){
	   	 Configuration configObj = new Configuration();
			 configObj.addAnnotatedClass(model.Product.class);
			 configObj.configure("hibernate.cfg.xml"); 
			 Session session = null;
		     session = configObj.buildSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				products= session.createQuery("FROM Product").list();
			    System.out.println("product list :"+products);
				tx.commit();		
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}    	
	   }
	public ProductDAO() {
		//this.products = new ArrayList<Product>();
		//this.products.add(new Product("p01", "JBud Elite", "images/p1.jpg", 20));
		//this.products.add(new Product("p02", "EdiMax Wifi", "images/p2.jpg", 21));
		//this.products.add(new Product("p03", "Asus Laptop", "images/p3.jpg", 22));
		from_mvDB();
	}

	public List<Product> findAll() {
		return this.products;
	}

	public Product find(String id) {
		for (Product product : this.products) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}

}

