package service;

import entity.Serie;
import repository.SerieRepository;

import java.util.List;

public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    public Serie findById(Long id) {
        return serieRepository.findById(id);
    }

    public void save(Serie serie) {
        serieRepository.save(serie);
    }
}
