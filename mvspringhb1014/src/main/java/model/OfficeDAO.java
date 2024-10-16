package model;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OfficeDAO {
   public static Office getOfficeById(String id) {
	   Office ofc=null;
	   Configuration cof=new Configuration();
	   SessionFactory factory=cof.configure("hibernate.cfg.xml").buildSessionFactory();
	   Session ss=factory.openSession();
	   TypedQuery<Office> q= ss.createQuery("from Office o where o.officeCode= :code",Office.class);
	   q.setParameter("code", id);
	   return q.getSingleResult();
   }
}


