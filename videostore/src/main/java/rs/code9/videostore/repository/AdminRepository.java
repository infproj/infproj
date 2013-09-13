package rs.code9.videostore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.code9.videostore.model.Admin;
import rs.code9.videostore.model.Reserved;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	@Query("select r from Reserved r")
	public List<Reserved> getAlLReservations();
}
