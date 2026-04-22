package org.example.proyectofinal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   // IMPORTANT: Integer per a SQLite

    @Column(nullable = false)
    private String title;

    @Column(length = 500)
    private String description;

    private Integer year;

    // Getters i setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}
