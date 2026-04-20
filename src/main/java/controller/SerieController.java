package controller;

import entity.Serie;
import org.springframework.web.bind.annotation.*;
import service.SerieService;

import java.util.List;

@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "*")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public List<Serie> getAllSeries() {
        return serieService.getAllSeries();
    }

    @GetMapping("/{id}")
    public Serie getSerieById(@PathVariable Long id) {
        return serieService.getSerieById(id);
    }

    @PostMapping
    public Serie createSerie(@RequestBody Serie serie) {
        return serieService.createSerie(serie);
    }

    @DeleteMapping("/{id}")
    public void deleteSerie(@PathVariable Long id) {
        serieService.deleteSerie(id);
    }
}

