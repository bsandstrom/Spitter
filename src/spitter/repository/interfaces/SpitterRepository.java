package spitter.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import spitter.Spitter;

public interface SpitterRepository extends JpaRepository<Spitter, Integer> {

	Spitter findById(int id);
	Spitter findByUsername(String username);
}
