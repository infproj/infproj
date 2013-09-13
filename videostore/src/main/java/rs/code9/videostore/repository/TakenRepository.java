package rs.code9.videostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.code9.videostore.model.Taken;

@Repository
public interface TakenRepository extends JpaRepository<Taken, Long> {

}
