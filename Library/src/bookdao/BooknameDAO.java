package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Bookname;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bookname entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bookdao.Bookname
 * @author MyEclipse Persistence Tools
 */
public class BooknameDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BooknameDAO.class);
	// property constants
	public static final String BOOK_ID = "bookId";
	public static final String BOOK_NAME = "bookName";

	public void save(Bookname transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Bookname instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Bookname persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Bookname instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Bookname findById(java.lang.Integer id) {
		log.debug("getting Bookname instance with id: " + id);
		try {
			Bookname instance = (Bookname) getSession().get("bookdao.Bookname",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bookname instance) {
		log.debug("finding Bookname instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Bookname")
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
		log.debug("finding Bookname instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bookname as model where model."
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

	public List findByBookName(Object bookName) {
		return findByProperty(BOOK_NAME, bookName);
	}

	public List findAll() {
		log.debug("finding all Bookname instances");
		try {
			String queryString = "from Bookname";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bookname merge(Bookname detachedInstance) {
		log.debug("merging Bookname instance");
		try {
			Bookname result = (Bookname) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bookname instance) {
		log.debug("attaching dirty Bookname instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bookname instance) {
		log.debug("attaching clean Bookname instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}