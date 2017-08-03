package spitter.data;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spitter.Spitter;
import spitter.repository.interfaces.SpitterRepository;

@Repository
public class SpitterDAO {
	
	SessionFactory sessionFactory = null;
	
	/*public SpitterDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}*/

	//@Override
	@Transactional
	public Spitter save(Spitter spitter) {
		sessionFactory.getCurrentSession().persist(spitter);
		return spitter;
	}
	
	//@Override
	@Transactional
	public Spitter findById(int id) {
		return sessionFactory.getCurrentSession().find(Spitter.class, id);
	}

	//@Override
	@Transactional
	public Spitter findByUsername(String username) {
		return (Spitter)sessionFactory.getCurrentSession()
				.createCriteria(Spitter.class)
				.add(Restrictions.eq("username", username))
				.uniqueResult();
	}

}
