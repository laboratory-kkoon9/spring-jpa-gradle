package com.laboratorykkoon9.springjpa.movie.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "movies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoxOffice {
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
}
