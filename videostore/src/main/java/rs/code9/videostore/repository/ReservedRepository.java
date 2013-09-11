package rs.code9.videostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.code9.videostore.model.Reserved;

public interface ReservedRepository extends JpaRepository<Reserved, Long> {

}
