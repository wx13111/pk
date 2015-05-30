package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.PriceDAO;
import bookmodel.Price;
import hibernate.HibernateSessionFactory;


public class PriceControl {

	/*	PriceControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static PriceControl control = null; 
	public static PriceControl getPriceControl(){
		if(null==control){
			control = new PriceControl();
		}
		return control;
	}
	
	/* PriceDAO
	 * PricelevelDAO
	 * HibernateSession
	 */
	private PriceDAO umlpriceDao = null;
	private Session session = null;
	private PriceControl(){
		umlpriceDao = new PriceDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Price savePrice(  String bookName, Integer price1){
		Price price = new Price(   bookName,  price1);
		umlpriceDao.save(price);
		session.flush();
		return price;
	}
	public Price deletePrice(Integer priceName){
		Price price = new Price();
		List list = umlpriceDao.findByBookName(priceName);
		umlpriceDao.delete( ( (Price)list.get(0)));
		umlpriceDao.delete(price);
		session.flush();
		return price;
	}
	public List findPrice(String PriceName){
		List list = new PriceDAO().findByBookName(PriceName);
		session.flush();
		return list;
	}
}