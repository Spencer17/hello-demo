package mx.com.profuturo.demoms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	public List<User> findByEmail(String email);

	public List<User> findByNameAndEmail(String name, String email);
}