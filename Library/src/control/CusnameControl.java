package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.CusnameDAO;
import bookmodel.Cusname;
import hibernate.HibernateSessionFactory;


public class CusnameControl {

	/*	CusnameControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static CusnameControl control = null; 
	public static CusnameControl getCusnameControl(){
		if(null==control){
			control = new CusnameControl();
		}
		return control;
	}
	
	/* CusnameDAO
	 * CusnamelevelDAO
	 * HibernateSession
	 */
	private CusnameDAO umlcusnameDao = null;
	private Session session = null;
	private CusnameControl(){
		umlcusnameDao = new CusnameDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Cusname saveCusname( Integer cusId, String cusName){
		Cusname cusname = new Cusname( cusId,  cusName);
		umlcusnameDao.save(cusname);
		session.flush();
		return cusname;
	}
	public Cusname deleteCusname(Integer cusnameName){
		Cusname cusname = new Cusname();
		List list = umlcusnameDao.findByCusId(cusnameName);
		umlcusnameDao.delete( ( (Cusname)list.get(0)));
		umlcusnameDao.delete(cusname);
		session.flush();
		return cusname;
	}
	public List findCusname(Integer CusnameName){
		List list = new CusnameDAO().findByCusId(CusnameName);
		session.flush();
		return list;
	}
}