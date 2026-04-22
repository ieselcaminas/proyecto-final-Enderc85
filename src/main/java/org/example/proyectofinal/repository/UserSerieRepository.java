package org.example.proyectofinal.repository;

import org.example.proyectofinal.entity.User;
import org.example.proyectofinal.entity.Serie;
import org.example.proyectofinal.entity.UserSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSerieRepository extends JpaRepository<UserSerie, Integer> {

    List<UserSerie> findByUser(User user);

    List<UserSerie> findBySerie(Serie serie);

    UserSerie findByUserAndSerie(User user, Serie serie);
}
