package ru.netology.manager;

import ru.netology.domain.Film;

public class FilmManager {

    private  Film[] films = new Film[0];
    private int limitShowFilms = 10;

    public FilmManager() {
    }

    public FilmManager(int limitShowFilms) {
        this.limitShowFilms = limitShowFilms;
    }

    public Film[] getFilms() {
        return films;
    }

    public void setFilms(Film[] films) {
        this.films = films;
    }

    public int getLimitShowFilms() {
        return limitShowFilms;
    }

    public void setLimitShowFilms(int limitShowFilms) {
        this.limitShowFilms = limitShowFilms;
    }

     public void addingNewFilm (Film newFilm) {
         int length = films.length + 1;
         Film[] tmp = new Film[length];
         System.arraycopy(films, 0, tmp, 0, films.length);
         int lastIndex = tmp.length - 1;
         tmp[lastIndex] = newFilm;
         films = tmp;

     }

    public Film[] getLastFilm() {
        int resultLength;
        if (films.length > limitShowFilms) {
            resultLength = limitShowFilms;
        } else {
            resultLength = films.length;
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;


    }

    public void save(Film film) {
    }
}
