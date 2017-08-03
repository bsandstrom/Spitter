package spitter.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spitter.Spitter;
import spitter.Spittle;
import spitter.repository.interfaces.SpittleRepository;

@Component
public class FakeSpittleRepository implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return this.createSpittleList(count);
	}

	@Override
	public Spittle findOne(int id) {
		Spitter spitter = new Spitter("test", "test", "test", "test");
		return new Spittle(spitter, "this is test spittle number " + id, new Date());
	}
	
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++){
			Spitter spitter = new Spitter("test", "test", "test", "test");
			spittles.add(new Spittle(spitter, "Spittle " + i, new Date()));
		}
		return spittles;
	}

	@Override
	public void save(Spittle spittle) {
		// TODO Auto-generated method stub
		
	}

}
