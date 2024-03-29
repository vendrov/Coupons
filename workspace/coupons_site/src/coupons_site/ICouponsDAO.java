/**
 * 
 */
package coupons_site;

import java.util.Iterator;

import org.hibernate.Session;

import coupons.hibernate.Coupon;

/**
 * @author admin
 *
 */
public interface ICouponsDAO {
	public abstract Coupon getCoupon(int id, Session session);
	public abstract boolean updateCoupon(Coupon ob, Session session);
	public abstract Iterator<Coupon> getCoupons(int numberOfCoupons, Session session);
	public abstract boolean deleteCoupon(int id, Session session);
	public abstract boolean addCoupon(Coupon ob, Session session);
}
