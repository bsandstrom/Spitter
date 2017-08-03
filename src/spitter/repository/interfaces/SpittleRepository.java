package spitter.repository.interfaces;

import java.util.List;

import spitter.Spittle;

public interface SpittleRepository {
	void save(Spittle spittle);
	List<Spittle> findSpittles(long max, int count);
	Spittle findOne(int id);
}
