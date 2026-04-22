package org.example.proyectofinal.service;

import org.example.proyectofinal.entity.Serie;
import org.example.proyectofinal.entity.User;
import org.example.proyectofinal.entity.UserSerie;
import org.example.proyectofinal.repository.UserSerieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserSerieService {

    private final UserSerieRepository repo;

    public UserSerieService(UserSerieRepository repo) {
        this.repo = repo;
    }

    public void markAsViewed(User user, Serie serie) {
        // Evitar duplicados
        UserSerie existing = repo.findByUserAndSerie(user, serie);
        if (existing != null) {
            return; // Ya está marcada como vista
        }

        UserSerie us = new UserSerie();
        us.setUser(user);
        us.setSerie(serie);
        us.setDateWatched(LocalDate.now());
        us.setRating(null); // opcional

        repo.save(us);
    }

    public List<UserSerie> getViewedByUser(User user) {
        return repo.findByUser(user);
    }

    public List<UserSerie> getUsersWhoViewed(Serie serie) {
        return repo.findBySerie(serie);
    }

    public boolean hasViewed(User user, Serie serie) {
        return repo.findByUserAndSerie(user, serie) != null;
    }

    public void deleteViewed(User user, Serie serie) {
        UserSerie us = repo.findByUserAndSerie(user, serie);
        if (us != null) {
            repo.delete(us);
        }
    }
}
