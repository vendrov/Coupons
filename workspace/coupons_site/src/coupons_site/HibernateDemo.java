package coupons_site;

import java.util.Date;
import java.util.List;
import java.util.Iterator;

import org.apache.tomcat.jni.Time;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sun.jmx.snmp.Timestamp;

import coupons.hibernate.Coupon;

public class HibernateDemo
{
	public static void main(String[] args) 
	{
		//creating factory for getting sessions
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		//creating a new session for adding products
		Session session = factory.openSession();
		ICouponsDAO newCoupon = new Coupon();
		Coupon coupon = new Coupon();
		coupon.setBusinessId(1);
		coupon.setExpiredTime(new Date());
		coupon.setId(1);
		coupon.setImage("image");
		coupon.setName("masagge");
		coupon.setUploadTime(new Date());
		newCoupon.addCoupon(coupon, session);
		
		coupon.setBusinessId(2);
		coupon.setExpiredTime(new Date());
		coupon.setId(2);
		coupon.setImage("image");
		coupon.setName("sholi");
		coupon.setUploadTime(new Date());
		newCoupon.addCoupon(coupon, factory.openSession());
		
		Iterator<Coupon> i = newCoupon.getCoupons(20, factory.openSession());
		while(i.hasNext()) 
		{
			System.out.println(i.next().getName());
		}
		

		//newCoupon.addCoupon(new Coupon(), session);
		//newCoupon.deleteCoupon(0, session);
	/*	session.beginTransaction();
		Coupon coupon = new Coupon();
		session.save(coupon);
		session.getTransaction().commit();
		session.close();

		//creating a new session for getting all products
		Session anotherSession = factory.openSession();
		anotherSession.beginTransaction();
		List products = anotherSession.createQuery("from Coupon").list();
		System.out.println("There are " + products.size() + " product(s)");
		Iterator i = products.iterator();
		while(i.hasNext()) 
		{
			System.out.println(i.next());
		}
		anotherSession.close(); 
		*/
	}
}