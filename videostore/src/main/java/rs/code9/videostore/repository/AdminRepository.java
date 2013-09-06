package rs.code9.videostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.code9.videostore.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
