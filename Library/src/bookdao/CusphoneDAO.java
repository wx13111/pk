package bookdao;

import bookdao.BaseHibernateDAO;
import bookmodel.Cusphone;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cusphone entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bookdao.Cusphone
 * @author MyEclipse Persistence Tools
 */
public class CusphoneDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CusphoneDAO.class);
	// property constants
	public static final String CUS_ID = "cusId";
	public static final String CUS_PHONE = "cusPhone";

	public void save(Cusphone transientInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("saving Cusphone instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(Cusphone persistentInstance) {		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting Cusphone instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public Cusphone findById(java.lang.Integer id) {
		log.debug("getting Cusphone instance with id: " + id);
		try {
			Cusphone instance = (Cusphone) getSession().get("bookdao.Cusphone",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cusphone instance) {
		log.debug("finding Cusphone instance by example");
		try {
			List results = getSession().createCriteria("bookdao.Cusphone")
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
		log.debug("finding Cusphone instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cusphone as model where model."
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

	public List findByCusPhone(Object cusPhone) {
		return findByProperty(CUS_PHONE, cusPhone);
	}

	public List findAll() {
		log.debug("finding all Cusphone instances");
		try {
			String queryString = "from Cusphone";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cusphone merge(Cusphone detachedInstance) {
		log.debug("merging Cusphone instance");
		try {
			Cusphone result = (Cusphone) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cusphone instance) {
		log.debug("attaching dirty Cusphone instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cusphone instance) {
		log.debug("attaching clean Cusphone instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}