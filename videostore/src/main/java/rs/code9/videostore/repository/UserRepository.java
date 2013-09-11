package rs.code9.videostore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.code9.videostore.model.Reserved;
import rs.code9.videostore.model.User;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {

	public User findByEmail(String email);
	
	

	@Query("select r from Reserved r where r.user.email=:email")
	public List<Reserved> getReservationsForEmail(@Param("email") String email);
	


}
