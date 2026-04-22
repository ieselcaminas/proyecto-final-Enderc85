package org.example.proyectofinal.service;

import org.example.proyectofinal.entity.Serie;
import org.example.proyectofinal.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository repo;

    public SerieService(SerieRepository repo) {
        this.repo = repo;
    }

    public List<Serie> getAllSeries() {
        return repo.findAll();
    }

    public Serie findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Serie findByTitle(String title) {
        return repo.findByTitle(title);
    }

    public Serie save(Serie serie) {
        return repo.save(serie);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
