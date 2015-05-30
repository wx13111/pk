package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.CusphoneDAO;
import bookmodel.Cusphone;
import hibernate.HibernateSessionFactory;


public class CusphoneControl {

	/*	CusphoneControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static CusphoneControl control = null; 
	public static CusphoneControl getCusphoneControl(){
		if(null==control){
			control = new CusphoneControl();
		}
		return control;
	}
	
	/* CusphoneDAO
	 * CusphonelevelDAO
	 * HibernateSession
	 */
	private CusphoneDAO umlcusphoneDao = null;
	private Session session = null;
	private CusphoneControl(){
		umlcusphoneDao = new CusphoneDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Cusphone saveCusphone(  Integer cusId, String cusPhone){
		Cusphone cusphone = new Cusphone(  cusId,  cusPhone);
		umlcusphoneDao.save(cusphone);
		session.flush();
		return cusphone;
	}
	public Cusphone deleteCusphone(Integer cusphoneName){
		Cusphone cusphone = new Cusphone();
		List list = umlcusphoneDao.findByCusId(cusphoneName);
		umlcusphoneDao.delete( ( (Cusphone)list.get(0)));
		umlcusphoneDao.delete(cusphone);
		session.flush();
		return cusphone;
	}
	public List findCusphone(Integer CusphoneName){
		List list = new CusphoneDAO().findByCusId(CusphoneName);
		session.flush();
		return list;
	}
}