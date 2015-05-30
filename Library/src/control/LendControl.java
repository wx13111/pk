package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.LendDAO;
import bookmodel.Lend;
import hibernate.HibernateSessionFactory;


public class LendControl {

	/*	LendControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static LendControl control = null; 
	public static LendControl getLendControl(){
		if(null==control){
			control = new LendControl();
		}
		return control;
	}
	
	/* LendDAO
	 * LendlevelDAO
	 * HibernateSession
	 */
	private LendDAO umllendDao = null;
	private Session session = null;
	private LendControl(){
		umllendDao = new LendDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Lend saveLend( Integer cusId, Integer bookId){
		Lend lend = new Lend(  cusId,  bookId);
		umllendDao.save(lend);
		session.flush();
		return lend;
	}
	public Lend deleteLend(Integer lendName){
		Lend lend = new Lend();
		List list = umllendDao.findByCusId(lendName);
		umllendDao.delete( ( (Lend)list.get(0)));
		umllendDao.delete(lend);
		session.flush();
		return lend;
	}
	public List findLend(Integer LendName){
		List list = new LendDAO().findByCusId(LendName);
		session.flush();
		return list;
	}
}