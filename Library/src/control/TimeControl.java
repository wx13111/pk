package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.TimeDAO;
import bookmodel.Time;
import hibernate.HibernateSessionFactory;


public class TimeControl {

	/*	TimeControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static TimeControl control = null; 
	public static TimeControl getTimeControl(){
		if(null==control){
			control = new TimeControl();
		}
		return control;
	}
	
	/* TimeDAO
	 * TimelevelDAO
	 * HibernateSession
	 */
	private TimeDAO umltimeDao = null;
	private Session session = null;
	private TimeControl(){
		umltimeDao = new TimeDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Time saveTime( Integer cusId, Integer lendTime, Integer retTime){
		Time time = new Time( cusId, lendTime,  retTime);
		umltimeDao.save(time);
		session.flush();
		return time;
	}
	public Time deleteTime(Integer timeName){
		Time time = new Time();
		List list = umltimeDao.findByCusId(timeName);
		umltimeDao.delete( ( (Time)list.get(0)));
		umltimeDao.delete(time);
		session.flush();
		return time;
	}
	public List findTime(Integer TimeName){
		List list = new TimeDAO().findByCusId(TimeName);
		session.flush();
		return list;
	}
}