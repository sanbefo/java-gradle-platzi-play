package com.platzi.play.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 150, unique = true)
    private String title;
    @Column(nullable = false, precision = 3)
    private int duration;
    @Column(nullable = false, length = 40)
    private String genre;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(precision = 3, scale = 2)
    private BigDecimal rating;
    @Column(nullable = false, length = 1)
    private String status;
}
