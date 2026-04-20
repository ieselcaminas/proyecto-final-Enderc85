package repository;

import entity.User;
import entity.Serie;
import entity.UserSerie;

import java.util.ArrayList;
import java.util.List;

public class UserSerieRepository {

    private final List<UserSerie> userSeries = new ArrayList<>();

    public List<UserSerie> findByUser(User user) {
        return userSeries.stream()
                .filter(us -> us.getUser().equals(user))
                .toList();
    }

    public List<UserSerie> findBySerie(Serie serie) {
        return userSeries.stream()
                .filter(us -> us.getSerie().equals(serie))
                .toList();
    }

    public UserSerie findByUserAndSerie(User user, Serie serie) {
        return userSeries.stream()
                .filter(us -> us.getUser().equals(user) && us.getSerie().equals(serie))
                .findFirst()
                .orElse(null);
    }

    public void save(UserSerie userSerie) {
        userSeries.add(userSerie);
    }

    public void delete(UserSerie userSerie) {
        userSeries.remove(userSerie);
    }

    public List<UserSerie> findAll() {
        return new ArrayList<>(userSeries);
    }
}
