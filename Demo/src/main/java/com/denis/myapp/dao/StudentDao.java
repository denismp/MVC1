package com.denis.myapp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.denis.myapp.entity.Student;



@Repository("studentDao")
@Transactional(value="transactionManager")
public class StudentDao implements StudentDaoInterface, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3679551566334752574L;
	private final Logger log = Logger.getLogger (this.getClass());
	@Autowired
	protected HibernateTemplate hibernateTemplate;

	protected Session currentDatabaseSession() {
		
		return this.hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAll() throws Exception{
		
		try{
			final Criteria criteria = currentDatabaseSession().createCriteria(Student.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			//criteria.add(Restrictions.eq("deleted", false));
			return (List<Student>)criteria.list();
		} catch( Exception e ){
			log.error(e.getMessage(), e);
			throw new Exception(e);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getByName(String name) throws Exception{
		
		try{
			final Criteria criteria = currentDatabaseSession().createCriteria(Student.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.add(Restrictions.eq("name", name));
			return (List<Student>)criteria.list();
		} catch( Exception e ){
			log.error(e.getMessage(), e);
			throw new Exception(e);
		}
		
	}
	
	
	public void update(Student object) throws Exception{
		log.trace("update() called ...");
		System.out.println("Got into the update function");
		try{
			this.hibernateTemplate.update(object);
		} catch(Exception e){
			e.printStackTrace();
			//eat exception
			log.error(e.getMessage(), e);
			throw new Exception( e );
		}
	}

	public Student merge(Student object) throws SQLException, Exception {
		log.trace("merge() called ...");
		Session session = currentDatabaseSession();
		try{
			object = (Student)session.merge(object);
		} catch(org.hibernate.exception.ConstraintViolationException ce){
			log.info(ce.getMessage(), ce);
			throw new SQLException(ce);
		} catch(Exception e){
			log.error(e.getMessage(), e);
			//e.printStackTrace();
			//eat exception?
			throw new Exception(e);
		}
		return object;
	}
	
	public void persist(Student object) throws Exception{
		log.trace("persist() called ...");
		System.out.println("Got into the persist function");
		try{
			this.hibernateTemplate.persist(object);
		} catch(Exception e){
			e.printStackTrace();
			//eat exception
			log.error(e.getMessage(), e);
			throw new Exception( e );
		}
	}
}

