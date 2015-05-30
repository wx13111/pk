package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Money;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Money
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see bookdao.Money
 * @author MyEclipse Persistence Tools
 */
public class MoneyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MoneyDAO.class);
	// property constants
	public static final String CUS_ID = "cusId";
	public static final String MONEY = "money";

	public void save(Money transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Money instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Money persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Money instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Money findById(java.lang.Integer id) {
		log.debug("getting Money instance with id: " + id);
		try {
			Money instance = (Money) getSession().get("bookdao.Money", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Money instance) {
		log.debug("finding Money instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Money")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Money instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Money as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCusId(Object cusId) {
		return findByProperty(CUS_ID, cusId);
	}

	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List findAll() {
		log.debug("finding all Money instances");
		try {
			String queryString = "from Money";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Money merge(Money detachedInstance) {
		log.debug("merging Money instance");
		try {
			Money result = (Money) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Money instance) {
		log.debug("attaching dirty Money instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Money instance) {
		log.debug("attaching clean Money instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}