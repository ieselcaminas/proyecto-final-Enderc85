package service;

import entity.User;
import entity.Serie;
import entity.UserSerie;
import repository.UserRepository;
import repository.SerieRepository;
import repository.UserSerieRepository;

import java.util.List;

public class UserSerieService {

    private final UserSerieRepository userSerieRepository;
    private final UserRepository userRepository;
    private final SerieRepository serieRepository;

    public UserSerieService(UserSerieRepository userSerieRepository,
                            UserRepository userRepository,
                            SerieRepository serieRepository) {
        this.userSerieRepository = userSerieRepository;
        this.userRepository = userRepository;
        this.serieRepository = serieRepository;
    }

    public void markAsViewed(User user, Serie serie) {
        UserSerie existing = userSerieRepository.findByUserAndSerie(user, serie);

        if (existing == null) {
            userSerieRepository.save(new UserSerie(user, serie));
        }
    }

    public List<UserSerie> getViewedByUser(User user) {
        return userSerieRepository.findByUser(user);
    }

    public List<UserSerie> getUsersWhoViewed(Serie serie) {
        return userSerieRepository.findBySerie(serie);
    }
}
