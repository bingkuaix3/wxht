package com.wxht.dao.user;

// default package

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.wxht.entity.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see .User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserDao implements IUserDao {
	private static final Log log = LogFactory.getLog(UserDao.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String HEADIMG = "headimg";
	public static final String COMPANY = "company";
	public static final String APPLYID = "applyid";
	public static final String APPLYSECRET = "applysecret";
	public static final String TOKEN = "token";
	public static final String WXNAME = "wxname";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(User transientInstance) {
		log.info("saving User instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.info("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.String id) {
		log.info("getting User instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get("User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.info("finding User instance by example");
		try {
			List results = getCurrentSession().createCriteria("User")
					.add(Example.create(instance)).list();
			log.info("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.info("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByHeadimg(Object headimg) {
		return findByProperty(HEADIMG, headimg);
	}

	public List findByCompany(Object company) {
		return findByProperty(COMPANY, company);
	}

	public List findByApplyid(Object applyid) {
		return findByProperty(APPLYID, applyid);
	}

	public List findByApplysecret(Object applysecret) {
		return findByProperty(APPLYSECRET, applysecret);
	}

	public List findByToken(Object token) {
		return findByProperty(TOKEN, token);
	}

	public List findByWxname(Object wxname) {
		return findByProperty(WXNAME, wxname);
	}

	public List findAll() {
		log.info("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.info("merging User instance");
		try {
			User result = (User) getCurrentSession().merge(detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.info("attaching dirty User instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.info("attaching clean User instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDao getFromApplicationContext(ApplicationContext ctx) {
		return (UserDao) ctx.getBean("UserDAO");
	}
}