package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.PressDAO;
import bookmodel.Press;
import hibernate.HibernateSessionFactory;


public class PressControl {

	/*	PressControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static PressControl control = null; 
	public static PressControl getPressControl(){
		if(null==control){
			control = new PressControl();
		}
		return control;
	}
	
	/* PressDAO
	 * PresslevelDAO
	 * HibernateSession
	 */
	private PressDAO umlpressDao = null;
	private Session session = null;
	private PressControl(){
		umlpressDao = new PressDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Press savePress( String bookName, String press1){
		Press press = new Press(  bookName,  press1);
		umlpressDao.save(press);
		session.flush();
		return press;
	}
	public Press deletePress(String pressName){
		Press press = new Press();
		List list = umlpressDao.findByBookName(pressName);
		umlpressDao.delete( ( (Press)list.get(0)));
		umlpressDao.delete(press);
		session.flush();
		return press;
	}
	public List findPress(String PressName){
		List list = new PressDAO().findByBookName(PressName);
		session.flush();
		return list;
	}
}