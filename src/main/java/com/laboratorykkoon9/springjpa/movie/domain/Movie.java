package com.laboratorykkoon9.springjpa.movie.domain;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;

    public Movie(final String title, final Duration runningTime, final Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
    }

    public Money getFee() {
        return this.fee;
    }
}
