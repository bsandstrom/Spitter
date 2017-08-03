package spitter.data;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spitter.TestData;

@Repository
public class TestDataDAO {
	
	SessionFactory sessionFactory;

	/*
	public TestDataDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}*/
	
	@Transactional
	public void addTestData(TestData testData){
		sessionFactory.getCurrentSession().persist(testData);
	}
	
	@Transactional
	public TestData getTestDataById(long id){
		return sessionFactory.getCurrentSession().find(TestData.class, id);
	}
	
	@Transactional
	public void saveTestData(TestData testData){
		sessionFactory.getCurrentSession().merge(testData);
	}
}
