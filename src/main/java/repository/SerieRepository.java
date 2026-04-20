package repository;

import entity.Serie;

import java.util.ArrayList;
import java.util.List;

public class SerieRepository {

    private final List<Serie> series = new ArrayList<>();

    public Serie findById(Long id) {
        return series.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Serie findByTitle(String title) {
        return series.stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void save(Serie serie) {
        series.add(serie);
    }

    public List<Serie> findAll() {
        return new ArrayList<>(series);
    }
}
