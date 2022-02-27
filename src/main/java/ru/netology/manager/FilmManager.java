package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;


public class FilmManager {

    private  Film[] films = new Film[0];
    private int amountFilms = 10;
    private FilmRepository repository;

    public Film[] getFilms() {
        return films;
    }

    public void setFilms(Film[] films) {
        this.films = films;
    }

    public int getAmountFilms() {
        return amountFilms;
    }

    public void setAmountFilms(int amountFilms) {
        this.amountFilms = amountFilms;
    }

    public FilmManager() {
    }

    public FilmManager(int amountFilms) {
        this.amountFilms = amountFilms;
    }

    public void save (Film newFilm) {
         int length = films.length + 1;
         Film[] tmp = new Film[length];
         System.arraycopy(films, 0, tmp, 0, films.length);
         int lastIndex = tmp.length - 1;
         tmp[lastIndex] = newFilm;
         films = tmp;
     }

    public Film[] getLastFilm() {
        int resultLength;
        if (films.length >= amountFilms) {
            resultLength = amountFilms;
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
}
