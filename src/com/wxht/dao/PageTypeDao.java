package com.wxht.dao;
// default package

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.wxht.entity.PageType;

/**
 	* A data access object (DAO) providing persistence and search support for PageType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .PageType
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class PageTypeDao  {
	     private static final Logger log = LoggerFactory.getLogger(PageTypeDao.class);
		//property constants
	public static final String NAME = "name";



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(PageType transientInstance) {
        log.debug("saving PageType instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PageType persistentInstance) {
        log.debug("deleting PageType instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PageType findById( java.lang.String id) {
        log.debug("getting PageType instance with id: " + id);
        try {
            PageType instance = (PageType) getCurrentSession()
                    .get("PageType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PageType instance) {
        log.debug("finding PageType instance by example");
        try {
            List results = getCurrentSession().createCriteria("PageType") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding PageType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PageType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	

	public List findAll() {
		log.debug("finding all PageType instances");
		try {
			String queryString = "from PageType";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PageType merge(PageType detachedInstance) {
        log.debug("merging PageType instance");
        try {
            PageType result = (PageType) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PageType instance) {
        log.debug("attaching dirty PageType instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PageType instance) {
        log.debug("attaching clean PageType instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PageTypeDao getFromApplicationContext(ApplicationContext ctx) {
    	return (PageTypeDao) ctx.getBean("PageTypeDAO");
	}
}