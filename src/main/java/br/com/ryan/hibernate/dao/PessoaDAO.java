package br.com.ryan.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.ryan.hibernate.util.HibernateUtil;
import br.com.ryan.model.pessoa.Pessoa;

public class PessoaDAO {
	
	public void salvar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(Math.random() + "");
		
		session.save(pessoa);
		session.getTransaction().commit();
		session.close();
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
}