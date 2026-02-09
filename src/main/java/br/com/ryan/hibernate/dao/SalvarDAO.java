package br.com.ryan.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ryan.hibernate.util.HibernateUtil;

public interface SalvarDAO<T> {
	
	default void salvar(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.saveOrUpdate(entity);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			throw e;
		}
		finally {
			session.close();
		}
	}
}