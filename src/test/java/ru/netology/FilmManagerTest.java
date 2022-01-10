package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.FilmManager;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    Film film1 = new Film(1, "Мальчишник в Вегасе", "url1", "comedy");
    Film film2 = new Film(2, "Дюна", "url2", "fantasy");
    Film film3 = new Film(3, "Сумерки", "url3", "fantasy");
    Film film4 = new Film(4, "Отряд самоубийц", "url4", "thriller");
    Film film5 = new Film(5, "Черный лебедь", "url5", "drama");
    Film film6 = new Film(6, "Зеленая миля", "url6", "drama");
    Film film7 = new Film(7, "Иван Васильевич меняет профессию", "url7", "comedy");
    Film film8 = new Film(8, "Криминальное чтиво", "url8", "drama");
    Film film9 = new Film(9, "Джентельмены", "url9", "comedy");
    Film film10 = new Film(10, "Брат", "url10", "drama");
    Film film11 = new Film(11, "Один дома", "url", "comedy");


    @Test
    public void all() {

        FilmRepository repository = new FilmRepository();

        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.save(film6);
        repository.save(film7);
        repository.save(film8);
        repository.save(film9);
        repository.save(film10);
        repository.save(film11);

        FilmManager manager = new FilmManager();

        Film[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        Film[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastFilmMoreTen() {

        FilmManager manager = new FilmManager();
        manager.save(film11);
        manager.save(film10);
        manager.save(film9);
        manager.save(film8);
        manager.save(film7);
        manager.save(film6);
        manager.save(film5);
        manager.save(film4);
        manager.save(film3);
        manager.save(film2);
        manager.save(film1);

        Film[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9,film10};
        Film[] actual = manager.getLastFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastFilmTen() {

        FilmManager manager = new FilmManager();
        manager.save(film10);
        manager.save(film9);
        manager.save(film8);
        manager.save(film7);
        manager.save(film6);
        manager.save(film5);
        manager.save(film4);
        manager.save(film3);
        manager.save(film2);
        manager.save(film1);

        Film[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9,film10};
        Film[] actual = manager.getLastFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveMovieById() {

        FilmRepository repository = new FilmRepository();
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);


        Film[] expected = {film1, film3};
        repository.removeById(2);
        Film[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

}