package lk.ac.vau.fas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.model.Art;

@Repository

public interface ArtRepo extends JpaRepository<Art,Integer> {

}
