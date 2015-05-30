package control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import bookdao.MoneyDAO;
import bookmodel.Money;
import hibernate.HibernateSessionFactory;


public class MoneyControl {

	/*	MoneyControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static MoneyControl control = null; 
	public static MoneyControl getMoneyControl(){
		if(null==control){
			control = new MoneyControl();
		}
		return control;
	}
	
	/* MoneyDAO
	 * MoneylevelDAO
	 * HibernateSession
	 */
	private MoneyDAO umlmoneyDao = null;
	private Session session = null;
	private MoneyControl(){
		umlmoneyDao = new MoneyDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public Money saveMoney( Integer cusId, Integer money1){
		Money money = new Money(  cusId,money1);
		umlmoneyDao.save(money);
		session.flush();
		return money;
	}
	public Money deleteMoney(Integer moneyName){
		Money money = new Money();
		List list = umlmoneyDao.findByCusId(moneyName);
		umlmoneyDao.delete( ( (Money)list.get(0)));
		umlmoneyDao.delete(money);
		session.flush();
		return money;
	}
	public List findMoney(Integer MoneyName){
		List list = new MoneyDAO().findByCusId(MoneyName);
		session.flush();
		return list;
	}
}