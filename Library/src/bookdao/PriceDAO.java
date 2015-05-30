package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Price;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Price
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see bookdao.Price
 * @author MyEclipse Persistence Tools
 */
public class PriceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PriceDAO.class);
	// property constants
	public static final String BOOK_NAME = "bookName";
	public static final String PRICE = "price";

	public void save(Price transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Price instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Price persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Price instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Price findById(java.lang.Integer id) {
		log.debug("getting Price instance with id: " + id);
		try {
			Price instance = (Price) getSession().get("bookdao.Price", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Price instance) {
		log.debug("finding Price instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Price")
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
		log.debug("finding Price instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Price as model where model."
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

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all Price instances");
		try {
			String queryString = "from Price";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Price merge(Price detachedInstance) {
		log.debug("merging Price instance");
		try {
			Price result = (Price) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Price instance) {
		log.debug("attaching dirty Price instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Price instance) {
		log.debug("attaching clean Price instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}