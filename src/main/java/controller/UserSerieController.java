package controller;

import entity.UserSerie;
import org.springframework.web.bind.annotation.*;
import service.UserSerieService;

import java.util.List;

@RestController
@RequestMapping("/userSerie")
@CrossOrigin(origins = "*")
public class UserSerieController {

    private final UserSerieService userSerieService;

    public UserSerieController(UserSerieService userSerieService) {
        this.userSerieService = userSerieService;
    }

    // Añadir una serie vista por un usuario
    @PostMapping("/add/{userId}/{serieId}")
    public UserSerie addSerieToUser(@PathVariable Long userId, @PathVariable Long serieId) {
        return userSerieService.addSerieToUser(userId, serieId);
    }

    // Obtener todas las series vistas por un usuario
    @GetMapping("/user/{userId}")
    public List<UserSerie> getSeriesByUser(@PathVariable Long userId) {
        return userSerieService.getSeriesByUser(userId);
    }

    // Obtener todos los usuarios que han visto una serie
    @GetMapping("/serie/{serieId}")
    public List<UserSerie> getUsersBySerie(@PathVariable Long serieId) {
        return userSerieService.getUsersBySerie(serieId);
    }

    // Eliminar una relación usuario–serie
    @DeleteMapping("/{id}")
    public void deleteUserSerie(@PathVariable Long id) {
        userSerieService.deleteUserSerie(id);
    }
}
