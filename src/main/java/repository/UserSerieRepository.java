package repository;

import entity.UserSerie;
import entity.User;
import entity.Serie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserSerieRepository extends CrudRepository<UserSerie, Long> {
    List<UserSerie> findByUser(User user);
    List<UserSerie> findBySerie(Serie serie);
    UserSerie findByUserAndSerie(User user, Serie serie);
}
