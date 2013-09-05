package rs.code9.videostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.code9.videostore.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
