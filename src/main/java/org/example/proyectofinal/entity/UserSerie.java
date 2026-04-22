package org.example.proyectofinal.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_series")
public class UserSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   // IMPORTANT: Integer per a SQLite

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @Column(name = "date_watched")
    private LocalDate dateWatched;

    @Column(name = "rating")
    private Integer rating;

    // Getters i setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Serie getSerie() { return serie; }
    public void setSerie(Serie serie) { this.serie = serie; }

    public LocalDate getDateWatched() { return dateWatched; }
    public void setDateWatched(LocalDate dateWatched) { this.dateWatched = dateWatched; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
}
