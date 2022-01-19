package ru.netology.manager;

import ru.netology.domain.Movie;

import java.util.Arrays;
import java.util.Objects;

public class AfishaManager {
    private Movie[] movies = new Movie[0];
    int afishaLength = 10;

    public AfishaManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    public AfishaManager() {
    }

    public void addMovie(Movie movie) {
        int movieLength = movies.length;
        Movie[] tmpArray = new Movie[movieLength + 1];
        System.arraycopy(movies, 0, tmpArray, 0, movieLength);
        int lastId = tmpArray.length - 1;
        tmpArray[lastId] = movie;
        movies = tmpArray;
    }

    public Movie[] getLastMovieAdded() {
        int representMax = Math.min(movies.length, afishaLength);
        Movie[] film = new Movie[representMax];
        for (int currentFilm = 0; currentFilm < film.length; currentFilm++) {
            int result = movies.length - currentFilm - 1;
            film[currentFilm] = movies[result];
        }
        return film;
    }
}
