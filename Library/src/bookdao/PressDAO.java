package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Press;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Press
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see bookdao.Press
 * @author MyEclipse Persistence Tools
 */
public class PressDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PressDAO.class);
	// property constants
	public static final String BOOK_NAME = "bookName";
	public static final String PRESS = "press";

	public void save(Press transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Press instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Press persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Press instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Press findById(java.lang.Integer id) {
		log.debug("getting Press instance with id: " + id);
		try {
			Press instance = (Press) getSession().get("bookdao.Press", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Press instance) {
		log.debug("finding Press instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Press")
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
		log.debug("finding Press instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Press as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBookName(Object bookName) {
		return findByProperty(BOOK_NAME, bookName);
	}

	public List findByPress(Object press) {
		return findByProperty(PRESS, press);
	}

	public List findAll() {
		log.debug("finding all Press instances");
		try {
			String queryString = "from Press";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Press merge(Press detachedInstance) {
		log.debug("merging Press instance");
		try {
			Press result = (Press) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Press instance) {
		log.debug("attaching dirty Press instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Press instance) {
		log.debug("attaching clean Press instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}