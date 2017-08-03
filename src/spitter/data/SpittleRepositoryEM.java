package spitter.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spitter.Spittle;
import spitter.repository.interfaces.SpittleRepository;
import spitter.web.SpitterController;

@Repository
@Transactional()
public class SpittleRepositoryEM implements SpittleRepository {
	
	private static final Logger logger = Logger.getLogger(SpitterController.class);
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		String query = "Select s from Spittle s";
		return (List<Spittle>)em.createQuery(query).getResultList();
	}

	@Override
	public Spittle findOne(int id) {
		return em.find(Spittle.class, id);
	}

	@Override
	public void save(Spittle spittle) {
		logger.debug("********saving new spittle with entity manager ************");
		em.persist(spittle);
		
	}

}
