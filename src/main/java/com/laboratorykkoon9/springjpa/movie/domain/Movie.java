package com.laboratorykkoon9.springjpa.movie.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Duration;

@Getter
@Entity
@Table(name = "movies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "movie_code")
    private String movieCode;

    @Column(name = "korea_movie_name")
    private String koreaMovieName;

    @Column(name = "english_movie_name")
    private String englishMovieName;

    @Column(name = "production_year")
    private String productionYear;

    @Column(name = "movie_director_name")
    private String movieDirectorName;
    @Column(name = "running_time")
    private Duration runningTime;
    @Column(name = "fee")
    private Integer fee;

    @Builder
    public Movie(Long id, String movieCode, String koreaMovieName, String englishMovieName, String productionYear, String movieDirectorName, Duration runningTime, Integer fee) {
        this.id = id;
        this.movieCode = movieCode;
        this.koreaMovieName = koreaMovieName;
        this.englishMovieName = englishMovieName;
        this.productionYear = productionYear;
        this.movieDirectorName = movieDirectorName;
        this.runningTime = runningTime;
        this.fee = fee;
    }
}
