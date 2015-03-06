package br.com.athenas.infrastructure.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	public void cadastra(T entity) {
			sessionFactory.getCurrentSession().save(entity);
	}



	@SuppressWarnings("unchecked")
	public List<T> lista(Class<T> classType) {
		
		Query query = getCurrenteSession().createQuery("from " + classType.getName());
		
		if(query!=null){
			
			return query.list();
		}
		
		return null;
	}


	public void edita(T entity) {
		getCurrenteSession().update(entity);
	}

	public void remove(Class<T> classType,Long id) {
		@SuppressWarnings("unchecked")
		T objeto = (T)getCurrenteSession().load(classType,id);
	    getCurrenteSession().delete(objeto);
;
		
	}

	public Session getCurrenteSession() {
		return sessionFactory.getCurrentSession();
	}





}
