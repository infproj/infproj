package rs.code9.videostore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.code9.videostore.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("select m from Movie m where m.name = :name")
	public List<Movie> findByName(@Param("name") String name);
}
