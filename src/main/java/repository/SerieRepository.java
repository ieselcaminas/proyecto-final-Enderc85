package repository;

import entity.Serie;
import org.springframework.data.repository.CrudRepository;

public interface SerieRepository extends CrudRepository<Serie, Long> {
    Serie findByTitle(String title);
}
