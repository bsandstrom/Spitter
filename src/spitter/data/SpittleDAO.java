package spitter.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spitter.Spittle;
import spitter.repository.interfaces.SpittleRepository;
import spitter.web.SpitterController;

@Repository
public class SpittleDAO implements SpittleRepository {
	
	private static final Logger logger = Logger.getLogger(SpitterController.class);
	
	SessionFactory sessionFactory;
	
	/*public SpittleDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Spittle> findSpittles(long max, int count) {
		return (List<Spittle>)sessionFactory.getCurrentSession().createCriteria(Spittle.class).list();
	}

	@Override
	@Transactional
	public Spittle findOne(int id) {
		return (Spittle)sessionFactory.getCurrentSession().find(Spittle.class, id);
	}

	@Override
	@Transactional
	public void save(Spittle spittle) {
		logger.debug("********saving new spittle ************");
		sessionFactory.getCurrentSession().persist(spittle);
		
	}

}
