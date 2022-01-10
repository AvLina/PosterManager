package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

public class FilmManager {

    private  Film[] films = new Film[0];
    private int counterFilms;
    private FilmRepository repository;

    public FilmManager() {
        this.counterFilms = 10;
    }

    public Film[] getFilms() {
        return films;
    }

    public void setFilms(Film[] films) {
        this.films = films;
    }

    public int getCounterFilms() {
        return counterFilms;
    }

    public void setCounterFilms(int counterFilms) {
        this.counterFilms = counterFilms;
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
        Film[] films = repository.findAll();
        int resultLength;
        if (films.length >= counterFilms) {
            resultLength = counterFilms;
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
