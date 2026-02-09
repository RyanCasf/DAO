package br.com.ryan.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;

import br.com.ryan.hibernate.util.HibernateUtil;
import br.com.ryan.model.pessoa.Pessoa;

public class PessoaDAO implements SalvarDAO<Pessoa> {
	
	public Pessoa obter(long chave) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Pessoa.class);
		criteria.add(Restrictions.eq("chave", chave));
		Pessoa pessoa = (Pessoa) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		
		return pessoa;
	}
	
	public List<Pessoa> pesquisar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Pessoa.class);
		List<Pessoa> pessoas = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return pessoas;
	}
	
	public void historico(long chave) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		AuditReader reader = AuditReaderFactory.get(session);
		
		List<Object[]> results = reader.createQuery()
				.forRevisionsOfEntity(Pessoa.class, false, true)
				.add(AuditEntity.id().eq(chave))
				.getResultList();
		
		for (Object[] row : results) {
			Pessoa p = (Pessoa) row[0];
			DefaultRevisionEntity rev = (DefaultRevisionEntity) row[1];
			RevisionType type = (RevisionType) row[2];
			
			System.out.println("Date: " + rev.getRevisionDate());
			System.out.println("Action: " + type);
			System.out.println("Name in this version: " + p.getNome());
			System.out.println("-----------------------------------");
		}
		
		session.close();
	}
}