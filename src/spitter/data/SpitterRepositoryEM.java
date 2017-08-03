package spitter.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spitter.Spitter;
import spitter.repository.interfaces.SpitterRepository;

@Repository
@Transactional()
public class SpitterRepositoryEM {
//implements SpitterRepository {
	
	private static final Logger logger = Logger.getLogger(SpitterRepositoryEM.class);
	
	@PersistenceContext
	private EntityManager em;

	//@Override
	public Spitter findById(int id) {
		return em.find(Spitter.class, id);
	}

	//@Override
	public Spitter save(Spitter spitter) {
		logger.debug("********saving new spittle with entity manager ************");
		em.persist(spitter);
		return spitter;
		
	}

	//@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return (Spitter)em.createQuery("select s from Spitter s where s.username = :username")
		.setParameter("username", username)
		.getSingleResult();
	}

}
