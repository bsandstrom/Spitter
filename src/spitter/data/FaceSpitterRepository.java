package spitter.data;

import org.springframework.stereotype.Component;

import spitter.Spitter;
import spitter.repository.interfaces.SpitterRepository;

@Component
public class FaceSpitterRepository  {

	public Spitter save(Spitter spitter) {
		System.out.println("The spitter: " + spitter + " is pretending to be saved");
		return spitter;
	}

	public Spitter findByUsername(String username) {
		Spitter spitter = new Spitter(0, username, "testPassword", "testFirstName", "testLastName");
		return spitter;
	}

	
	public Spitter findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
