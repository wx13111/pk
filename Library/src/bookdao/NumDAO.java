package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Num;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Num
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see bookdao.Num
 * @author MyEclipse Persistence Tools
 */
public class NumDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(NumDAO.class);
	// property constants
	public static final String BOOK_ID = "bookId";
	public static final String SUR_NUM = "surNum";
	public static final String LEND_NUM = "lendNum";

	public void save(Num transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Num instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Num persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Num instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Num findById(java.lang.Integer id) {
		log.debug("getting Num instance with id: " + id);
		try {
			Num instance = (Num) getSession().get("bookdao.Num", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Num instance) {
		log.debug("finding Num instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Num")
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
		log.debug("finding Num instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Num as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBookId(Object bookId) {
		return findByProperty(BOOK_ID, bookId);
	}

	public List findBySurNum(Object surNum) {
		return findByProperty(SUR_NUM, surNum);
	}

	public List findByLendNum(Object lendNum) {
		return findByProperty(LEND_NUM, lendNum);
	}

	public List findAll() {
		log.debug("finding all Num instances");
		try {
			String queryString = "from Num";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Num merge(Num detachedInstance) {
		log.debug("merging Num instance");
		try {
			Num result = (Num) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Num instance) {
		log.debug("attaching dirty Num instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Num instance) {
		log.debug("attaching clean Num instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}