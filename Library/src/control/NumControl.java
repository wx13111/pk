package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.NumDAO;
import bookmodel.Num;
import hibernate.HibernateSessionFactory;


public class NumControl {

	/*	NumControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static NumControl control = null; 
	public static NumControl getNumControl(){
		if(null==control){
			control = new NumControl();
		}
		return control;
	}
	
	/* NumDAO
	 * NumlevelDAO
	 * HibernateSession
	 */
	private NumDAO umlnumDao = null;
	private Session session = null;
	private NumControl(){
		umlnumDao = new NumDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Num saveNum( Integer bookId, Integer surNum, Integer lendNum){
		Num num = new Num(  bookId,surNum,  lendNum);
		umlnumDao.save(num);
		session.flush();
		return num;
	}
	public Num deleteNum(Integer numName){
		Num num = new Num();
		List list = umlnumDao.findByBookId(numName);
		umlnumDao.delete( ( (Num)list.get(0)));
		umlnumDao.delete(num);
		session.flush();
		return num;
	}
	public List findNum(Integer bookid){
		List list = new NumDAO().findByBookId(bookid);
		session.flush();
		return list;
	}
}