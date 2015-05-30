package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Time;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Time
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see bookdao.Time
 * @author MyEclipse Persistence Tools
 */
public class TimeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TimeDAO.class);
	// property constants
	public static final String CUS_ID = "cusId";
	public static final String LEND_TIME = "lendTime";
	public static final String RET_TIME = "retTime";

	public void save(Time transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Time instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Time persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Time instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Time findById(java.lang.Integer id) {
		log.debug("getting Time instance with id: " + id);
		try {
			Time instance = (Time) getSession().get("bookdao.Time", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Time instance) {
		log.debug("finding Time instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Time")
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
		log.debug("finding Time instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Time as model where model."
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

	public List findByLendTime(Object lendTime) {
		return findByProperty(LEND_TIME, lendTime);
	}

	public List findByRetTime(Object retTime) {
		return findByProperty(RET_TIME, retTime);
	}

	public List findAll() {
		log.debug("finding all Time instances");
		try {
			String queryString = "from Time";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Time merge(Time detachedInstance) {
		log.debug("merging Time instance");
		try {
			Time result = (Time) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Time instance) {
		log.debug("attaching dirty Time instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Time instance) {
		log.debug("attaching clean Time instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}