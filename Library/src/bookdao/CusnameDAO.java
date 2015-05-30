package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Cusname;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cusname entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bookdao.Cusname
 * @author MyEclipse Persistence Tools
 */
public class CusnameDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CusnameDAO.class);
	// property constants
	public static final String CUS_ID = "cusId";
	public static final String CUS_NAME = "cusName";

	public void save(Cusname transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Cusname instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Cusname persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Cusname instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Cusname findById(java.lang.Integer id) {
		log.debug("getting Cusname instance with id: " + id);
		try {
			Cusname instance = (Cusname) getSession()
					.get("bookdao.Cusname", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cusname instance) {
		log.debug("finding Cusname instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Cusname")
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
		log.debug("finding Cusname instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cusname as model where model."
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

	public List findByCusName(Object cusName) {
		return findByProperty(CUS_NAME, cusName);
	}

	public List findAll() {
		log.debug("finding all Cusname instances");
		try {
			String queryString = "from Cusname";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cusname merge(Cusname detachedInstance) {
		log.debug("merging Cusname instance");
		try {
			Cusname result = (Cusname) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cusname instance) {
		log.debug("attaching dirty Cusname instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cusname instance) {
		log.debug("attaching clean Cusname instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}