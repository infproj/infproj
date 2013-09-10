package rs.code9.videostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.code9.videostore.model.User;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {

	public User findByEmail(String email);
}
