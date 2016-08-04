package com.wxht.dao.resourcetype;
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

import com.wxht.entity.ResourceType;

/**
 * A data access object (DAO) providing persistence and search support for
 * ResourceType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .ResourceType
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ResourceTypeDao implements IResourceTypeDao {
	private static final Log log = LogFactory.getLog(ResourceTypeDao.class);
	// property constants
	public static final String NAME = "name";

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

	public void save(ResourceType transientInstance) {
		log.info("saving ResourceType instance");
		try {
			getCurrentSession().save(transientInstance);
			log.info("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ResourceType persistentInstance) {
		log.info("deleting ResourceType instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.info("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ResourceType findById(java.lang.String id) {
		log.info("getting ResourceType instance with id: " + id);
		try {
			ResourceType instance = (ResourceType) getCurrentSession().get(
					"ResourceType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ResourceType instance) {
		log.info("finding ResourceType instance by example");
		try {
			List results = getCurrentSession().createCriteria("ResourceType")
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
		log.info("finding ResourceType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ResourceType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.info("finding all ResourceType instances");
		try {
			String queryString = "from ResourceType";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ResourceType merge(ResourceType detachedInstance) {
		log.info("merging ResourceType instance");
		try {
			ResourceType result = (ResourceType) getCurrentSession().merge(
					detachedInstance);
			log.info("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ResourceType instance) {
		log.info("attaching dirty ResourceType instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ResourceType instance) {
		log.info("attaching clean ResourceType instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.info("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResourceTypeDao getFromApplicationContext(
			ApplicationContext ctx) {
		return (ResourceTypeDao) ctx.getBean("ResourceTypeDAO");
	}
}