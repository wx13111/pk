package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Lend;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Lend
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see bookdao.Lend
 * @author MyEclipse Persistence Tools
 */
public class LendDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LendDAO.class);
	// property constants
	public static final String CUS_ID = "cusId";
	public static final String BOOK_ID = "bookId";

	public void save(Lend transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Lend instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Lend persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Lend instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Lend findById(java.lang.Integer id) {
		log.debug("getting Lend instance with id: " + id);
		try {
			Lend instance = (Lend) getSession().get("bookdao.Lend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Lend instance) {
		log.debug("finding Lend instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Lend")
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
		log.debug("finding Lend instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Lend as model where model."
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

	public List findByBookId(Object bookId) {
		return findByProperty(BOOK_ID, bookId);
	}

	public List findAll() {
		log.debug("finding all Lend instances");
		try {
			String queryString = "from Lend";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Lend merge(Lend detachedInstance) {
		log.debug("merging Lend instance");
		try {
			Lend result = (Lend) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Lend instance) {
		log.debug("attaching dirty Lend instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Lend instance) {
		log.debug("attaching clean Lend instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}